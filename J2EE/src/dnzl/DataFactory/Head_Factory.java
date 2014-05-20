package dnzl.DataFactory;

public class Head_Factory {
	public static String InsertData_CIM(String uri,String transactionType,String rdf_xml){
		StringBuffer xmlContents = new StringBuffer();
		xmlContents.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		xmlContents.append("<CisRequest>\n");
		xmlContents.append("<RequestHead>\n");
		xmlContents.append("<operation>insertData</operation>\n");
		xmlContents.append("<uri>" + uri + "</uri>\n");
		xmlContents.append("<sourceSystem>OMS_QH</sourceSystem>\n");
		xmlContents.append("<transactionType>" + transactionType+ "</transactionType>\n");
		xmlContents.append("</RequestHead>\n");
		xmlContents.append("<RequestBody>\n");
		xmlContents.append("<insertData>\n");
		xmlContents.append("<rowset>\n");
		
		xmlContents.append(rdf_xml);
		
		
//		xmlContents.append("<row>\n");
//		xmlContents.append("<![CDATA[" + rdfStream + "]]>\n");
//		xmlContents.append("</row>\n");
		
		
		xmlContents.append("</rowset>\n");
		xmlContents.append("</insertData>\n");
		xmlContents.append("</RequestBody>\n");
		xmlContents.append("</CisRequest>");
		return xmlContents.toString();
	}
	
	
	
	
	public static String InsertData_ESB(String uri,String transactionType,String rdf_xml){
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		strbuf.append("<CisRequest>\n");
		strbuf.append("<RequestHead>\n");
		strbuf.append("<operation>insertData</operation>\n");
		strbuf.append("<uri>"+uri+"</uri>\n");
		strbuf.append("<sourceSystem>OMS_QH</sourceSystem>\n");
		strbuf.append("<transactionType>"+transactionType+"</transactionType>\n");
		strbuf.append("</RequestHead>\n");
		strbuf.append("<RequestBody>\n");
		strbuf.append("<insertData>\n");
		strbuf.append("<rowset>\n");
		
		strbuf.append(rdf_xml);
		
//		strbuf.append("<row>");
//		strbuf.append("<![CDATA["+rdfContents+"]]>");
//		strbuf.append("</row></rowset>");
		
		strbuf.append("</insertData></RequestBody>\n");
		strbuf.append("</CisRequest>");
		return strbuf.toString();
	}
}
