package dnzl.RDF_XML;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import dnzl.DataFactory.RDF_Factory;
import dnzl.DataFactory.XmlFactory;

@SuppressWarnings("unused")
public class GetAllDevData_DLQ extends HeadXml {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmm");

	private static TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");
	
	public static void main(String[] args) {
		//http://10.215.27.90:9001/LCAM/CisWebServicePS?WSDL
		//String address = "http://10.215.13.205:7001/services/CisWebService?wsdl";
		String address = "http://10.215.27.90:9001/LCAM/CisWebServicePS?WSDL";
		String method = "cisRequest";
		
		sdf.setTimeZone(timezone);
		
		List<String> xml_list = null;
		try {
			xml_list = XmlFactory.GetXMLAll_DLQSB();
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
				List<Element> list = root.getChild("RequestBody")
						.getChild("insertData").getChild("rowset")
						.getChildren("row");
				F_Count = list.size();
				if(!(F_Count == 0)){
					writetofile(xml);
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
	
	public static void writetofile(String xml) throws IOException{
		String str_time = sdf.format(new Date());
		String file_name = "/datafile/dnzl/taizhang/dlq/"+"dlq_"+str_time+".xml";
		File f = new File(file_name);
		if(!(f.exists())){
			f.createNewFile();
		}
		OutputStream out = new FileOutputStream(f);
		out.write(xml.getBytes());
		out.close();
	}
}
