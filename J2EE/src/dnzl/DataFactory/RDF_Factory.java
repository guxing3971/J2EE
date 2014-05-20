package dnzl.DataFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/******************************************
 * 主要功能:
 * 		用于统一的提供RDF XML文件内容
 *
 *****************************************/
public class RDF_Factory {
	/**
	 * 时间
	 */
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public RDF_Factory() {
		TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai"); 
		sdf.setTimeZone(timezone);
	}
	/**
	 * 电网频率
	 * @param code		单位编码
	 * @param name		所属单位名称
	 * @param mrid		 资源标识
	 * @param ddate		统计日期
	 * @param over_up_time	上一小时责任频率越上限时间总长
	 * @param over_low_time	上一小时责任频率越下限时间总长
	 * @param max_value		上一小时最高频率
	 * @param max_time		最高频率发生时刻
	 * @param min_value		上一小时最低频率
	 * @param min_time		最低频率发生时刻
	 * @param valid_rate	上一小时责任频率合格率
	 * @param year_toplimit_time	年累计责任频率越上限时间总长
	 * @param year_lowerlimit_time	年累计责任频率越下限时间总长
	 * @param year_toplimit_time	频率合格率
	 * @return
	 */
	public String GetRDF_DWPL(String code, String name, String mrid, String ddate,
			String over_up_time, String over_low_time, String max_value,
			String max_time, String min_value, String min_time,
			String valid_rate,String year_toplimit_time,
			String year_lowerlimit_time,String year_percents){
		StringBuffer strbuf = new StringBuffer();
		
/*
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
<rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" xmlns:cim="http://iec.ch/TC57/2009/CIM-schema-cim14#">
	<cim:ErpOrganisation rdf:ID="ErpOrganisation@%ErpOrganisationId%">
		<cim:ErpOrganisation.code>%code%</cim:ErpOrganisation.code>
		<!--单位编码-->
		<cim:ErpOrganisation.name>%name%</cim:ErpOrganisation.name>
		<!--所属单位名称-->
		<cim:IdentifiedObject.mrid>%mrid%</cim:IdentifiedObject.mrid>
		<!--资源标识-->
		<cim:IdentifiedObject.recordStatus>%recordStatus%</cim:IdentifiedObject.recordStatus>
		<!--操作标识  新增20121102-->
		<cim:IdentifiedObject.timeStamp>%timeStamp%</cim:IdentifiedObject.timeStamp>
		<!--时间戳  新增20121102-->
		<cim:ErpOrganisation.AssetRoles rdf:resource="#OrgAssetRole@%AssetRolesId%"/>
	</cim:ErpOrganisation>
	<cim:OrgAssetRole rdf:ID="OrgAssetRole@%AssetRolesId%">
		<cim:OrgAssetRole.Asset rdf:resource="#Asset@%AssetId%"/>
	</cim:OrgAssetRole>
	<cim:Asset rdf:ID="Asset@%AssetId%">
		<cim:Asset.Properties rdf:resource="#UserAttribute@%PropertiesId%"/>
		<cim:Asset.Properties1 rdf:resource="#UserAttribute@%Properties1Id%"/>
		<cim:Asset.Properties2 rdf:resource="#UserAttribute@%Properties2Id%"/>
		<cim:Asset.Properties3 rdf:resource="#UserAttribute@%Properties3Id%"/>
		<cim:Asset.Properties4 rdf:resource="#UserAttribute@%Properties4Id%"/>
		<cim:Asset.Properties5 rdf:resource="#UserAttribute@%Properties5Id%"/>
		<cim:Asset.Properties6 rdf:resource="#UserAttribute@%Properties6Id%"/>
		<cim:Asset.Properties7 rdf:resource="#UserAttribute@%Properties7Id%"/>
		<cim:Asset.Properties8 rdf:resource="#UserAttribute@%Properties8Id%"/>
		<cim:Asset.Properties9 rdf:resource="#UserAttribute@%Properties9Id%"/>
		<cim:Asset.Properties10 rdf:resource="#UserAttribute@%Properties10Id%"/>
	</cim:Asset>
	<cim:UserAttribute rdf:ID="UserAttribute@%PropertiesId%">
		<cim:UserAttribute.value>%value%</cim:UserAttribute.value>
		<!--统计日期-->
	</cim:UserAttribute>
	<cim:UserAttribute rdf:ID="UserAttribute@%Properties1Id%">
		<cim:UserAttribute.value1>%value1%</cim:UserAttribute.value1>
		<!--上一小时责任频率越上限时间总长-->
	</cim:UserAttribute>
	<cim:UserAttribute rdf:ID="UserAttribute@%Properties2Id%">
		<cim:UserAttribute.value2>%value2%</cim:UserAttribute.value2>
		<!--上一小时责任频率越下限时间总长-->
	</cim:UserAttribute>
	<cim:UserAttribute rdf:ID="UserAttribute@%Properties3Id%">
		<cim:UserAttribute.value3>%value3%</cim:UserAttribute.value3>
		<!--上一小时最高频率-->
	</cim:UserAttribute>
	<cim:UserAttribute rdf:ID="UserAttribute@%Properties4Id%">
		<cim:UserAttribute.value4>%value4%</cim:UserAttribute.value4>
		<!--最高频率发生时刻-->
	</cim:UserAttribute>
	<cim:UserAttribute rdf:ID="UserAttribute@%Properties5Id%">
		<cim:UserAttribute.value5>%value5%</cim:UserAttribute.value5>
		<!--上一小时最低频率-->
	</cim:UserAttribute>
	<cim:UserAttribute rdf:ID="UserAttribute@%Properties6Id%">
		<cim:UserAttribute.value6>%value6%</cim:UserAttribute.value6>
		<!--最低频率发生时刻-->
	</cim:UserAttribute>
	<cim:UserAttribute rdf:ID="UserAttribute@%Properties7Id%">
		<cim:UserAttribute.value7>%value7%</cim:UserAttribute.value7>
		<!--上一小时责任频率合格率-->
	</cim:UserAttribute>
	<cim:UserAttribute rdf:ID="UserAttribute@%Properties8Id%">
		<cim:UserAttribute.value8>%value8%</cim:UserAttribute.value8>
		<!--年累计责任频率越上限时间总长-->
	</cim:UserAttribute>
	<cim:UserAttribute rdf:ID="UserAttribute@%Properties9Id%">
		<cim:UserAttribute.value9>%value9%</cim:UserAttribute.value9>
		<!--年累计责任频率越下限时间总长-->
	</cim:UserAttribute>
	<cim:UserAttribute rdf:ID="UserAttribute@%Properties10Id%">
		<cim:UserAttribute.value10>%value10%</cim:UserAttribute.value10>
		<!--年累计责任频率合格率-->
	</cim:UserAttribute>
</rdf:RDF>
*/
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		strbuf.append("<cim:ErpOrganisation.code>" + code + "</cim:ErpOrganisation.code>");
		strbuf.append("<cim:ErpOrganisation.name>" + name + "</cim:ErpOrganisation.name>");
		strbuf.append("<cim:IdentifiedObject.mrid>" + mrid + "</cim:IdentifiedObject.mrid>");
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		strbuf.append("<cim:IdentifiedObject.timeStamp>"+ sdf.format(new Date()) + "</cim:IdentifiedObject.timeStamp>");
		strbuf.append("<cim:ErpOrganisation.AssetRoles rdf:resource=\"#OrgAssetRole@%AssetRolesId%\"/>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("<cim:OrgAssetRole rdf:ID=\"OrgAssetRole@%AssetRolesId%\">");
		strbuf.append("<cim:OrgAssetRole.Asset rdf:resource=\"#Asset@%AssetId%\"/>");
		strbuf.append("</cim:OrgAssetRole>");
		strbuf.append("<cim:Asset rdf:ID=\"Asset@%AssetId%\">");
		strbuf.append("<cim:Asset.Properties rdf:resource=\"#UserAttribute@%PropertiesId%\"/>");
		strbuf.append("<cim:Asset.Properties1 rdf:resource=\"#UserAttribute@%Properties1Id%\"/>");
		strbuf.append("<cim:Asset.Properties2 rdf:resource=\"#UserAttribute@%Properties2Id%\"/>");
		strbuf.append("<cim:Asset.Properties3 rdf:resource=\"#UserAttribute@%Properties3Id%\"/>");
		strbuf.append("<cim:Asset.Properties4 rdf:resource=\"#UserAttribute@%Properties4Id%\"/>");
		strbuf.append("<cim:Asset.Properties5 rdf:resource=\"#UserAttribute@%Properties5Id%\"/>");
		strbuf.append("<cim:Asset.Properties6 rdf:resource=\"#UserAttribute@%Properties6Id%\"/>");
		strbuf.append("<cim:Asset.Properties7 rdf:resource=\"#UserAttribute@%Properties7Id%\"/>");
		strbuf.append("<cim:Asset.Properties8 rdf:resource=\"#UserAttribute@%Properties8Id%\"/>");
		strbuf.append("<cim:Asset.Properties9 rdf:resource=\"#UserAttribute@%Properties9Id%\"/>");
		strbuf.append("<cim:Asset.Properties10 rdf:resource=\"#UserAttribute@%Properties10Id%\"/>");
		strbuf.append("</cim:Asset>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%PropertiesId%\">");
		strbuf.append("<cim:UserAttribute.value>" + ddate + "</cim:UserAttribute.value>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties1Id%\">");
		strbuf.append("<cim:UserAttribute.value1>" + over_up_time + "</cim:UserAttribute.value1>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties2Id%\">");
		strbuf.append("<cim:UserAttribute.value2>" + over_low_time + "</cim:UserAttribute.value2>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties3Id%\">");
		strbuf.append("<cim:UserAttribute.value3>" + max_value + "</cim:UserAttribute.value3>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties4Id%\">");
		strbuf.append("<cim:UserAttribute.value4>" + max_time + "</cim:UserAttribute.value4>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties5Id%\">");
		strbuf.append("<cim:UserAttribute.value5>" + min_value + "</cim:UserAttribute.value5>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties6Id%\">");
		strbuf.append("<cim:UserAttribute.value6>" + min_time + "</cim:UserAttribute.value6>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties7Id%\">");
		strbuf.append("<cim:UserAttribute.value7>" + valid_rate + "</cim:UserAttribute.value7>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties8Id%\">");
		strbuf.append("<cim:UserAttribute.value8>" + year_toplimit_time + "</cim:UserAttribute.value8>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties9Id%\">");
		strbuf.append("<cim:UserAttribute.value9>" + year_lowerlimit_time + "</cim:UserAttribute.value9>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties10Id%\">");
		strbuf.append("<cim:UserAttribute.value10>" + year_percents + "</cim:UserAttribute.value10>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
		
		return strbuf.toString();		
//		StringBuffer strbuf = new StringBuffer();
//		
//		strbuf.append("<![CDATA[");
//		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
//				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
//		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
//		strbuf.append("<cim:ErpOrganisation.code>" + code + "</cim:ErpOrganisation.code>");
//		strbuf.append("<cim:ErpOrganisation.name>" + name + "</cim:ErpOrganisation.name>");
//		strbuf.append("<cim:IdentifiedObject.mrid>" + mrid + "</cim:IdentifiedObject.mrid>");
//		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
//		strbuf.append("<cim:IdentifiedObject.timeStamp>"+ sdf.format(new Date()) + "</cim:IdentifiedObject.timeStamp>");
//		strbuf.append("<cim:ErpOrganisation.AssetRoles rdf:resource=\"#OrgAssetRole@%AssetRolesId%\"/>");
//		strbuf.append("</cim:ErpOrganisation>");
//		strbuf.append("<cim:OrgAssetRole rdf:ID=\"OrgAssetRole@%AssetRolesId%\">");
//		strbuf.append("<cim:OrgAssetRole.Asset rdf:resource=\"#Asset@%AssetId%\"/>");
//		strbuf.append("</cim:OrgAssetRole>");
//		strbuf.append("<cim:Asset rdf:ID=\"Asset@%AssetId%\">");
//		strbuf.append("<cim:Asset.Properties rdf:resource=\"#UserAttribute@%PropertiesId%\"/>");
//		strbuf.append("<cim:Asset.Properties1 rdf:resource=\"#UserAttribute@%Properties1Id%\"/>");
//		strbuf.append("<cim:Asset.Properties2 rdf:resource=\"#UserAttribute@%Properties2Id%\"/>");
//		strbuf.append("<cim:Asset.Properties3 rdf:resource=\"#UserAttribute@%Properties3Id%\"/>");
//		strbuf.append("<cim:Asset.Properties4 rdf:resource=\"#UserAttribute@%Properties4Id%\"/>");
//		strbuf.append("<cim:Asset.Properties5 rdf:resource=\"#UserAttribute@%Properties5Id%\"/>");
//		strbuf.append("<cim:Asset.Properties6 rdf:resource=\"#UserAttribute@%Properties6Id%\"/>");
//		strbuf.append("<cim:Asset.Properties7 rdf:resource=\"#UserAttribute@%Properties7Id%\"/>");
//		strbuf.append("</cim:Asset>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%PropertiesId%\">");
//		strbuf.append("<cim:UserAttribute.value>" + ddate.substring(0, 10) + "</cim:UserAttribute.value>");
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties1Id%\">");
//		strbuf.append("<cim:UserAttribute.value1>" + over_up_time + "</cim:UserAttribute.value1>");
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties2Id%\">");
//		strbuf.append("<cim:UserAttribute.value2>" + over_low_time + "</cim:UserAttribute.value2>");
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties3Id%\">");
//		strbuf.append("<cim:UserAttribute.value3>" + max_value + "</cim:UserAttribute.value3>");
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties4Id%\">");
//		strbuf.append("<cim:UserAttribute.value4>" + max_time + "</cim:UserAttribute.value4>");
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties5Id%\">");
//		strbuf.append("<cim:UserAttribute.value5>" + min_value + "</cim:UserAttribute.value5>");
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties6Id%\">");
//		strbuf.append("<cim:UserAttribute.value6>" + min_time + "</cim:UserAttribute.value6>");
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties7Id%\">");
//		strbuf.append("<cim:UserAttribute.value7>" + valid_rate + "</cim:UserAttribute.value7>");
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("</rdf:RDF>");
//		strbuf.append("]]>\n");
//		
//		return strbuf.toString();

	}
	/**
	 * 母线电压
	 * @param orga_name
	 * @param orga_id
	 * @param mrid
	 * @param name
	 * @param code
	 * @param ddate
	 * @param run_time
	 * @param over_up_time
	 * @param over_low_time
	 * @param max_value
	 * @param max_time
	 * @param min_value
	 * @param min_time
	 * @param valid_rate
	 * @return
	 */
	public String GetRDF_MXDY(String orga_name, String orga_id, String mrid,
			String name, String code, String ddate, String run_time,
			String over_up_time, String over_low_time, String max_value,
			String max_time, String min_value, String min_time,
			String valid_rate){
	
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:BusbarLine rdf:ID=\"BusbarLine@%BusbarLineId%\">");
		strbuf.append("<cim:IdentifiedObject.name>" + name + "</cim:IdentifiedObject.name>");
		strbuf.append("<cim:IdentifiedObject.mrid>" + mrid + "</cim:IdentifiedObject.mrid>");
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		strbuf.append("<cim:IdentifiedObject.timeStamp>" + sdf.format(new Date()) + "</cim:IdentifiedObject.timeStamp>");
		strbuf.append("<cim:PowerSystemResource.equipCode>" + code + "</cim:PowerSystemResource.equipCode>");
		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+code.replaceAll("\\D", "")+"</cim:PowerSystemResource.voltageGrade>");
		strbuf.append("<cim:PowerSystemResource.AssetRoles rdf:resource=\"#AssetPsrRole@%AssetRolesId%\"/>");
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("</cim:BusbarLine>");
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		strbuf.append("<cim:IdentifiedObject.name1>" + orga_name + "</cim:IdentifiedObject.name1>");
		strbuf.append("<cim:IdentifiedObject.mRID1>" + orga_id + "</cim:IdentifiedObject.mRID1>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("<cim:AssetPsrRole rdf:ID=\"AssetPsrRole@%AssetRolesId%\">");
		strbuf.append("<cim:AssetPsrRole.Asset rdf:resource=\"#Asset@%AssetId%\"/>");
		strbuf.append("</cim:AssetPsrRole>");
		strbuf.append("<cim:Asset rdf:ID=\"Asset@%AssetId%\">");
		strbuf.append("<cim:Asset.Properties rdf:resource=\"#UserAttribute@%PropertiesId%\"/>");
		strbuf.append("<cim:Asset.Properties1 rdf:resource=\"#UserAttribute@%Properties1Id%\"/>");
		strbuf.append("<cim:Asset.Properties2 rdf:resource=\"#UserAttribute@%Properties2Id%\"/>");
		strbuf.append("<cim:Asset.Properties3 rdf:resource=\"#UserAttribute@%Properties3Id%\"/>");
		strbuf.append("<cim:Asset.Properties4 rdf:resource=\"#UserAttribute@%Properties4Id%\"/>");
		strbuf.append("<cim:Asset.Properties5 rdf:resource=\"#UserAttribute@%Properties5Id%\"/>");
		strbuf.append("<cim:Asset.Properties6 rdf:resource=\"#UserAttribute@%Properties6Id%\"/>");
		strbuf.append("<cim:Asset.Properties7 rdf:resource=\"#UserAttribute@%Properties7Id%\"/>");
		strbuf.append("<cim:Asset.Properties8 rdf:resource=\"#UserAttribute@%Properties8Id%\"/>");
		strbuf.append("</cim:Asset>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%PropertiesId%\">");
		strbuf.append("<cim:UserAttribute.value>" + ddate + "</cim:UserAttribute.value>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties1Id%\">");
		strbuf.append("<cim:UserAttribute.value1>" + run_time + "</cim:UserAttribute.value1>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties2Id%\">");
		strbuf.append("<cim:UserAttribute.value2>" + over_up_time + "</cim:UserAttribute.value2>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties3Id%\">");
		strbuf.append("<cim:UserAttribute.value3>" + over_low_time + "</cim:UserAttribute.value3>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties4Id%\">");
		strbuf.append("<cim:UserAttribute.value4>" + max_value + "</cim:UserAttribute.value4>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties5Id%\">");
		strbuf.append("<cim:UserAttribute.value5>" + max_time + "</cim:UserAttribute.value5>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties6Id%\">");
		strbuf.append("<cim:UserAttribute.value6>" + min_value + "</cim:UserAttribute.value6>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties7Id%\">");
		strbuf.append("<cim:UserAttribute.value7>" + min_time + "</cim:UserAttribute.value7>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties8Id%\">");
		strbuf.append("<cim:UserAttribute.value8>" + valid_rate + "</cim:UserAttribute.value8>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
		return strbuf.toString();
	}
	/**
	 * 母线状态切换数据
	 * @param orga_name
	 * @param orga_id
	 * @param equipid
	 * @param mrid
	 * @param equipinfo
	 * @param equipstoptime
	 * @param beforedate
	 * @param afterdate
	 * @return
	 */
	public String GetRDF_MXZHQH(String orga_name, String orga_id, String equipid, String mrid,
			String equipinfo, String equipstoptime, String beforedate,
			String afterdate){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:BusbarLine rdf:ID=\"BusbarLine@%BusbarLineId%\">");
		strbuf.append("<cim:IdentifiedObject.name>" + equipinfo + "</cim:IdentifiedObject.name>");
		strbuf.append("<cim:IdentifiedObject.mrid>" + mrid + "</cim:IdentifiedObject.mrid>");
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		strbuf.append("<cim:IdentifiedObject.timeStamp>" + sdf.format(new Date()) + "</cim:IdentifiedObject.timeStamp>");
		strbuf.append("<cim:PowerSystemResource.equipCode>" + equipid + "</cim:PowerSystemResource.equipCode>");
		strbuf.append("<cim:PowerSystemResource.AssetRoles rdf:resource=\"#AssetPsrRole@%AssetRolesId%\"/>");
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("</cim:BusbarLine>");
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		strbuf.append("<cim:IdentifiedObject.name1>" + orga_name + "</cim:IdentifiedObject.name1>");
		strbuf.append("<cim:IdentifiedObject.mRID1>" + orga_id + "</cim:IdentifiedObject.mRID1>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("<cim:AssetPsrRole rdf:ID=\"AssetPsrRole@%AssetRolesId%\">");
		strbuf.append("<cim:AssetPsrRole.Asset rdf:resource=\"#Asset@%AssetId%\"/>");
		strbuf.append("</cim:AssetPsrRole>");
		strbuf.append("<cim:Asset rdf:ID=\"Asset@%AssetId%\">");
		strbuf.append("<cim:Asset.Properties rdf:resource=\"#UserAttribute@%PropertiesId%\"/>");
		strbuf.append("<cim:Asset.Properties1 rdf:resource=\"#UserAttribute@%Properties1Id%\"/>");
		strbuf.append("<cim:Asset.Properties2 rdf:resource=\"#UserAttribute@%Properties2Id%\"/>");
		strbuf.append("</cim:Asset>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%PropertiesId%\">");
		strbuf.append("<cim:UserAttribute.value>" + equipstoptime + "</cim:UserAttribute.value>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties1Id%\">");
		strbuf.append("<cim:UserAttribute.value1>" + beforedate + "</cim:UserAttribute.value1>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties2Id%\">");
		strbuf.append("<cim:UserAttribute.value2>" + afterdate + "</cim:UserAttribute.value2>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
		
		return strbuf.toString();
	}
//	/**
//	 * 线路状态切换数据
//	 * @param orga_id
//	 * @param orga_name
//	 * @param equipid
//	 * @param equipinfo
//	 * @param equipstoptime
//	 * @param Ibeforedate
//	 * @param Iafterdate
//	 * @param Jbeforedate
//	 * @param Jafterdate
//	 * @return
//	 */
//	public String GetRDF_XLZHQH( String orga_id, String orga_name, String equipid, String equipinfo, String equipstoptime,
//			String Ibeforedate, String Iafterdate, String Jbeforedate,
//			String Jafterdate){
//		StringBuffer strbuf = new StringBuffer();
//		
//		strbuf.append("<![CDATA[");
//		strbuf.append(" <?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
//		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
//		strbuf.append("<cim:Line rdf:ID=\"Line@%LineId%\">");
//		strbuf.append("<cim:IdentifiedObject.name>" + equipinfo + "</cim:IdentifiedObject.name>");
//		strbuf.append("<cim:PowerSystemResource.equipCode>" + equipid + "</cim:PowerSystemResource.equipCode>"); 
//		strbuf.append("<cim:PowerSystemResource.AssetRoles rdf:resource=\"#AssetPsrRole@%AssetRolesId%\" />"); 
//		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\" />"); 
//		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>"); 
//		strbuf.append("<cim:IdentifiedObject.timeStamp>" + sdf.format(new Date()) + "</cim:IdentifiedObject.timeStamp>"); 
//		strbuf.append("</cim:Line>");
//		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
//		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\" />"); 
//		strbuf.append("</cim:OrgPsrRole>");
//		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
//		strbuf.append("<cim:IdentifiedObject.name>" + orga_id + "</cim:IdentifiedObject.name>"); 
//		strbuf.append("<cim:IdentifiedObject.mRID>" + orga_name + "</cim:IdentifiedObject.mRID>"); 
//		strbuf.append("</cim:ErpOrganisation>");
//		strbuf.append("<cim:AssetPsrRole rdf:ID=\"AssetPsrRole@%AssetRolesId%\">");
//		strbuf.append("<cim:AssetPsrRole.Asset rdf:resource=\"#Asset@%AssetId%\" />"); 
//		strbuf.append("</cim:AssetPsrRole>");
//		strbuf.append("<cim:Asset rdf:ID=\"Asset@%AssetId%\">");
//		strbuf.append("<cim:Asset.Properties rdf:resource=\"#UserAttribute@%PropertiesId%\" />"); 
//		strbuf.append("<cim:Asset.Properties1 rdf:resource=\"#UserAttribute@%Properties1Id%\" />"); 
//		strbuf.append("<cim:Asset.Properties2 rdf:resource=\"#UserAttribute@%Properties2Id%\" />"); 
//		strbuf.append("<cim:Asset.Properties3 rdf:resource=\"#UserAttribute@%Properties3Id%\" />"); 
//		strbuf.append("<cim:Asset.Properties4 rdf:resource=\"#UserAttribute@%Properties4Id%\" />"); 
//		strbuf.append("</cim:Asset>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%PropertiesId%\">");
//		strbuf.append("<cim:UserAttribute.value>" + equipstoptime.substring(0,19) + "</cim:UserAttribute.value>"); 
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties1Id%\">");
//		strbuf.append("<cim:UserAttribute.value>" + Ibeforedate + "</cim:UserAttribute.value>"); 
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties2Id%\">");
//		strbuf.append("<cim:UserAttribute.value>" + Iafterdate + "</cim:UserAttribute.value>"); 
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties3Id%\">");
//		strbuf.append("<cim:UserAttribute.value>" + Jbeforedate + "</cim:UserAttribute.value>"); 
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties4Id%\">");
//		strbuf.append("<cim:UserAttribute.value>" + Jafterdate + "</cim:UserAttribute.value>"); 
//		strbuf.append("</cim:UserAttribute>");
//		strbuf.append("</rdf:RDF>");
//		strbuf.append("]]>\n");
//				
//		return strbuf.toString();
//	}
	/**
	 * 变压器状态切换数据
	 * @param orga_name
	 * @param orga_code
	 * @param name
	 * @param code
	 * @param mrid
	 * @param ddate
	 * @param hp
	 * @param mp
	 * @param lp
	 * @param hTap
	 * @param mTap
	 * @param hBeforeState
	 * @param hAfterState
	 * @param mBeforeState
	 * @param mAfterState
	 * @param lBeforeState
	 * @param lAfterState
	 * @return
	 */
	public String GetRDF_BYQZHQH(String orga_name, String orga_code, String name,
			String code, String mrid, String ddate, String hp, String mp,
			String lp, String hTap, String mTap, String hBeforeState,
			String hAfterState, String mBeforeState, String mAfterState,
			String lBeforeState, String lAfterState){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:PowerTransformer rdf:ID=\"PowerTransformer@%PowerTransformerId%\">");
		strbuf.append("<cim:IdentifiedObject.name>" + name + "</cim:IdentifiedObject.name>");
		strbuf.append("<cim:IdentifiedObject.mrid>" + mrid + "</cim:IdentifiedObject.mrid>");
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		strbuf.append("<cim:IdentifiedObject.timeStamp>" + sdf.format(new Date()) + "</cim:IdentifiedObject.timeStamp>");
		strbuf.append("<cim:PowerSystemResource.equipCode>" + code + "</cim:PowerSystemResource.equipCode>");
		strbuf.append("<cim:PowerSystemResource.AssetRoles rdf:resource=\"#AssetPsrRole@%AssetRolesId%\"/>");
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("</cim:PowerTransformer>");
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		strbuf.append("<cim:IdentifiedObject.name1>" + orga_name + "</cim:IdentifiedObject.name1>");
		strbuf.append("<cim:IdentifiedObject.mRID1>" + orga_code + "</cim:IdentifiedObject.mRID1>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("<cim:AssetPsrRole rdf:ID=\"AssetPsrRole@%AssetRolesId%\">");
		strbuf.append("<cim:AssetPsrRole.Asset rdf:resource=\"#Asset@%AssetId%\"/>");
		strbuf.append("</cim:AssetPsrRole>");
		strbuf.append("<cim:Asset rdf:ID=\"Asset@%AssetId%\">");
		strbuf.append("<cim:Asset.Properties rdf:resource=\"#UserAttribute@%PropertiesId%\"/>");
		strbuf.append("<cim:Asset.Properties1 rdf:resource=\"#UserAttribute@%Properties1Id%\"/>");
		strbuf.append("<cim:Asset.Properties2 rdf:resource=\"#UserAttribute@%Properties2Id%\"/>");
		strbuf.append("<cim:Asset.Properties3 rdf:resource=\"#UserAttribute@%Properties3Id%\"/>");
		strbuf.append("<cim:Asset.Properties4 rdf:resource=\"#UserAttribute@%Properties4Id%\"/>");
		strbuf.append("<cim:Asset.Properties5 rdf:resource=\"#UserAttribute@%Properties5Id%\"/>");
		strbuf.append("<cim:Asset.Properties6 rdf:resource=\"#UserAttribute@%Properties6Id%\"/>");
		strbuf.append("<cim:Asset.Properties7 rdf:resource=\"#UserAttribute@%Properties7Id%\"/>");
		strbuf.append("<cim:Asset.Properties8 rdf:resource=\"#UserAttribute@%Properties8Id%\"/>");
		strbuf.append("<cim:Asset.Properties9 rdf:resource=\"#UserAttribute@%Properties9Id%\"/>");
		strbuf.append("<cim:Asset.Properties10 rdf:resource=\"#UserAttribute@%Properties10Id%\"/>");
		strbuf.append("<cim:Asset.Properties11 rdf:resource=\"#UserAttribute@%Properties11Id%\"/>");
		strbuf.append("</cim:Asset>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%PropertiesId%\">");
		strbuf.append("<cim:UserAttribute.value>" + ddate + "</cim:UserAttribute.value>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties1Id%\">");
		strbuf.append("<cim:UserAttribute.value1>" + hp + "</cim:UserAttribute.value1>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties20Id%\">");
		strbuf.append("<cim:UserAttribute.value2>" + mp + "</cim:UserAttribute.value2>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties3Id%\">");
		strbuf.append("<cim:UserAttribute.value3>" + lp + "</cim:UserAttribute.value3>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties4Id%\">");
		strbuf.append("<cim:UserAttribute.value4>" + hTap + "</cim:UserAttribute.value4>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties5Id%\">");
		strbuf.append("<cim:UserAttribute.value5>" + mTap + "</cim:UserAttribute.value5>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties6Id%\">");
		strbuf.append("<cim:UserAttribute.value6>" + hBeforeState + "</cim:UserAttribute.value6>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties7Id%\">");
		strbuf.append("<cim:UserAttribute.value7>" + hAfterState + "</cim:UserAttribute.value7>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties8Id%\">");
		strbuf.append("<cim:UserAttribute.value8>" + mBeforeState + "</cim:UserAttribute.value8>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties9Id%\">");
		strbuf.append("<cim:UserAttribute.value9>" + mAfterState + "</cim:UserAttribute.value9>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties10Id%\">");
		strbuf.append("<cim:UserAttribute.value10>" + lBeforeState + "</cim:UserAttribute.value10>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties11Id%\">");
		strbuf.append("<cim:UserAttribute.value11>" + lAfterState + "</cim:UserAttribute.value11>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
				

		return strbuf.toString();
	}
	/**
	 * 母线
	 * @param isPivotPoint
	 * @param dispatchNo
	 * @param voltageGrade
	 * @param equipCode
	 * @param mrid
	 * @param code
	 * @param name
	 * @param name1
	 * @return
	 */
	public String GetRDF_MX(String isPivotPoint, String dispatchNo,String voltageGrade,
			String equipCode, String mrid, String code, String name,
			String name1){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"); 
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:BusbarLine rdf:ID=\"BusbarLine@%BusbarLineId%\">");
		strbuf.append("<cim:BusbarLine.isPivotPoint>"+isPivotPoint+"</cim:BusbarLine.isPivotPoint>"); 
		strbuf.append("<cim:PowerSystemResource.dispatchNo>"+dispatchNo+"</cim:PowerSystemResource.dispatchNo>"); 
		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+voltageGrade+"</cim:PowerSystemResource.voltageGrade>"); 
		strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>"); 
		strbuf.append("<cim:IdentifiedObject.mrid>"+mrid+"</cim:IdentifiedObject.mrid>"); 
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>"); 
		strbuf.append("<cim:IdentifiedObject.timeStamp>" + sdf.format(new Date()) + "</cim:IdentifiedObject.timeStamp>");
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\" />"); 
		strbuf.append("<cim:Equipment.EquipmentContainer rdf:resource=\"#Substation@%EquipmentContainerId%\" />");
		strbuf.append("</cim:BusbarLine>");
		strbuf.append(" <cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\" />"); 
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>"); 
		strbuf.append("<cim:ErpOrganisation.name>"+name+"</cim:ErpOrganisation.name>"); 
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("<cim:Substation rdf:ID=\"Substation@%EquipmentContainerId%\">");
		strbuf.append("<cim:IdentifiedObject.name1>"+name1+"</cim:IdentifiedObject.name1>"); 
		strbuf.append("</cim:Substation>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
				
		return strbuf.toString();
	}
	
	
	/**
	 * 母线电压统计值
	 * @param code
	 * @param name
	 * @param useTime
	 * @param index_name
	 * @param index_value
	 * @param cycle
	 * @param year_percents
	 * @return
	 */
	public String GetRDF_MXDYTJ(String code,String name,String useTime,
			String index_name,String index_value,String cycle,String year_percents){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");

		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
		strbuf.append("<cim:IdentifiedObject.useTime>"+  useTime+ "</cim:IdentifiedObject.useTime>");
		
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		
		strbuf.append("<cim:IdentifiedObject.timeStamp>"+ sdf.format(new Date()) + "</cim:IdentifiedObject.timeStamp>");
		strbuf.append("<cim:ErpOrganisation.AssetRoles rdf:resource=\"#OrgAssetRole@%AssetRolesId%\"/>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("<cim:OrgAssetRole rdf:ID=\"OrgAssetRole@%AssetRolesId%\">");
		strbuf.append("<cim:OrgAssetRole.Asset rdf:resource=\"#Asset@%AssetId%\"/>");
		strbuf.append("</cim:OrgAssetRole>");
		strbuf.append("<cim:Asset rdf:ID=\"Asset@%AssetId%\">");
		strbuf.append("<cim:Asset.Ratings rdf:resource=\"#UserAttribute@%RatingsId%\"/>");
		strbuf.append("<cim:Asset.Ratings rdf:resource=\"#UserAttribute@%RatingsId1%\"/>");
		strbuf.append("</cim:Asset>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%RatingsId%\">");
		//指标名称
		strbuf.append("<cim:UserAttribute.name1>"+index_name+"</cim:UserAttribute.name1>");
		
		strbuf.append("<cim:UserAttribute.value1>"+index_value+"</cim:UserAttribute.value1>");
		
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%RatingsId1%\">");
		strbuf.append("<cim:UserAttribute.value2>"+cycle+"</cim:UserAttribute.value2>");
		strbuf.append("<cim:UserAttribute.value3>"+year_percents+"</cim:UserAttribute.value3>");
		
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
		
		return strbuf.toString();
	}
	/**
	 * 电网频率统计值
	 * @param code		单位编码
	 * @param name		所属单位名称
	 * @param useTime
	 * @param index_name	指标名称
	 * @param index_value	指标值
	 * @param cycle			统计周期	
	 * @param YEAR_PERCENTS			年合格率	
	 * @return
	 */
	public String GetRDF_DWPLTJ(String code,String name,String useTime,
			String index_name,String index_value,String cycle,String YEAR_PERCENTS){
		StringBuffer strbuf = new StringBuffer();
		/*
			 * <?xml version="1.0" encoding="UTF-8"?>
	<rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" xmlns:cim="http://iec.ch/TC57/2009/CIM-schema-cim14#">
		<cim:ErpOrganisation rdf:ID="ErpOrganisation@%ErpOrganisationId%">
			<cim:ErpOrganisation.code>%code%</cim:ErpOrganisation.code>
			<!--单位编码-->
			<cim:IdentifiedObject.name>%name%</cim:IdentifiedObject.name>
			<!--所属单位名称-->
			<cim:IdentifiedObject.useTime>%useTime%</cim:IdentifiedObject.useTime>
			<!--统计时间  新增20121102-->
			<cim:IdentifiedObject.recordStatus>%recordStatus%</cim:IdentifiedObject.recordStatus>
			<!--操作标识  新增20121102-->
			<cim:IdentifiedObject.timeStamp>%timeStamp%</cim:IdentifiedObject.timeStamp>
			<!--时间戳  新增20121102-->
			<cim:ErpOrganisation.AssetRoles rdf:resource="#OrgAssetRole@%AssetRolesId%"/>
		</cim:ErpOrganisation>
		<cim:OrgAssetRole rdf:ID="OrgAssetRole@%AssetRolesId%">
			<cim:OrgAssetRole.Asset rdf:resource="#Asset@%AssetId%"/>
		</cim:OrgAssetRole>
		<cim:Asset rdf:ID="Asset@%AssetId%">
			<cim:Asset.Ratings rdf:resource="#UserAttribute@%RatingsId%"/>
			<cim:Asset.Ratings rdf:resource="#UserAttribute@%RatingsId1%"/>
		</cim:Asset>
		<cim:UserAttribute rdf:ID="UserAttribute@%RatingsId%">
			<cim:UserAttribute.name1>%name1%</cim:UserAttribute.name1>
			<!--指标名称-->
			<cim:UserAttribute.value1>%value1%</cim:UserAttribute.value1>
			<!--指标值-->
		</cim:UserAttribute>
		<cim:UserAttribute rdf:ID="UserAttribute@%RatingsId1%">
			<cim:UserAttribute.value2>%value2%</cim:UserAttribute.value2>
			<!--统计周期-->
			<cim:UserAttribute.value3>%value3%</cim:UserAttribute.value3>
			<!--年累计值-->
		</cim:UserAttribute>
	</rdf:RDF>

		 */
		
		strbuf.append("<![CDATA[");
		
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		
		//<!--单位编码-->
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
		
		//<!--所属单位名称-->
		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
		
		//<!--统计时间  新增20121102-->
		strbuf.append("<cim:IdentifiedObject.useTime>"+useTime+"</cim:IdentifiedObject.useTime>");
		
		//<!--操作标识  新增20121102-->
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		
		// <!--时间戳  新增20121102-->
		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
		strbuf.append("<cim:ErpOrganisation.AssetRoles rdf:resource=\"#OrgAssetRole@%AssetRolesId%\"/>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("<cim:OrgAssetRole rdf:ID=\"OrgAssetRole@%AssetRolesId%\">");
		strbuf.append("<cim:OrgAssetRole.Asset rdf:resource=\"#Asset@%AssetId%\"/>");
		strbuf.append("</cim:OrgAssetRole>");
		strbuf.append("<cim:Asset rdf:ID=\"Asset@%AssetId%\">");
		strbuf.append("<cim:Asset.Ratings rdf:resource=\"#UserAttribute@%RatingsId%\"/>");
		strbuf.append("<cim:Asset.Ratings rdf:resource=\"#UserAttribute@%RatingsId1%\"/>");
		strbuf.append("</cim:Asset>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%RatingsId%\">");
		
		//<!--指标名称-->
		strbuf.append("<cim:UserAttribute.name1>"+index_name+"</cim:UserAttribute.name1>");
		
		// <!--指标值-->
		strbuf.append("<cim:UserAttribute.value1>"+index_value+"</cim:UserAttribute.value1>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%RatingsId1%\">");
		
		//<!--统计周期-->
		strbuf.append("<cim:UserAttribute.value2>"+cycle+"</cim:UserAttribute.value2>");
		//!--年累计值-->
		strbuf.append("<cim:UserAttribute.value3>"+YEAR_PERCENTS+"</cim:UserAttribute.value3>");
		strbuf.append("</cim:UserAttribute>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
				
		return strbuf.toString();
	}
	/**
	 * 断路器
	 * @param equipCode		<!--设备编码-->
	 * @param mRID			<!--资源标识-->
	 * @param name			<!--设备名称-->			
	 * @param code			<!--操作标识-->
	 * @param name1			<!--所属市局编码-->
	 * @param name2			<!--变电站名称-->
	 * @return
	 */
	public String GetRDF_DLQ(String equipCode,String mRID,String name,String code,String name1,String name2){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" " +
				"xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:Breaker rdf:ID=\"Breaker@%BreakerId%\">");
		
		//<!--设备编码-->
		strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>");
		//<!--资源标识-->
		strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>");
		//<!--设备名称-->
		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
		//<!--操作标识-->
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		//<!--时间戳-->
		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("<cim:Equipment.EquipmentContainer rdf:resource=\"#Bay@%EquipmentContainerId%\"/>");
		strbuf.append("</cim:Breaker>");
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		
		//<!--所属市局编码-->
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
		//<!--所属市局名称-->
		strbuf.append("<cim:ErpOrganisation.name1>"+name1+"</cim:ErpOrganisation.name1>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("<cim:Bay rdf:ID=\"Bay@%EquipmentContainerId%\">");
		strbuf.append("<cim:Bay.Substation rdf:resource=\"#Substation@%SubstationId%\"/>");
		strbuf.append("</cim:Bay>");
		strbuf.append("<cim:Substation rdf:ID=\"Substation@%SubstationId%\">");
		//<!--变电站名称-->
		strbuf.append("<cim:IdentifiedObject.name2>"+name2+"</cim:IdentifiedObject.name2>");
		strbuf.append("</cim:Substation>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
		
		return strbuf.toString();
	}
	/**
	 * 架空线路设备
	 * @param mRID	<!--资源标识-->
	 * @param name	<!--线路名称-->
	 * @param voltageGrade	<!--电压等级-->
	 * @param lineCode	<!--线路编码-->
	 * @param code	<!--所属市局编码-->
	 * @param name1	<!--所属市局名称-->
	 * @return
	 */
	public String GetRDF_JKXL(String mRID,String name,String voltageGrade,
			String lineCode,String code,String name1){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" " +
				"xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:EquTrsiLine rdf:ID=\"EquTrsiLine@%EquTrsiLineId%\">");
		//<!--资源标识-->
		strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>");
		//<!--线路名称-->
		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
		
		//<!--操作标识-->
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		
		//<!--时间戳-->
		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
		
		//<!--电压等级-->
		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+voltageGrade+"</cim:PowerSystemResource.voltageGrade>");
		
		//<!--线路编码-->
		strbuf.append("<cim:EquTrsiLine.lineCode>"+lineCode+"</cim:EquTrsiLine.lineCode>");
		
		
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("</cim:EquTrsiLine>");
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		
		//<!--所属市局编码-->
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
		
		//<!--所属市局名称-->
		strbuf.append("<cim:ErpOrganisation.name1>"+name1+"</cim:ErpOrganisation.name1>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
		
		return strbuf.toString();
	}
	/**
	 * 电缆线路设备
	 * @param mRID		<!--资源标识-->
	 * @param name		<!--线路名称-->
	 * @param voltageGrade	<!--电压等级-->
	 * @param lineCode	<!--线路编码-->
	 * @param code		<!--所属市局编码-->
	 * @param name1		<!--所属市局名称-->
	 * @return
	 */
	public String GetRDF_DLXL(String mRID,String name,String voltageGrade,String lineCode ,String code,String name1){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" " +
					"xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:EquTrsiLine rdf:ID=\"EquTrsiLine@%EquTrsiLineId%\">");
		
		//<!--资源标识-->
		strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>");
		
		//<!--线路名称-->
		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
		
		//<!--操作标识-->
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		
		//<!--时间戳-->
		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
		
		//<!--电压等级-->
		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+voltageGrade+"</cim:PowerSystemResource.voltageGrade>");
		
		//<!--线路编码-->
		strbuf.append("<cim:EquTrsiLine.lineCode>"+lineCode+"</cim:EquTrsiLine.lineCode>");
		
		
		
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("</cim:EquTrsiLine>");
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		
		//<!--所属市局编码-->
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
		
		//<!--所属市局名称-->
		strbuf.append("<cim:ErpOrganisation.name1>"+name1+"</cim:ErpOrganisation.name1>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
		
		return strbuf.toString();
	}
	/**
	 * 变压器
	 * @param mRID	<!--OBJ_ID-->
	 * @param name	<!--设备名称-->
	 * @param equipCode	<!--设备编码-->
	 * @param voltageGrade	<!--电压等级-->
	 * @param code	<!--所属市局编码-->
	 * @param name1	<!--所属市局名称-->
	 * @param name2	<!--变电站名称-->
	 * @return
	 */
	public String GetRDF_BYQ(String mRID,String name,String equipCode,
			String voltageGrade,String code,String name1,String name2){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" " +
				"xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:PowerTransformer rdf:ID=\"PowerTransformer@%PowerTransformerId%\">");
		
		
		//<!--OBJ_ID-->
		strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>");
		
		//<!--设备名称-->
		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
		
		//<!--操作标识-->
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		
		//<!--时间戳-->
		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
		
		//<!--设备编码-->
		strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>");
		
		//<!--电压等级-->
		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+voltageGrade+"</cim:PowerSystemResource.voltageGrade>");
		
		
		
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("<cim:Equipment.EquipmentContainer rdf:resource=\"#Substation@%EquipmentContainerId%\"/>");
		strbuf.append("</cim:PowerTransformer>");
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		
		//<!--所属市局编码-->
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
		
		//<!--所属市局名称-->
		strbuf.append("<cim:IdentifiedObject.name1>"+name1+"</cim:IdentifiedObject.name1>");
		
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("<cim:Substation rdf:ID=\"Substation@%EquipmentContainerId%\">");
		
		//<!--变电站名称-->
		strbuf.append("<cim:IdentifiedObject.name2>"+name2+"</cim:IdentifiedObject.name2>");
		strbuf.append("</cim:Substation>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
				

		return strbuf.toString();
	}
	
	/**
	 * 断路器设备清单
	 * URI：http://sjzy.sgcc.com.cn/cis/SMS/OMS/Breaker_01_W
	 * @param equipCode		设备编码
	 * @param mRID			资源标识
	 * @param name			设备名称
	 * @param code			所属市局编码
	 * @param voltageGrade	电压等级
	 * @param name1			所属市局名称	
	 * @param name2			变电站名称
	 * @return
	 */
	public String GetRDF_DLQSB(String equipCode,String mRID,String name,String code,String voltageGrade,
			String name1,String name2){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
	
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");

		strbuf.append("<cim:Breaker rdf:ID=\"Breaker@%BreakerId%\">");
		//<!--设备编码-->
		strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>");
		//<!--资源标识-->
		strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>"); 
		
		//<!--设备名称-->
		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");  
		//<!--操作标识-->
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>") ;
		//<!--时间戳-->
		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>") ; 
		//<!--电压等级-->
		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+voltageGrade+"</cim:PowerSystemResource.voltageGrade>");
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("<cim:Equipment.EquipmentContainer rdf:resource=\"#Bay@%EquipmentContainerId%\"/>");
		strbuf.append("</cim:Breaker>") ; 
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">") ; 
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>") ; 
		strbuf.append("</cim:OrgPsrRole>") ; 
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">") ;
		//<!--所属市局编码-->
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>") ; 
		//<!--所属市局名称-->
		strbuf.append("<cim:ErpOrganisation.name1>"+name1+"</cim:ErpOrganisation.name1>") ; 
		strbuf.append("</cim:ErpOrganisation>") ; 
		strbuf.append("<cim:Bay rdf:ID=\"Bay@%EquipmentContainerId%\">") ; 
		strbuf.append("<cim:Bay.Substation rdf:resource=\"#Substation@%SubstationId%\"/>") ; 
		strbuf.append("</cim:Bay>") ; 
		strbuf.append("<cim:Substation rdf:ID=\"Substation@%SubstationId%\">") ; 
//		/<!--变电站名称-->
		strbuf.append("<cim:IdentifiedObject.name2>"+name2+"</cim:IdentifiedObject.name2>") ; 
		strbuf.append("</cim:Substation>") ; 
		strbuf.append("</rdf:RDF>") ; 

		
		


//		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
//				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
//		strbuf.append("<cim:Breaker rdf:ID=\"Breaker@%BreakerId%\">");
//		
//		//<!--设备编码-->
//		strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+
//				"</cim:PowerSystemResource.equipCode>");
//		
//		
//		//<!--资源标识-->
//		strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>");
//		
//		//<!--设备名称-->
//		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
//		
//		//<!--操作标识-->
//		strbuf.append("<cim:IdentifiedObject.recordStatus>C" +
//				"</cim:IdentifiedObject.recordStatus>");
//		
//		//<!--时间戳-->
//		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+
//				"</cim:IdentifiedObject.timeStamp>");
//		
//		//<!--电压等级-->
//		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+
//				voltageGrade+"</cim:PowerSystemResource.voltageGrade>");
//		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles" +
//				" rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
//		strbuf.append("<cim:Equipment.EquipmentContainer" +
//				" rdf:resource=\"#Bay@%EquipmentContainerId%\"/>");
//		strbuf.append("</cim:Breaker>");
//		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
//		strbuf.append("<cim:OrgPsrRole.ErpOrganisation" +
//				" rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
//		strbuf.append("</cim:OrgPsrRole>");
//		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
//		
//		//<!--所属市局编码-->
//		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
//		
//		//<!--所属市局名称-->
//		strbuf.append("<cim:ErpOrganisation.name1>"+name1+"</cim:ErpOrganisation.name1>");
//		strbuf.append("</cim:ErpOrganisation>");
//		strbuf.append("<cim:Bay rdf:ID=\"Bay@%EquipmentContainerId%\">");
//		strbuf.append("<cim:Bay.Substation rdf:resource=\"#Substation@%SubstationId%\"/>");
//		strbuf.append("</cim:Bay>");
//		strbuf.append("<cim:Substation rdf:ID=\"Substation@%SubstationId%\">");
//		
//		//<!--变电站名称-->
//		strbuf.append("<cim:IdentifiedObject.name2>"+name2+"</cim:IdentifiedObject.name2>");
//		strbuf.append("</cim:Substation>");
//		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
				    
		    

//		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
//				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
//		strbuf.append("<cim:Breaker rdf:ID=\"Breaker@%BreakerId%\">");
//		
//		//<!--设备编码-->
//		strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>");
//		
//		// <!--资源标识-->
//		strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>");
//		
//		//<!--设备名称-->
//		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
//		
//		//<!--操作标识-->
//		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
//		
//		//<!--时间戳-->
//		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
//		strbuf.append(" <cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
//		strbuf.append("<cim:Equipment.EquipmentContainer rdf:resource=\"#Bay@%EquipmentContainerId%\"/>");
//		strbuf.append("</cim:Breaker>");
//		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
//		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
//		strbuf.append("</cim:OrgPsrRole>");
//		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
//		
//		// <!--所属市局编码-->
//		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
//		
//		//<!--所属市局名称-->
//		strbuf.append("<cim:ErpOrganisation.name1>"+name1+"</cim:ErpOrganisation.name1>");
//		strbuf.append("</cim:ErpOrganisation>");
//		strbuf.append("<cim:Bay rdf:ID=\"Bay@%EquipmentContainerId%\">");
//		strbuf.append("<cim:Bay.Substation rdf:resource=\"#Substation@%SubstationId%\"/>");
//		strbuf.append("</cim:Bay>");
//		strbuf.append("<cim:Substation rdf:ID=\"Substation@%SubstationId%\">");
//		
//		//<!--变电站名称-->
//		strbuf.append("<cim:IdentifiedObject.name2>"+name2+"</cim:IdentifiedObject.name2>");
//		strbuf.append(" </cim:Substation>");
//		strbuf.append("</rdf:RDF>");
//		    
		return strbuf.toString();
	}
	
	/**
	 * 电缆线路
	 * URI:http://sjzy.sgcc.com.cn/cis/SMS/OMS/EquTrsiLine_02_W
	 * @param mRID	资源标识
	 * @param name	线路名称
	 * @param voltageGrade	电压等级
	 * @param lineCode	线路编码
	 * @param code	所属市局编码
	 * @param name1	所属市局名称
	 * @return
	 */
	public String GetRDF_DLXLSB(String mRID,String name,
			String voltageGrade,String lineCode,String code,
			String name1){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:EquTrsiLine rdf:ID=\"EquTrsiLine@%EquTrsiLineId%\">");
		
		
		//<!--资源标识-->
		strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>");
		
		//<!--线路名称-->
		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
		
		//<!--操作标识-->
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		
		//<!--时间戳-->
		strbuf.append(" <cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
		
		//<!--电压等级-->
		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+voltageGrade+"</cim:PowerSystemResource.voltageGrade>");
		
		
		//<!--线路编码-->
		strbuf.append("<cim:EquTrsiLine.lineCode>"+lineCode+"</cim:EquTrsiLine.lineCode>");
		
		
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("</cim:EquTrsiLine>");
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		
		
		// <!--所属市局编码-->
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
		
		//<!--所属市局名称-->
		strbuf.append("<cim:ErpOrganisation.name1>"+name1+"</cim:ErpOrganisation.name1>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
		
		return strbuf.toString();		
	}
	
	/**
	 * 架空线路设备清单
	 * URI:http://sjzy.sgcc.com.cn/cis/SMS/OMS/EquTrsiLine_01_W
	 * @return
	 */
	/**
	 * @param mRID		资源标识
	 * @param name		线路名称
	 * @param voltageGrade	电压登记
	 * @param lineCode		线路编码
	 * @param code			所属市局编码	
	 * @param name1			所属市局名称
	 * @return
	 */
	public String GetRDF_JKXLSB(String mRID,String name,String voltageGrade,String lineCode,String code,String name1){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:EquTrsiLine rdf:ID=\"EquTrsiLine@%EquTrsiLineId%\">");
		
		//<!--资源标识-->
		strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>");
		
		//<!--线路名称-->
		strbuf.append(" <cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
		
		//<!--操作标识-->
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		
		// <!--时间戳-->
		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+
				"</cim:IdentifiedObject.timeStamp>");
		
		//<!--电压等级-->
		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+voltageGrade+
				"</cim:PowerSystemResource.voltageGrade>");
		
		//<!--线路编码-->
		strbuf.append("<cim:EquTrsiLine.lineCode>"+lineCode+"</cim:EquTrsiLine.lineCode>");
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles" +
				" rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("</cim:EquTrsiLine>");
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		
		//<!--所属市局编码-->
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
		
		//<!--所属市局名称-->
		strbuf.append("<cim:ErpOrganisation.name1>"+name1+"</cim:ErpOrganisation.name1>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
		
		return strbuf.toString();
	}
	
	/**
	 * 母线设备清单
	 * URI：http://sjzy.sgcc.com.cn/cis/SMS/OMS/BusbarLine_W
	 * @param isPivotPoint	是否中枢点
	 * @param dispatchNo	运行编号
	 * @param voltageGrade	电压等级
	 * @param equipCode		设备编码
	 * @param mrid			mrid
	 * @param code			所属市局代码
	 * @param name			所属市局名称
	 * @param name1			变电站名称
	 * @param name2			母线名称
	 * @return
	 */
	public String GetRDF_MXSB(String isPivotPoint,String dispatchNo,String voltageGrade,
			String equipCode,String mrid,String code,String name,String name1,String name2){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:BusbarLine rdf:ID=\"BusbarLine@%BusbarLineId%\">");
		
		//<!--是否中枢点-->
		strbuf.append("<cim:BusbarLine.isPivotPoint>"+isPivotPoint+"</cim:BusbarLine.isPivotPoint>");
		
		//<!--运行编号-->
		strbuf.append("<cim:PowerSystemResource.dispatchNo>"+dispatchNo+
				"</cim:PowerSystemResource.dispatchNo>");
		
		//<!--电压等级-->
		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+voltageGrade+
				"</cim:PowerSystemResource.voltageGrade>");
		
		//<!--add by typing 20120628-->
		//<!--设备编码-->
		strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+
				"</cim:PowerSystemResource.equipCode>");
		
		//<!--mrid-->
		strbuf.append("<cim:IdentifiedObject.mrid>"+mrid+"</cim:IdentifiedObject.mrid>");
		
		//<!--操作标识  新增20121102-->
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		
		//<!--时间戳  新增20121102-->
		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+
				"</cim:IdentifiedObject.timeStamp>");
		
		//<!--add by typing 20120628-->
		//<!--母线名称-->
		strbuf.append("<cim:IdentifiedObject.name2>"+name2+"</cim:IdentifiedObject.name2>");
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles" +
				" rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("<cim:Equipment.EquipmentContainer" +
				" rdf:resource=\"#Substation@%EquipmentContainerId%\"/>");
		strbuf.append("</cim:BusbarLine>");
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation" +
				" rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		
		//<!--所属市局代码-->
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
		
		//<!--所属市局名称-->
		strbuf.append("<cim:ErpOrganisation.name>"+name+"</cim:ErpOrganisation.name>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("<cim:Substation rdf:ID=\"Substation@%EquipmentContainerId%\">");
		
		//<!--变电站名称-->
		strbuf.append("<cim:IdentifiedObject.name1>"+name1+"</cim:IdentifiedObject.name1>");
		strbuf.append("</cim:Substation>");
		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
				    
		    
//		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
//				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
//		strbuf.append("<cim:BusbarLine rdf:ID=\"BusbarLine@%BusbarLineId%\">");
//		
//		// <!--是否中枢点-->
//		strbuf.append("<cim:BusbarLine.isPivotPoint>"+isPivotPoint+"</cim:BusbarLine.isPivotPoint>");
//		
//		// <!--运行编号-->
//		strbuf.append("<cim:PowerSystemResource.dispatchNo>"+dispatchNo+"</cim:PowerSystemResource.dispatchNo>");
//		
//		// <!--电压等级-->
//		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+voltageGrade+"</cim:PowerSystemResource.voltageGrade>");
//		
//		//<!--设备编码-->
//		strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>");
//		
//		//<!--mrid-->
//		strbuf.append("<cim:IdentifiedObject.mrid>"+mrid+"</cim:IdentifiedObject.mrid>");
//		
//		//<!--操作标识  新增20121102-->
//		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
//		
//		//<!--时间戳  新增20121102-->
//		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
//		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
//		strbuf.append("<cim:Equipment.EquipmentContainer rdf:resource=\"#Substation@%EquipmentContainerId%\"/>");
//		strbuf.append("</cim:BusbarLine>");
//		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
//		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
//		strbuf.append("</cim:OrgPsrRole>");
//		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
//		
//		//<!--所属市局代码-->
//		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
//		
//		//<!--所属市局名称-->
//		strbuf.append("<cim:ErpOrganisation.name>"+name+"</cim:ErpOrganisation.name>");
//		strbuf.append("</cim:ErpOrganisation>");
//		strbuf.append("<cim:Substation rdf:ID=\"Substation@%EquipmentContainerId%\">");
//		
//		// <!--变电站名称-->
//		strbuf.append("<cim:IdentifiedObject.name1>"+name1+"</cim:IdentifiedObject.name1>");
//		strbuf.append("</cim:Substation>");
//		strbuf.append("</rdf:RDF>");

		return strbuf.toString();
	}
	
	/**
	 * 主网变压设备清单
	 * URI：http://sjzy.sgcc.com.cn/cis/SMS/OMS/PowerTransformer_W
	 * @param mRID				OBJ_ID
	 * @param name				设备名称
	 * @param equipCode			设备编码
	 * @param voltageGrade		电压等级
	 * @param code				所属市局编码
	 * @param name1				所属市局名称
	 * @param name2				变电站名称
	 * @return
	 */
	public String GetRDF_ZWBYSB(String mRID,String name,String equipCode,String voltageGrade,
			String code,String name1,String name2){
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("<![CDATA[");
		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
		strbuf.append("<cim:PowerTransformer rdf:ID=\"PowerTransformer@%PowerTransformerId%\">");
		
		//<!--OBJ_ID-->
		strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>");
		
		//<!--设备名称-->
		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
		
		//<!--操作标识-->
		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
		
		//<!--时间戳-->
		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+
				"</cim:IdentifiedObject.timeStamp>");
		
		
		//<!--设备编码-->
		strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>");

		//<!--电压等级-->
		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+voltageGrade+
				"</cim:PowerSystemResource.voltageGrade>");
		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles" +
				" rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
		strbuf.append("<cim:Equipment.EquipmentContainer" +
				" rdf:resource=\"#Substation@%EquipmentContainerId%\"/>");
		strbuf.append("</cim:PowerTransformer>");
		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
		strbuf.append("</cim:OrgPsrRole>");
		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
		
		
		// <!--所属市局代码-->
		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
		
		//<!--所属市局名称-->
		strbuf.append("<cim:ErpOrganisation.name1>"+name1+"</cim:ErpOrganisation.name1>");
		strbuf.append("</cim:ErpOrganisation>");
		strbuf.append("<cim:Substation rdf:ID=\"Substation@%EquipmentContainerId%\">");
		
		//<!--变电站名称-->
		strbuf.append("<cim:IdentifiedObject.name2>"+name2+"</cim:IdentifiedObject.name2>");
		strbuf.append("</cim:Substation>");
		strbuf.append("</rdf:RDF>");
		    
//		strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//		strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"" +
//				" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
//		strbuf.append("<cim:PowerTransformer rdf:ID=\"PowerTransformer@%PowerTransformerId%\">");
//		
//		///<!--OBJ_ID-->
//		strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>");
//		
//		//<!--设备名称-->
//		strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
//		
//		//<!--操作标识-->
//		strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
//		
//		//<!--时间戳-->
//		strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
//		
//		
//		//<!--设备编码-->
//		strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>");
//		
//		//<!--电压等级-->
//		strbuf.append("<cim:PowerSystemResource.voltageGrade>"+voltageGrade+"</cim:PowerSystemResource.voltageGrade>");
//		strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
//		strbuf.append("<cim:Equipment.EquipmentContainer rdf:resource=\"#Substation@%EquipmentContainerId%\"/>");
//		strbuf.append("</cim:PowerTransformer>");
//		strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
//		strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
//		strbuf.append("</cim:OrgPsrRole>");
//		strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
//		
//		//<!--所属市局编码-->
//		strbuf.append("<cim:ErpOrganisation.code>"+code+"</cim:ErpOrganisation.code>");
//		
//		//<!--所属市局名称-->
//		strbuf.append("<cim:IdentifiedObject.name1>"+name1+"</cim:IdentifiedObject.name1>");
//		strbuf.append("</cim:ErpOrganisation>");
//		strbuf.append("<cim:Substation rdf:ID=\"Substation@%EquipmentContainerId%\">");
//		
//		//<!--变电站名称-->
//		strbuf.append("<cim:IdentifiedObject.name2>"+name2+"</cim:IdentifiedObject.name2>");
//		strbuf.append("</cim:Substation>");
//		strbuf.append("</rdf:RDF>");
		strbuf.append("]]>\n");
		
		return strbuf.toString();
	}

	
	
		/**
		 * 变压器状态切换数据
		 * @param name   	变压器名
		 * @param mrid		资源标识
		 * @param equipCode	变压器编码
		 * @param name1		所属单位名称
		 * @param mRID1		所属单位编码
		 * @param value		状态切换时刻	
		 * @param value1	高压端有功	
		 * @param value2	中压端有功	
		 * @param value3	低压端有功
		 * @param value4	高压侧分接头位置	
		 * @param value5	中压侧分接头位置	
		 * @param value6	切换前高压侧状态	
		 * @param value7	切换后高压侧状态	
		 * @param value8	切换前中压侧状态	
		 * @param value9	切换后中压侧状态
		 * @param value10	切换前低压侧状态
		 * @param value11	切换后低压侧状态
		 * @return  RDF XML文件内容
		 */
		public String GetRDF_ZWBYQZHQH(String name,String mrid,String equipCode,String name1,String mRID1,
				String value,String value1,String value2,String value3,String value4,String value5,
				String value6,String value7,String value8,String value9,String value10,String value11)
		{
			StringBuffer strbuf = new StringBuffer();
			
			strbuf.append("<![CDATA[");
			strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
			strbuf.append("<cim:PowerTransformer rdf:ID=\"PowerTransformer@%PowerTransformerId%\">");
			strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
			//<!--变压器名-->
			strbuf.append("<cim:IdentifiedObject.mrid>"+mrid+"</cim:IdentifiedObject.mrid>");
			//<!--资源标识-->
			strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
			//<!--操作标识  新增20121102-->
			strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
			//<!--时间戳  新增20121102-->
			strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>");
			//<!--变压器编码-->
			strbuf.append("<cim:PowerSystemResource.AssetRoles rdf:resource=\"#AssetPsrRole@%AssetRolesId%\"/>");
			//<!--add by typing 20120613-->
			strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
			//<!--add by typing 20120613-->
			strbuf.append("</cim:PowerTransformer>");
			//<!--add by typing 20120613-->
			strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
			strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
			strbuf.append("</cim:OrgPsrRole>");
			strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
			strbuf.append("<cim:IdentifiedObject.name1>"+name1+"</cim:IdentifiedObject.name1> ");
			//<!--所属单位名称-->
			strbuf.append("<cim:IdentifiedObject.mRID1>"+mRID1+"</cim:IdentifiedObject.mRID1>"); 
			//<!--所属单位编码-->
			strbuf.append("</cim:ErpOrganisation>");
			//<!--add by typing 20120613-->
			strbuf.append("<cim:AssetPsrRole rdf:ID=\"AssetPsrRole@%AssetRolesId%\">");
			strbuf.append("<cim:AssetPsrRole.Asset rdf:resource=\"#Asset@%AssetId%\"/>");
			strbuf.append("</cim:AssetPsrRole>");
			strbuf.append("<cim:Asset rdf:ID=\"Asset@%AssetId%\">");
			strbuf.append("<cim:Asset.Properties rdf:resource=\"#UserAttribute@%PropertiesId%\"/>");
			strbuf.append("<cim:Asset.Properties1 rdf:resource=\"#UserAttribute@%Properties1Id%\"/>");
			strbuf.append("<cim:Asset.Properties2 rdf:resource=\"#UserAttribute@%Properties2Id%\"/>");
			strbuf.append("<cim:Asset.Properties3 rdf:resource=\"#UserAttribute@%Properties3Id%\"/>");
			strbuf.append("<cim:Asset.Properties4 rdf:resource=\"#UserAttribute@%Properties4Id%\"/>");
			strbuf.append("<cim:Asset.Properties5 rdf:resource=\"#UserAttribute@%Properties5Id%\"/>");
			strbuf.append("<cim:Asset.Properties6 rdf:resource=\"#UserAttribute@%Properties6Id%\"/>");
			strbuf.append("<cim:Asset.Properties7 rdf:resource=\"#UserAttribute@%Properties7Id%\"/>");
			strbuf.append("<cim:Asset.Properties8 rdf:resource=\"#UserAttribute@%Properties8Id%\"/>");
			strbuf.append("<cim:Asset.Properties9 rdf:resource=\"#UserAttribute@%Properties9Id%\"/>");
			strbuf.append("<cim:Asset.Properties10 rdf:resource=\"#UserAttribute@%Properties10Id%\"/>");
			strbuf.append("<cim:Asset.Properties10 rdf:resource=\"#UserAttribute@%Properties11Id%\"/>");
			strbuf.append("</cim:Asset>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%PropertiesId%\">");
			strbuf.append("<cim:UserAttribute.value>"+value+"</cim:UserAttribute.value>");
			//<!--状态切换时刻-->
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties1Id%\">");
			strbuf.append("<cim:UserAttribute.value1>"+value1+"</cim:UserAttribute.value1>");
			//<!--高压端有功-->
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties20Id%\">");
			strbuf.append("<cim:UserAttribute.value2>"+value2+"</cim:UserAttribute.value2>");
			//<!--中压端有功-->
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties3Id%\">");
			strbuf.append("<cim:UserAttribute.value3>"+value3+"</cim:UserAttribute.value3>");
			//<!--低压端有功-->
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties4Id%\">");
			strbuf.append("<cim:UserAttribute.value4>"+value4+"</cim:UserAttribute.value4>");
			//<!--高压侧分接头位置-->
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties5Id%\">");
			strbuf.append("<cim:UserAttribute.value5>"+value5+"</cim:UserAttribute.value5>");
			//<!--中压侧分接头位置-->
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties6Id%\">");
			strbuf.append("<cim:UserAttribute.value6>"+value6+"</cim:UserAttribute.value6>");
			//<!--切换前高压侧状态-->");
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties7Id%\">");
			strbuf.append("<cim:UserAttribute.value7>"+value7+"</cim:UserAttribute.value7>");
			//<!--切换后高压侧状态-->
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties8Id%\">");
			strbuf.append("<cim:UserAttribute.value8>"+value8+"</cim:UserAttribute.value8>");
			//<!--切换前中压侧状态-->
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties9Id%\">");
			strbuf.append("<cim:UserAttribute.value9>"+value9+"</cim:UserAttribute.value9>");
			//<!--切换后中压侧状态-->
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties10Id%\">");
			strbuf.append("<cim:UserAttribute.value10>"+value10+"</cim:UserAttribute.value10>");
			//<!--切换前低压侧状态-->
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties11Id%\">");
			strbuf.append("<cim:UserAttribute.value11>"+value11+"</cim:UserAttribute.value11>");
			//<!--切换后低压侧状态-->
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("</rdf:RDF>");
			strbuf.append("]]>\n");
			
			return strbuf.toString();
		}
		
		

		/**
		 * 母线状态切换数据信息
		 * @param name	母线名称
		 * @param mrid	mrid
		 * @param equipCode	母线编码-
		 * @param name1		所属单位名称
		 * @param mRID1		所属单位编码
		 * @param value		状态切换时刻
		 * @param value1	切换前母线状态
		 * @param value2	切换后母线状态
		 * @return
		 */
		public String GetRDF_MXQHZT(String name,String mrid,String equipCode,String name1,String mRID1,String value,
				String value1,String value2){
			StringBuffer strbuf = new StringBuffer();
			
			strbuf.append("<![CDATA[");
			strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
			strbuf.append("<cim:BusbarLine rdf:ID=\"BusbarLine@%BusbarLineId%\">");
			
			//<!--母线名称-->
			strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
			
			//<!--mrid-->
			strbuf.append("<cim:IdentifiedObject.mrid>"+mrid+"</cim:IdentifiedObject.mrid>");
			strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
			strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
			
			//<!--母线编码-->
			strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>");
			strbuf.append("<cim:PowerSystemResource.AssetRoles rdf:resource=\"#AssetPsrRole@%AssetRolesId%\"/>");
			strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
			strbuf.append("</cim:BusbarLine>");
			strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
			strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
			strbuf.append("</cim:OrgPsrRole>");
			strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
			
			//所属单位名称
			strbuf.append("<cim:IdentifiedObject.name1>"+name1+"</cim:IdentifiedObject.name1>");
			
			//所属单位编码
			strbuf.append("	<cim:IdentifiedObject.mRID1>"+mRID1+"</cim:IdentifiedObject.mRID1> ");
			
			
			strbuf.append("</cim:ErpOrganisation>");
			strbuf.append("<cim:AssetPsrRole rdf:ID=\"AssetPsrRole@%AssetRolesId%\">");
			strbuf.append("<cim:AssetPsrRole.Asset rdf:resource=\"#Asset@%AssetId%\"/>");
			strbuf.append("</cim:AssetPsrRole>");
			strbuf.append("<cim:Asset rdf:ID=\"Asset@%AssetId%\">");
			strbuf.append("<cim:Asset.Properties rdf:resource=\"#UserAttribute@%PropertiesId%\"/>");
			strbuf.append("<cim:Asset.Properties1 rdf:resource=\"#UserAttribute@%Properties1Id%\"/>");
			strbuf.append("<cim:Asset.Properties2 rdf:resource=\"#UserAttribute@%Properties2Id%\"/>");
			strbuf.append("</cim:Asset>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%PropertiesId%\">");
			
			// <!--状态切换时刻-->
			strbuf.append("<cim:UserAttribute.value>"+value+"</cim:UserAttribute.value>");
			strbuf.append("</cim:UserAttribute>");
			
			// <!--切换前母线状态-->
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties1Id%\">");
			strbuf.append("<cim:UserAttribute.value1>"+value1+"</cim:UserAttribute.value1>");
			strbuf.append("</cim:UserAttribute>");
			// <!--切换后母线状态-->
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties2Id%\">");
			strbuf.append("<cim:UserAttribute.value2>"+value2+"</cim:UserAttribute.value2>");
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("</rdf:RDF>");
			strbuf.append("]]>\n");
			
			return strbuf.toString();
		}
		
		/**
		 * 线路状态切换数据信息
		 * @param name	线路名-->
		 * @param equipCode	线路编码-->
		 * @param name1		所属单位名称-->
		 * @param mRID		所属单位编码-->
		 * @param value		状态切换时刻-->
		 * @param value1	切换前I端状态-->
		 * @param value2	切换后I端状态-->
		 * @param value3	切换前J端状态-->
		 * @param value4	切换后J端状态-->
		 * @return
		 */
		public String GetRDF_XLZTQH(String name,String equipCode,String name1,String mRID,
				String value,String value1,String value2,String value3,String value4){
			StringBuffer strbuf = new StringBuffer();
			//------------------------------------------------------------------------------------------------
			// 2013-11-20
			//------------------------------------------------------------------------------------------------	
//			strbuf.append("<![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//			strbuf.append(" ");
//			strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
//			strbuf.append("  <cim:UserAttribute rdf:ID=\"UserAttribute@%UserAttributeId%\">");
//			strbuf.append("    <cim:UserAttribute.value>"+name1+"</cim:UserAttribute.value>");
//			strbuf.append("    <cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
//			strbuf.append("    <cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
//			strbuf.append("    <cim:UserAttribute.value1>"+equipCode+"</cim:UserAttribute.value1>");
//			strbuf.append("    <cim:UserAttribute.value2>"+name+"</cim:UserAttribute.value2>");
//			strbuf.append("    <cim:UserAttribute.value3>"+value+"</cim:UserAttribute.value3>");
//			strbuf.append("    <cim:UserAttribute.value4>"+value1+"</cim:UserAttribute.value4>");
//			strbuf.append("    <cim:UserAttribute.value5>"+value2+"</cim:UserAttribute.value5>");
//			strbuf.append("    <cim:UserAttribute.value6>"+value3+"</cim:UserAttribute.value6>");
//			strbuf.append("    <cim:UserAttribute.value7>"+value4+"</cim:UserAttribute.value7>");
//			strbuf.append("  </cim:UserAttribute>");
//			strbuf.append("</rdf:RDF>]]>");
			
//------------------------------------------------------------------------------------------------
// 2013-11-19
//------------------------------------------------------------------------------------------------			
			strbuf.append("<![CDATA[");
			
			strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" " +
					"xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
			strbuf.append("<cim:Line rdf:ID=\"Line@%LineId%\">");
			
			//<!--线路名-->
			strbuf.append("<cim:IdentifiedObject.name>"+name+"</cim:IdentifiedObject.name>");
			
			//<!--线路编码-->
			strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>");
			
			//<cim:PowerSystemResource.AssetRoles rdf:resource="#AssetPsrRole@%AssetRolesId%"/>
			strbuf.append("<cim:PowerSystemResource.AssetRoles rdf:resource=\"#AssetPsrRole@%AssetRolesId%\"/>");
			//<!--add by typing 20120613-->
			strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
			
			//<!--操作标识  新增20121102-->
			strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
			
			//<!--时间戳  新增20121102-->
			strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
			strbuf.append("</cim:Line>");
			strbuf.append("<!--add by typing 20120613-->");
			strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
			strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
			strbuf.append("</cim:OrgPsrRole>");
			strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
			
			//<!--所属单位名称-->
			strbuf.append("<cim:IdentifiedObject.name>"+name1+"</cim:IdentifiedObject.name>");
			
			//<!--所属单位编码-->
			strbuf.append("<cim:IdentifiedObject.mRID>"+mRID+"</cim:IdentifiedObject.mRID>");
			
			//<!--add by typing 20120613-->
			strbuf.append("</cim:ErpOrganisation>");
			strbuf.append("<cim:AssetPsrRole rdf:ID=\"AssetPsrRole@%AssetRolesId%\">");
			strbuf.append("<cim:AssetPsrRole.Asset rdf:resource=\"#Asset@%AssetId%\"/>");
			strbuf.append("</cim:AssetPsrRole>");
			strbuf.append("<cim:Asset rdf:ID=\"Asset@%AssetId%\">");
			strbuf.append("<cim:Asset.Properties rdf:resource=\"#UserAttribute@%PropertiesId%\"/>");
			strbuf.append("<cim:Asset.Properties1 rdf:resource=\"#UserAttribute@%Properties1Id%\"/>");
			strbuf.append("<cim:Asset.Properties2 rdf:resource=\"#UserAttribute@%Properties2Id%\"/>");
			strbuf.append("<cim:Asset.Properties3 rdf:resource=\"#UserAttribute@%Properties3Id%\"/>");
			strbuf.append("<cim:Asset.Properties4 rdf:resource=\"#UserAttribute@%Properties4Id%\"/>");
			strbuf.append("</cim:Asset>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%PropertiesId%\">");
			
			//<!--状态切换时刻-->
			strbuf.append("<cim:UserAttribute.value>"+value+"</cim:UserAttribute.value>");
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties1Id%\">");
			
			//<!--切换前I端状态-->
			strbuf.append("<cim:UserAttribute.value>"+value1+"</cim:UserAttribute.value>");
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties2Id%\">");
			
			//<!--切换后I端状态-->
			strbuf.append("<cim:UserAttribute.value>"+value2+"</cim:UserAttribute.value>");
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties3Id%\">");
			
			//<!--切换前J端状态-->
			strbuf.append("<cim:UserAttribute.value>"+value3+"</cim:UserAttribute.value>");
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties4Id%\">");
			
			//<!--切换后J端状态-->
			strbuf.append("<cim:UserAttribute.value>"+value4+"</cim:UserAttribute.value>");
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("</rdf:RDF>");
			strbuf.append("]]>\n");
			
			return strbuf.toString();
		}
		

		/**
		 * 断路器状态切换数据	
		 * @param mRID1	OBJ_ID
		 * @param name1	断路器名称
		 * @param equipCode	断路器编码
		 * @param value1	状态切换时刻
		 * @param value2	切换前断路器状态
		 * @param value3	切换后断路器状态
		 * @param mRID2		所属单位编码
		 * @param name2		所属单位名称
		 * @return
		 */
		public String GetRDF_DLQZTQH(String mRID1,String  name1,String equipCode,
				String value1,String value2,String value3,String mRID2,String name2){
			StringBuffer strbuf = new StringBuffer();
			
			strbuf.append("<![CDATA[");
			strbuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			strbuf.append("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" " +
					"xmlns:cim=\"http://iec.ch/TC57/2009/CIM-schema-cim14#\">");
			strbuf.append("<cim:Breaker rdf:ID=\"Breaker@%BreakerId%\">");
			
			//<!--OBJ_ID-->
			strbuf.append("<cim:IdentifiedObject.mRID1>"+mRID1+"</cim:IdentifiedObject.mRID1>");
			
			//<!--断路器名称-->
			strbuf.append("<cim:IdentifiedObject.name1>"+name1+"</cim:IdentifiedObject.name1>");
			
			//<!--操作标识-->
			strbuf.append("<cim:IdentifiedObject.recordStatus>C</cim:IdentifiedObject.recordStatus>");
			
			//<!--时间戳-->
			strbuf.append("<cim:IdentifiedObject.timeStamp>"+sdf.format(new Date())+"</cim:IdentifiedObject.timeStamp>");
			
			//<!--断路器编码-->
			strbuf.append("<cim:PowerSystemResource.equipCode>"+equipCode+"</cim:PowerSystemResource.equipCode>");
			strbuf.append("<cim:ConductingEquipment.ElectricalAssets rdf:resource=\"#BreakerAsset@%ElectricalAssetsId%\"/>");
			strbuf.append("<cim:PowerSystemResource.ErpOrganisationRoles rdf:resource=\"#OrgPsrRole@%ErpOrganisationRolesId%\"/>");
			strbuf.append("</cim:Breaker>");
			strbuf.append("<cim:BreakerAsset rdf:ID=\"BreakerAsset@%ElectricalAssetsId%\">");
			strbuf.append("<cim:Asset.Properties rdf:resource=\"#UserAttribute@%PropertiesId%\"/>");
			strbuf.append("<cim:Asset.Properties1 rdf:resource=\"#UserAttribute@%Properties1Id%\"/>");
			strbuf.append("<cim:Asset.Properties2 rdf:resource=\"#UserAttribute@%Properties2Id%\"/>");
			strbuf.append("</cim:BreakerAsset>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%PropertiesId%\">");
			
			//<!--状态切换时刻-->
			strbuf.append("<cim:UserAttribute.value1>"+value1+"</cim:UserAttribute.value1>");
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties1Id%\">");
			
			//<!--切换前断路器状态-->
			strbuf.append("<cim:UserAttribute.value2>"+value2+"</cim:UserAttribute.value2>");
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:UserAttribute rdf:ID=\"UserAttribute@%Properties2Id%\">");
			
			//<!--切换后断路器状态-->
			strbuf.append("<cim:UserAttribute.value3>"+value3+"</cim:UserAttribute.value3>");
			strbuf.append("</cim:UserAttribute>");
			strbuf.append("<cim:OrgPsrRole rdf:ID=\"OrgPsrRole@%ErpOrganisationRolesId%\">");
			strbuf.append("<cim:OrgPsrRole.ErpOrganisation rdf:resource=\"#ErpOrganisation@%ErpOrganisationId%\"/>");
			strbuf.append("</cim:OrgPsrRole>");
			strbuf.append("<cim:ErpOrganisation rdf:ID=\"ErpOrganisation@%ErpOrganisationId%\">");
			
			//<!--所属单位编码-->
			strbuf.append("<cim:IdentifiedObject.mRID2>"+mRID2+"</cim:IdentifiedObject.mRID2>");
			
			//<!--所属单位名称-->
			strbuf.append("<cim:IdentifiedObject.name2>"+name2+"</cim:IdentifiedObject.name2>");
			strbuf.append("</cim:ErpOrganisation>");
			strbuf.append("</rdf:RDF>");
			strbuf.append("]]>\n");
			
			return strbuf.toString();
		}
	

}
