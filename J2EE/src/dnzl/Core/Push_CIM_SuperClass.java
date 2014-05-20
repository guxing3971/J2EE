package dnzl.Core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import dnzl.Core.db.PushVO;

@SuppressWarnings("unused")
public class Push_CIM_SuperClass extends Push_Task_SuperClass {

	private String address = "http://10.215.27.90:9001/LCAM/CisWebServicePS?WSDL";

	private String qnameSpace = "http://www.sgcc.com.cn/drmt/service/cisWebserviceV1";

	private String method = "cisRequest";

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	
	private TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");

	private List<String> xmlContents = null;

	@Override
	public synchronized boolean Push(PushVO vo) {

		boolean flag = false;

		int F_Count = 0;
		int T_Count = 0;

		List<String> res_list = new ArrayList<String>();
		Object[] res = null;
		try {
			
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			// ----------------------------------------------------------------------
			// see wsdl address is valid (wsdl services elements)
			// if wsdlURL: http://Ip:port/Service?wsdl. Open IE
			// if wsdlURL: http://Host:port/Service?wsdl. add mapping is
			// hosts file
			// ----------------------------------------------------------------------
			Client client = dcf.createClient(address);
			HTTPConduit http = (HTTPConduit) client.getConduit();
			HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
			httpClientPolicy.setConnectionTimeout(10000);
			httpClientPolicy.setAllowChunking(false);
			httpClientPolicy.setReceiveTimeout(60 * 1000 * 5);
			http.setClient(httpClientPolicy);
			Iterator<String> iter = xmlContents.iterator();
			while (iter.hasNext()) {

				String xml = iter.next();
				SAXBuilder builder = new SAXBuilder();
				Document doc = builder.build(new ByteArrayInputStream(xml.getBytes()));
				Element root = doc.getRootElement();
				List<Element> list = root.getChild("RequestBody").getChild("insertData").getChild("rowset").getChildren("row");
				F_Count = list.size();
				if (F_Count == 0) {
					this.IsLog(false);
					this.IsNeed(false);
					return false;
				} else {
					//writetofile(xml);
					res = client.invoke(method, xml);
					resulttofile(res[0].toString());
					if (res[0].toString().contains("成功")) {
						flag = true;
						T_Count = F_Count;
					} else {
						flag = false;
						T_Count = 0;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			log.setF_count(String.valueOf(F_Count));
			log.setT_count(String.valueOf(T_Count));
		}
		System.out.println(this.getClass().getSimpleName()
				+ "\tCIM ->需要推送的数据条数:" + F_Count + "\t实际推送的数据:" + T_Count);
		return flag;
	}

	public List<String> getXmlContents() {
		return xmlContents;
	}

	public void setXmlContents(List<String> xmlContents) {
		this.xmlContents = xmlContents;
	}

	public void writetofile(String xml) throws IOException {
		sdf.setTimeZone(timezone);
		String file_name = "/datafile/dnzl/push/"+ this.getClass().getSimpleName() + "_"+ sdf.format(new Date()) + ".xml";
		File f = new File(file_name);
		if (!(f.exists())) {
			f.createNewFile();
		}
		OutputStream out = new FileOutputStream(f,true);
		out.write(xml.getBytes());
		out.close();
	}

	public  void resulttofile(String xml) throws IOException {
		sdf.setTimeZone(timezone);
		String file_name = "/datafile/dnzl/push/"+ this.getClass().getSimpleName() + "_"+ sdf.format(new Date()) + "_rest.xml";
		File f = new File(file_name);
		if (!(f.exists())) {
			f.createNewFile();
		}
		OutputStream out = new FileOutputStream(f,true);
		out.write(xml.getBytes());
		out.close();
	}	
	
}
