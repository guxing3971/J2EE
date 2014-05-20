package dnzl.YunXing;
/**********************************************
 * 主网变压器状态切换数据
 * 
 *********************************************/


import java.sql.SQLException;
import java.util.List;

import dnzl.Core.Push_ESB_SuperClass;
import dnzl.DataFactory.XmlFactory;

public class Push_ESB_BYQZTQH extends Push_ESB_SuperClass{
	
	public List<String> xmlContents() throws SQLException{
		return XmlFactory.GetXMLAll_ZBZT();
	}

	@Override
	public void initData() {
		List<String> list = null;
		try {
			list = xmlContents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list == null  || list.size() == 0){
			this.IsLog(false);
			this.IsNeed(false);
		}else{
			this.setXmlContents(list);
		}
	}
	
	public static void main(String[] args){
		Push_ESB_BYQZTQH task = new Push_ESB_BYQZTQH();
		Thread thr = new Thread(task);
		thr.start();
	}
	}
	
	
	
	

//	@Override
//	public void initData() {
//		this.setXmlContents(insertData());
//	}
//
//	public String insertData() {
//		/**
//		 * Parameters:
//				name 变压器名
//				mrid 资源标识
//				equipCode 变压器编码
//				name1 所属单位名称
//				mRID1 所属单位编码
//				value 状态切换时刻 
//				value1 高压端有功 
//				value2 中压端有功 
//				value3 低压端有功
//				value4 高压侧分接头位置 
//				value5 中压侧分接头位置 
//				value6 切换前高压侧状态 
//				value7 切换后高压侧状态 
//				value8 切换前中压侧状态 
//				value9 切换后中压侧状态
//				value10 切换前低压侧状态
//				value11 切换后低压侧状态
//		 */
//		String rdfContents = new RDF_Factory().GetRDF_ZWBYQZHQH("111", "111", "111",
//				"111", "111", "2013-06-13", "111", "11", "11", "11", "11",
//				"11", "11", "11", "11", "11", "11");
//		String xmlContents = new ESB_Factory("http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_05_W",
//				"OMS_QH","single",rdfContents).InsertData();
//
////////////////////////////////////////////////////////////////////////////////////////////////////////
//// for test send soap message
////////////////////////////////////////////////////////////////////////////////////////////////////////
//		@SuppressWarnings("unused")
//		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//		"<CisRequest>\n" + 
//		"\t<RequestHead>\n" + 
//		"\t\t<operation>insertData</operation>\n" + 
//		"\t\t<uri>http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_04_W</uri>\n" + 
//		"        <sourceSystem>OMS_QH</sourceSystem>\n" + 
//		"        <transactionType>single</transactionType>\n" + 
//		"\t</RequestHead>\n" + 
//		"\t<RequestBody>\n" + 
//		"\t\t<insertData>\n" + 
//		"\t\t\t<rowset>\n" + 
//		"\t\t\t\t<row>\n" + 
//		"\t\t\t\t\t<![CDATA[\n" + 
//		"\n" + 
//		"\n" + 
//		"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" + 
//		" <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">\n" + 
//		" <cim:Line rdf:ID=\"Line@%LineId%\">\n" + 
//		"  <cim:IdentifiedObject.name>1</cim:IdentifiedObject.name>\n" + 
//		" <!-- 线路名-->\n" + 
//		"  <cim:PowerSystemResource.equipCode>1</cim:PowerSystemResource.equipCode>\n" + 
//		" <!-- 线路编码-->\n" + 
//		"  <cim:PowerSystemResource.AssetRoles rdf:resource=\"#AssetPsrRole@%AssetRolesId%\" />\n" + 
//		" <!-- add by typing 20120613-->\n" + 
//		"  <cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\" />\n" + 
//		" <!-- add by typing 20120613-->\n" + 
//		"  <cim:IdentifiedObject.recordStatus>1</cim:IdentifiedObject.recordStatus>\n" + 
//		" <!-- 操作标识  新增20121102-->\n" + 
//		"  <cim:IdentifiedObject.timeStamp>2013-06-03 06:22:20</cim:IdentifiedObject.timeStamp>\n" + 
//		" <!-- 时间戳  新增20121102-->\n" + 
//		"  </cim:Line>\n" + 
//		" <!-- add by typing 20120613-->\n" + 
//		" <cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">\n" + 
//		"  <cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\" />\n" + 
//		"  </cim:OrgPsrRole>\n" + 
//		" <cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">\n" + 
//		"  <cim:IdentifiedObject.name>1</cim:IdentifiedObject.name>\n" + 
//		" <!-- 所属单位名称-->\n" + 
//		"  <cim:IdentifiedObject.mRID>1</cim:IdentifiedObject.mRID>\n" + 
//		" <!-- 所属单位编码-->\n" + 
//		"  </cim:ErpOrganisation>\n" + 
//		" <!-- add by typing 20120613-->\n" + 
//		" <cim:AssetPsrRole rdf:ID=\"AssetPsrRole@%AssetRolesId%\">\n" + 
//		"  <cim:AssetPsrRole.Asset rdf:resource=\"#Asset@%AssetId%\" />\n" + 
//		"  </cim:AssetPsrRole>\n" + 
//		" <cim:Asset rdf:ID=\"Asset@%AssetId%\">\n" + 
//		"  <cim:Asset.Properties rdf:resource=\"#UserAttribute@%PropertiesId%\" />\n" + 
//		"  <cim:Asset.Properties1 rdf:resource=\"#UserAttribute@%Properties1Id%\" />\n" + 
//		"  <cim:Asset.Properties2 rdf:resource=\"#UserAttribute@%Properties2Id%\" />\n" + 
//		"  <cim:Asset.Properties3 rdf:resource=\"#UserAttribute@%Properties3Id%\" />\n" + 
//		"  <cim:Asset.Properties4 rdf:resource=\"#UserAttribute@%Properties4Id%\" />\n" + 
//		"  </cim:Asset>\n" + 
//		" <cim:UserAttribute rdf:ID=\"UserAttribute@%PropertiesId%\">\n" + 
//		"  <cim:UserAttribute.value>1</cim:UserAttribute.value>\n" + 
//		" <!-- 状态切换时刻-->\n" + 
//		"  </cim:UserAttribute>\n" + 
//		" <cim:UserAttribute rdf:ID=\"UserAttribute@%Properties1Id%\">\n" + 
//		"  <cim:UserAttribute.value>1</cim:UserAttribute.value>\n" + 
//		" <!-- 切换前I端状态-->\n" + 
//		"  </cim:UserAttribute>\n" + 
//		" <cim:UserAttribute rdf:ID=\"UserAttribute@%Properties2Id%\">\n" + 
//		"  <cim:UserAttribute.value>1</cim:UserAttribute.value>\n" + 
//		" <!-- 切换后I端状态-->\n" + 
//		"  </cim:UserAttribute>\n" + 
//		" <cim:UserAttribute rdf:ID=\"UserAttribute@%Properties3Id%\">\n" + 
//		"  <cim:UserAttribute.value>1</cim:UserAttribute.value>\n" + 
//		" <!-- 切换前J端状态-->\n" + 
//		"  </cim:UserAttribute>\n" + 
//		" <cim:UserAttribute rdf:ID=\"UserAttribute@%Properties4Id%\">\n" + 
//		"  <cim:UserAttribute.value>1</cim:UserAttribute.value>\n" + 
//		" <!-- 切换后J端状态-->\n" + 
//		"  </cim:UserAttribute>\n" + 
//		"  </rdf:RDF>\n" + 
//		"\t\t\t\t\t]]>\n" + 
//		"\t\t\t\t</row>\n" + 
//		"\t\t\t</rowset>\n" + 
//		"\t\t</insertData>\n" + 
//		"\t</RequestBody>\n" + 
//		"</CisRequest>";
//		
//		return xmlContents;
//	}
//	
//	public static void main(String[] args){
//		dnzl.YunXing.Push_ESB_BYQZTQH task = 
//				new dnzl.YunXing.Push_ESB_BYQZTQH();
//		Thread th = new Thread(task);
//		th.start();
//	}
//}
