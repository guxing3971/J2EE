package dnzl.RDF_XML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import dnzl.DataFactory.RDF_Factory;
import dnzl.DataFactory.XmlFactory;

@SuppressWarnings("unused")
public class GetAllDevData_JKXL extends HeadXml {

	public static void main(String[] args) {
		//http://10.215.27.90:9001/LCAM/CisWebServicePS?WSDL
		//String address = "http://10.215.13.201:7001/LCAM/LCAMPS?wsdl";
		String address = "http://10.215.27.90:9001/LCAM/CisWebServicePS?WSDL";

		String method = "cisRequest";

		GetAllDevData_DLQ fs = new GetAllDevData_DLQ();

		List<String> xml_list = null;
		try {
			xml_list = XmlFactory.GetXMLAll_JKXLSB();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();

		org.apache.cxf.endpoint.Client client = dcf.createClient(address);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
		httpClientPolicy.setConnectionTimeout(10000);
		httpClientPolicy.setReceiveTimeout(60 * 1000 * 5);
		http.setClient(httpClientPolicy);
		Object[] res = null;
		int f_count = xml_list.size();
		int t_count = 0;
		Iterator<String> iter = xml_list.iterator();
		try {
			while (iter.hasNext()) {
				String xml = iter.next();
				// ForDebug
				File f = new File("E:\\debug\\JK\\" + String.valueOf(t_count)
						+ ".xml");
				OutputStream out = new FileOutputStream(f);
				out.write(xml.getBytes());
				out.close();
				res = client.invoke(method, xml);
				if (res[0].toString().contains("成功")) {
					t_count++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
