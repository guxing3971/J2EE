package dnzl.tools;

import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import dnzl.DataFactory.XmlFactory;
/******************************************************************************
 * 
 * @summary  用于手动推送数据
 *****************************************************************************/
public class PushAllData_DWPL {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmm");

	private static TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");
	
	private static String start_time ="2014-02-26 19:00:00";
	
	private static String end_time ="2014-02-27 02:00:00";
	
	public static void main(String[] args) {
		String address = "http://10.215.27.90:9001/LCAM/CisWebServicePS?WSDL";
		String method = "cisRequest";
		
		
		String sql = "SELECT recordid,companyid, companyName,"
				+ " Count_date, toplimit_CD, lowerlimit_CD, toplimit, "
				+ "toplimit_time, lowerlimit, lowerlimit_time, percents,YearTopLimit_CD,YearLowerLimit_CD,YearPercents "
				+ " FROM dnzlZHILIANG.HandleResult_DWPL "
				+ " where to_date(TO_CHAR(COUNT_DATE,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss') >"
				+ " TO_DATE('"+start_time+"','yyyy-MM-dd HH:mi:ss') and " 
				+ "to_date(TO_CHAR(COUNT_DATE,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss')  <= "
				+ " TO_DATE('"+end_time+"','yyyy-MM-dd HH:mi:ss')";
		
		System.out.println(sql);
		sdf.setTimeZone(timezone);
		
		List<String> xml_list = null;
		try {
			XmlFactory.DWPL =sql;
			xml_list = XmlFactory.GetXMLAll_DWPL();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		Object[] res = null;
		int F_Count = 0;
		int T_Count = 0;
		Iterator<String> iter = xml_list.iterator();
		try {
			while (iter.hasNext()) {
				String xml = iter.next();
				SAXBuilder builder = new SAXBuilder();
				Document doc = builder.build(new ByteArrayInputStream(xml
						.getBytes()));
				Element root = doc.getRootElement();
				List<Element> list = root.getChild("RequestBody").getChild("insertData").getChild("rowset")
						.getChildren("row");
				F_Count = list.size();
				if(!(F_Count == 0)){
					JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
					org.apache.cxf.endpoint.Client client = dcf.createClient(address);
					HTTPConduit http = (HTTPConduit) client.getConduit();
					HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
					httpClientPolicy.setConnectionTimeout(10000);
					httpClientPolicy.setReceiveTimeout(60 * 1000 * 5);
					http.setClient(httpClientPolicy);
					res = client.invoke(method, xml);
					if (res[0].toString().contains("成功")) {
						T_Count = F_Count;
					} else {
						T_Count = 0;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("需要插入记录书:" + F_Count + "\t实际插入记录数:" + T_Count);
	}
}
