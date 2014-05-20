package dnzl.RDF_XML;

public class HeadXml extends db{
	public static  String InsertData(String uri,String record){
		StringBuffer xmlContents = new StringBuffer();
		
		xmlContents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		xmlContents.append("<CisRequest>\n");
		xmlContents.append("\t<RequestHead>\n");
		xmlContents.append("\t\t<operation>insertData</operation>\n");
		xmlContents.append("\t\t<uri>" + uri + "</uri>\n");
		xmlContents.append("\t\t<sourceSystem>OMS_QH</sourceSystem>\n");
		xmlContents.append("\t\t<transactionType>all</transactionType>\n");
		xmlContents.append("\t</RequestHead>\n");
		xmlContents.append("\t<RequestBody>\n");
		xmlContents.append("\t\t<insertData>\n");
		xmlContents.append("\t\t\t<rowset>\n");
		xmlContents.append(record);
		xmlContents.append("\t\t\t</rowset>\n");
		xmlContents.append("\t\t</insertData>\n");
		xmlContents.append("\t</RequestBody>\n");
		xmlContents.append("</CisRequest>");
		return xmlContents.toString();
	}
}
