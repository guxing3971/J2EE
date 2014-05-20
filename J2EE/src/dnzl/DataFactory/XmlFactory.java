package dnzl.DataFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

@SuppressWarnings("unused")
public class XmlFactory {


	private static final RDF_Factory rdf =new RDF_Factory();
	
	private static SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH");
	
	public static TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");
	
	static {
			sd.setTimeZone(timezone);
	}
	
		
	//断路器设备
	public static  String DLQ_SB = "SELECT OBJ_ID, companyid, "
			+ "companyName, substation, DEV_CODE, dev_name, voltageGrade"
			+ " FROM DIANNENGZHILIANG.HandleResult_DEV_DLQ where status='no'";
	
	
	//电缆线路设备
	public static  String DLXL_SB = "SELECT OBJ_ID, companyid, "
			+ "companyName, substation, line_code, line_name, voltageGrade"
			+ "  FROM DIANNENGZHILIANG.HandleResult_DEV_DLXL where status=\'no\'";
	
	//母线设备
	public static  String MX_SB = "SELECT OBJ_ID,companyid, companyName, substation,"
			+ " MX_CODE, MX_NAME, voltageGrade, isPivotPoint FROM"
			+ " DIANNENGZHILIANG.HandleResult_DEV_MX where status=\'no\'";
	
	//主变设备
	public static  String ZB_SB = "SELECT OBJ_ID, companyid, companyName, "
			+ "substation, DEV_CODE, dev_name, voltageGrade"
			+ " FROM DIANNENGZHILIANG.HandleResult_DEV_ZB where status=\'no\'";
	
	//架空线路设备
	public static  String JKXL_SB = "SELECT OBJ_ID, companyid, companyName,"
			+ " substation, line_code, line_name, voltageGrade"
			+ " FROM DIANNENGZHILIANG.HandleResult_DEV_JKXL where status=\'no\'";
	

	
	//电网电压
	public static  String DWDY = "SELECT recordid,companyid, companyName, MX_CODE,"
			+ " MX_Name, Count_date, Run_time, toplimit_CD, lowerlimit_CD, toplimit,"
			+ " toplimit_time, lowerlimit, lowerlimit_time, percents"
			+ " FROM DIANNENGZHILIANG.HandleResult_DWDY  "
			+ "where to_date(TO_CHAR(COUNT_DATE,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss')  "
			+ "= TO_DATE(to_char(CURDATE(),'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss')  "
			+ "and mx_code in (select mx_code from DIANNENGZHILIANG.HANDLERESULT_DEV_MX where status='no' and VOLTAGEGRADE >110)";
	
	//电网电压统计值
//	public static  String DWDYTJ = "SELECT companyid, companyName,"
//			+ " CountCycle, Count_date, index_name, index_value,Year_Totacl"
//			+ " FROM DIANNENGZHILIANG.HandleResult_DWDYTJ "
//			+ "where to_date(TO_CHAR(COUNT_DATE,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss') ="
//			+ " TO_DATE(to_char(CURDATE(),'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss') "
//			+ "and COMPANYID in (select mx_code from DIANNENGZHILIANG.HANDLERESULT_DEV_MX where status='no' and VOLTAGEGRADE >110)";
	public static  String DWDYTJ = "SELECT companyid, companyName,"
			+ " CountCycle, Count_date, index_name, index_value,Year_Totacl"
			+ " FROM DIANNENGZHILIANG.HandleResult_DWDYTJ "
			+ "where to_date(TO_CHAR(COUNT_DATE,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss') ="
			+ " TO_DATE(to_char(CURDATE(),'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss')";
	//电网频率
	public static  String DWPL = "SELECT recordid,companyid, companyName,"
			+ " Count_date, toplimit_CD, lowerlimit_CD, toplimit, "
			+ "toplimit_time, lowerlimit, lowerlimit_time, percents,YearTopLimit_CD,YearLowerLimit_CD,YearPercents "
			+ " FROM DIANNENGZHILIANG.HandleResult_DWPL "
			+ "where to_date(TO_CHAR(COUNT_DATE,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss') ="
			+ " TO_DATE(to_char(CURDATE(),'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss')";
	
	//电网频率统计值
	public static  String DWPLTJ = "SELECT companyid, companyName, "
			+ "CountCycle, Count_date, index_name, index_value,yeartotal"
			+ " FROM DIANNENGZHILIANG.HandleResult_DWPLTJ "
			+ "where to_date(TO_CHAR(COUNT_DATE,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss') ="
			+ " TO_DATE(to_char(CURDATE(),'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss')";
	
	
	

	
	//母线状态
	public static  String MX_ZT = "SELECT recordid,companyid, companyName, MX_code, "
			+ "MX_name, change_time, last_status, lower_status"
			+ " FROM DIANNENGZHILIANG.HandleResult_ZT_MX"
			+ " WHERE to_date(to_char(CHANGe_TIME,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss') ="
			+ " TO_DATE(to_char(DATEADD(HH,-1,CURDATE()),'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss')";
	
	//线路状态
	public static  String XL_ZT = "SELECT companyid, companyName, line_code, "
			+ "line_name, change_time, last_I, lower_I, last_J, lower_J"
			+ " FROM DIANNENGZHILIANG.HandleResult_ZT_XL"
			+ " WHERE to_date(to_char(CHANGe_TIME,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss') ="
			+ " TO_DATE(to_char(DATEADD(HH,-1,CURDATE()),'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss')";
	
	
	//主变状态切换
	public static  String ZWBYQ_ZT = "SELECT recordid,companyid, companyName,"
			+ " sub_code, sub_name, change_time, G_yougong, Z_yougong,"
			+ " D_yougong, G_WeiZhi, Z_WeiZhi, Last_G, Last_Z, Last_D,"
			+ " lower_G, lower_Z, lower_D FROM DIANNENGZHILIANG.HandleResult_ZT_ZB "
			+ " WHERE to_date(to_char(CHANGe_TIME,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss') ="
			+ "TO_DATE(to_char(DATEADD(HH,-1,CURDATE()),'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss')  and sub_name not like '%阿兰变%'  and sub_name not like '%官亭变%' and sub_name not like '%乌兰变%'";
	
	//断路器状态
	public static  String DLQ_ZT = "SELECT recordid,companyid, companyName,"
			+ " breaker_code, breaker_name, change_time, last_status, "
			+ "lower_status FROM DIANNENGZHILIANG.HandleResult_ZT_DLQ"
			+ " WHERE to_date(to_char(CHANGe_TIME,'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss') ="
			+" TO_DATE(to_char(DATEADD(HH,-1,CURDATE()),'yyyy-MM-dd HH24'),'yyyy-MM-dd HH:mi:ss')";
	
	
	public static List<String> GetXMLAll_DLQSB() throws SQLException{
		List<String> list= new ArrayList<String>();
		List<String> lists = new ArrayList<String>();
		String rdf_xml = null;
		String transactionType =null;
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/Breaker_01_W";
		
		ResultSet res = SupperVo.select(DLQ_SB);
		if(res != null){
			while(res.next()){
				rdf_xml = rdf.GetRDF_DLQSB(
						res.getString("DEV_CODE"),
						res.getString("OBJ_ID"),
						res.getString("DEV_NAME"),
						res.getString("COMPANYID"), 
						res.getString("VOLTAGEGRADE"),
						res.getString("COMPANYNAME"),
						res.getString("SUBSTATION")
				);
				list.add(rdf_xml.toString());
			}
			
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;
	}
	
	public static List<String> GetXMLAll_DWPL() throws SQLException{
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType =null;
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_01_W";
		ResultSet res = SupperVo.select(DWPL);
		if(res != null){
			while(res.next()){
				rdf_xml=rdf.GetRDF_DWPL(
						res.getString("COMPANYID"),
						res.getString("COMPANYNAME"),
						res.getString("RECORDID"),
						res.getString("COUNT_DATE"),
						res.getString("TOPLIMIT_CD"),
						res.getString("LOWERLIMIT_CD"),
						res.getString("TOPLIMIT"),
						res.getString("TOPLIMIT_TIME"),
						res.getString("LOWERLIMIT"), 
						res.getString("LOWERLIMIT_TIME"),
						res.getString("PERCENTS"),
						res.getString("YearTopLimit_CD"),
						res.getString("YearLowerLimit_CD"),
						res.getString("YearPercents")
				);
				list.add( rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}		
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;
	}
	
	public static List<String> GetXMLAll_DWPLTJ() throws SQLException{
		
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType =null;
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_06_W";
		ResultSet res = SupperVo.select(DWPLTJ);
		int Count = 0;
		if(res != null){
			while(res.next()){
				rdf_xml=rdf.GetRDF_DWPLTJ(
						res.getString("COMPANYID"),
						res.getString("COMPANYNAME"),
						res.getString("COUNT_DATE"),
						res.getString("INDEX_NAME"),
						res.getString("INDEX_VALUE"),
						res.getString("COUNTCYCLE"),
						res.getString("yeartotal")
						);
				list.add( rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}		
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;
	}
	
	public static List<String> GetXMLAll_DWDY() throws SQLException{
		
		List<String> list = new ArrayList<String>();
		List<String> lists = new ArrayList<String>();
		String rdf_xml = null;
		String transactionType ="single";
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_02_W";
		ResultSet res = SupperVo.select(DWDY);
		int Count = 0;
		if(res != null){
			while(res.next()){
				rdf_xml=rdf.GetRDF_MXDY(
						res.getString("COMPANYNAME"),
						res.getString("COMPANYID"),
						res.getString("RECORDID"),
						res.getString("MX_NAME"),
						res.getString("MX_CODE"),
						res.getString("COUNT_DATE"),
						res.getString("RUN_TIME"),
						res.getString("TOPLIMIT_CD"),
						res.getString("LOWERLIMIT_CD"),
						res.getString("TOPLIMIT"),
						res.getString("TOPLIMIT_TIME"),
						res.getString("LOWERLIMIT"),
						res.getString("LOWERLIMIT_TIME"),
						res.getString("PERCENTS")
				);
				list.add(rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}		
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;
	}
	
public static List<String> GetXMLAll_DWDYTJ() throws SQLException{
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType ="single";
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_07_W";
		ResultSet res = SupperVo.select(DWDYTJ);
		int Count = 0;
		if(res != null){
			while(res.next()){
				rdf_xml=rdf.GetRDF_MXDYTJ(
						res.getString("COMPANYID"),
						res.getString("COMPANYNAME"),
						res.getString("COUNT_DATE"),
						res.getString("INDEX_NAME"), 
						res.getString("INDEX_VALUE"),
						res.getString("COUNTCYCLE"),
						res.getString("Year_Totacl")
						);
						list.add( rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}		
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;
	}

	public static List<String> GetXMLAll_JKXLSB() throws SQLException{
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType ="single";
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/EquTrsiLine_01_W";
		
		ResultSet res = SupperVo.select(JKXL_SB);
		int Count = 0;
		if(res != null){
			while(res.next()){
				rdf_xml=rdf.GetRDF_JKXLSB(
						res.getString("OBJ_ID"),
						res.getString("LINE_NAME"),
						res.getString("VOLTAGEGRADE"),
						res.getString("LINE_CODE"),
						res.getString("COMPANYID"),
						res.getString("COMPANYNAME"));
				list.add(rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}		
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;
	}
	
	public static List<String> GetXMLAll_DLXLSB() throws SQLException{
		
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType ="single";
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/EquTrsiLine_02_W";
		ResultSet res = SupperVo.select(DLXL_SB);
		int Count = 0;
		if(res != null){
			while(res.next()){
						rdf_xml=rdf.GetRDF_DLXLSB(
						res.getString("OBJ_ID"),
						res.getString("LINE_NAME"),
						res.getString("VOLTAGEGRADE"),
						res.getString("LINE_CODE"),
						res.getString("COMPANYID"),
						res.getString("COMPANYNAME")
				);
				list.add(rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}		
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;
	}
	public static List<String> GetXMLAll_ZBSB() throws SQLException{
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType ="single";
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/PowerTransformer_W";
		
		ResultSet res = SupperVo.select(ZB_SB);
		int Count = 0;
		if(res != null){
			while(res.next()){
				rdf_xml=rdf.GetRDF_ZWBYSB(
						res.getString("OBJ_ID"),
						res.getString("DEV_NAME"),
						res.getString("DEV_CODE"),
						res.getString("VOLTAGEGRADE"),
						res.getString("COMPANYID"),
						res.getString("COMPANYNAME"),
						res.getString("SUBSTATION")
				);
				list.add(rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}		


	StringBuffer  sbuf = new StringBuffer();
			Iterator<String> iter = list.iterator();
			while(iter.hasNext()){
				String content = iter.next();
				sbuf.append("<row>\n");
				sbuf.append(content);
				sbuf.append("</row>\n");
			}
			lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
			return lists;
	}
	public static List<String> GetXMLAll_MXSB() throws SQLException{
		
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType ="single";
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/BusbarLine_W";
		ResultSet res = SupperVo.select(MX_SB);
		int Count = 0;
		if(res != null){
			while(res.next()){
				rdf_xml=rdf.GetRDF_MXSB(
						res.getString("ISPIVOTPOINT"),
						res.getString("OBJ_ID"),
						res.getString("VOLTAGEGRADE"),
						res.getString("MX_CODE"),
						res.getString("MX_CODE"),
						res.getString("COMPANYID"),
						res.getString("COMPANYNAME"), 
						res.getString("SUBSTATION"),
						res.getString("MX_NAME")
				);
				list.add( rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}		
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;
	}
	public static List<String> GetXMLAll_MXZT() throws SQLException{
		
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType ="single";
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_03_W";
		ResultSet res = SupperVo.select(MX_ZT);
		
		int Count = 0;
		if(res != null){
			while(res.next()){
				rdf_xml =	rdf.GetRDF_MXQHZT(
						res.getString("MX_name"),
						res.getString("recordid"),
						res.getString("MX_code"),
						res.getString("companyName"), 
						res.getString("companyid"),
						res.getString("change_time"), 
						res.getString("last_status"),
						res.getString("lower_status"));
				list.add(rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}		
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;
	}
	public static List<String> GetXMLAll_DLQZT() throws SQLException{
		
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType ="single";
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/Breaker_W";
		ResultSet res = SupperVo.select(DLQ_ZT);
		int Count = 0;
		if(res != null){
			while(res.next()){
				rdf_xml=rdf.GetRDF_DLQZTQH(
						res.getString("recordid"),
						res.getString("BREAKER_NAME"), 
						res.getString("BREAKER_CODE"),
						res.getString("CHANGe_TIME"),
						res.getString("LAST_STATUS"),
						res.getString("LOWER_STATUS"),
						res.getString("COMPANYID"),
						res.getString("COMPANYNAME")
				);
				list.add( rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}		
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;
	}
	public static List<String> GetXMLAll_XLZT() throws SQLException{
		
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType ="single";
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_04_W";
		
		ResultSet res = SupperVo.select(XL_ZT);
		int Count = 0;
		if(res != null){
			while(res.next()){
				rdf_xml  = rdf.GetRDF_XLZTQH(
						res.getString("LINE_NAME"),
						res.getString("LINE_CODE"),
						res.getString("COMPANYNAME"),
						res.getString("COMPANYID"), 
						res.getString("CHANGE_TIME"), 
						res.getString("LAST_I"), 
						res.getString("LOWER_I"),
						res.getString("LAST_J"), 
						res.getString("LOWER_J")
				);
				list.add(rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}

		}		
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;
	}
	
	public static List<String> GetXMLAll_ZBZT() throws SQLException{
		
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType ="single";
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_05_W";
		ResultSet res = SupperVo.select(ZWBYQ_ZT);
		int Count = 0;
		if(res != null){
			while(res.next()){
				rdf_xml = rdf.GetRDF_ZWBYQZHQH(
						res.getString("SUB_NAME"),
						res.getString("recordid"),
						res.getString("SUB_CODE"),
						res.getString("COMPANYNAME"),
						res.getString("COMPANYID"), 
						res.getString("CHANGE_TIME"), 
						res.getString("G_YOUGONG"), 
						res.getString("Z_YOUGONG"), 
						res.getString("D_YOUGONG"),
						res.getString("G_WEIZHI"),
						res.getString("Z_WEIZHI"),
						res.getString("LAST_G"),
						res.getString("LOWER_G"),
						res.getString("LAST_Z"),
						res.getString("LOWER_Z"),
						res.getString("LAST_D"),
						res.getString("LOWER_D")
				);
				list.add(rdf_xml.toString());
			}
			if(list.size() > 1){
				transactionType = "all";
			}else{
				transactionType = "single";
			}
		}		
		StringBuffer  sbuf = new StringBuffer();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
		}
		lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		return lists;

	}
	
	
public static List<String> GetXML_ZBZT() throws SQLException{
		
		List<String> list= new ArrayList<String>();
		List<String> lists= new ArrayList<String>();
		String rdf_xml = null;
		String transactionType ="single";
		String uri = "http://sjzy.sgcc.com.cn/cis/SMS/OMS/UserAttribute_05_W";
		ResultSet res = SupperVo.select(ZWBYQ_ZT);
		int Count = 0;
		if(res != null){
			while(res.next()){
				rdf_xml = rdf.GetRDF_ZWBYQZHQH(
						res.getString("SUB_NAME"),
						res.getString("recordid"),
						res.getString("SUB_CODE"),
						res.getString("COMPANYNAME"),
						res.getString("COMPANYID"), 
						res.getString("CHANGE_TIME"), 
						res.getString("G_YOUGONG"), 
						res.getString("Z_YOUGONG"), 
						res.getString("D_YOUGONG"),
						res.getString("G_WEIZHI"),
						res.getString("Z_WEIZHI"),
						res.getString("LAST_G"),
						res.getString("LOWER_G"),
						res.getString("LAST_Z"),
						res.getString("LOWER_Z"),
						res.getString("LAST_D"),
						res.getString("LOWER_D")
				);
				list.add(rdf_xml.toString());
				
			}
		}		
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			StringBuffer  sbuf = new StringBuffer();
			String content = iter.next();
			sbuf.append("<row>\n");
			sbuf.append(content);
			sbuf.append("</row>\n");
			lists.add(Head_Factory.InsertData_CIM(uri, transactionType, sbuf.toString()));
		}
		return lists;
	}
	
}
