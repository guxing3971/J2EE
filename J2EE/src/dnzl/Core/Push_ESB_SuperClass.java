package dnzl.Core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import dnzl.Core.db.PushVO;

@SuppressWarnings("unused")
public class Push_ESB_SuperClass extends Push_Task_SuperClass {

	// no regedit
	// private String address =
	// "http://10.215.28.188:3000/MWBusinessModel/services/doEsbMessage?wsdl";

	private String address = "http://10.215.213.180:3000/MWBusinessModel/services/doEsbMessage?wsdl";

	private String method = "doEsbMessage";

	private List<String> xmlContents = null;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

	private TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");

	@Override
	public synchronized boolean Push(PushVO vo) {
		boolean flag = false;
		initData();

		int F_Count = 0;
		int T_Count = 0;

		List<String> res_list = new ArrayList<String>();
		Object[] res = null;
		if(res_list.size() > 0){
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			org.apache.cxf.endpoint.Client client = dcf.createClient(address);
			HTTPConduit http = (HTTPConduit) client.getConduit();
			HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
			httpClientPolicy.setConnectionTimeout(10000);
			httpClientPolicy.setReceiveTimeout(60 * 1000 * 5);
			http.setClient(httpClientPolicy);
			Iterator<String> iter = xmlContents.iterator();
			
			try{
			while (iter.hasNext()) {
				String xml = iter.next();
				SAXBuilder builder = new SAXBuilder();
				Document doc = builder.build(new ByteArrayInputStream(xml.getBytes()));
				Element root = doc.getRootElement();
				List<Element> list = root.getChild("RequestBody").getChild("insertData").getChild("rowset").getChildren("row");
				F_Count += list.size();
				if (F_Count == 0) {
					this.IsLog(false);
					this.IsNeed(false);
					return false;
				} else {
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
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			
		}

		System.out.println(this.getClass().getSimpleName()
				+ "\tCIM ->需要推送的数据条数:" + F_Count + "\t实际推送的数据:" + T_Count);
		return flag;
	}

	public void initData() {

	}

	public List<String> getXmlContents() {
		return xmlContents;
	}



	public void setXmlContents(List<String> xmlContents) {
		this.xmlContents = xmlContents;
	}

	
	public synchronized void Errorlog(String errmsg) {
		String file_name = "/datafile/dnzl/esb/esb_error.log";
		File f = new File(file_name);
		if (!(f.exists())) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			OutputStream out = new FileOutputStream(f, true);
			String str = "<!--" + this.getClass().getSimpleName() + "__"+ new Date() + "-->\n";
			out.write(str.getBytes());
			out.write(errmsg.getBytes());
			out.write("\n".getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public void logfile(String index, String xml) {
		String strcalss = this.getClass().getSimpleName();
		String file_name = "/datafile/dnzl/esb/esb" + strcalss + "_" + index
				+ "_" + sdf.format(new Date()) + ".xml";
		File f = new File(file_name);
		if (!(f.exists())) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			OutputStream out = new FileOutputStream(f);
			out.write(xml.getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
