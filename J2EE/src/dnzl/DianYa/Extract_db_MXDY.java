package dnzl.DianYa;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dnzl.Core.Extract_Data_SuperClass;
import dnzl.DataFactory.SupperVo;
import dnzl.DataFactory.VODWDY;

public class Extract_db_MXDY extends Extract_Data_SuperClass{
	@Override
	public void initData() {
		this.SetMethod("deal");
		List<SupperVo> list=null;
		try {
			list = initVo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.SetVoList(list);
	}
	
	public List<SupperVo> initVo() throws Exception{
		List<SupperVo> list = new ArrayList<SupperVo>();
		list.addAll(initVo_MXDY());
		return list;
	}
	
	/////////////////////////////////////////////////////////////
	//从科东5000中中抽取数据
	//	数据库:DM6.0 64位    服务器地址 192.168.30.150
	//	用户HISDB	
	//////////////////////////////////////////////////////////////
	public List<SupperVo> initVo_MXDY() throws Exception{
		List<SupperVo> list = new ArrayList<SupperVo>();
		
		String sql = "SELECT  " +
					"ID, " +
					"CODE MX_CODE, " +
					"NAME MX_NAME, " +
					"DDATE COUNT_DATE, " +
					"HOUR , " +
					"MAX_VALUE TOPLIMIT, " +
					"MAX_TIME TOPLIMIT_TIME, " +
					"MIN_VALUE LOWERLIMIT, " +
					"MIN_TIME LOWERLIMIT_TIME, " +
					"RUN_TIME RUN_TIME, " +
					"OVER_UP_LIMIT TOPLIMIT_CD, " +
					"OVER_LOW_LIMIT LOWERLIMIT_CD, " +
					"VALID_RATE PERCENTS  " +
				"FROM HISDB.SPECIAL_CALC_HOUR where code != 'sysqwF' and  "
				+ "to_char(ddate) = to_char(TO_DATE(DATEADD(HH,-1,CURDATE()),'yyyy-MM-dd')) and hour = "
				+ "to_char(DATEADD(HH,-1,CURDATE()),'HH24')" ;
		
		ResultSet set = resuletSet(sql);
		msg.append("[SQL]:"+sql);
		if(set == null) return null;
		while( set.next()){
			 VODWDY vo = new VODWDY();
			 vo.setMX_CODE(set.getString("MX_CODE").replace("abV", "").replace("V", ""));
			 vo.setMX_NAME(set.getString("MX_NAME"));
			 vo.setRUN_TIME(String.valueOf(set.getString("RUN_TIME")));
			 vo.setTOPLIMIT_CD(set.getString("TOPLIMIT_CD"));
			 vo.setLOWERLIMIT_CD(set.getString("LOWERLIMIT_CD"));
			 vo.setTOPLIMIT(String.valueOf(set.getString("TOPLIMIT")));
			 vo.setTOPLIMIT_TIME(set.getString("TOPLIMIT_TIME"));
			 vo.setLOWERLIMIT(String.valueOf(set.getString("LOWERLIMIT")));
			 vo.setLOWERLIMIT_TIME(set.getString("LOWERLIMIT_TIME"));
			 vo.setPERCENTS(set.getString("PERCENTS"));
			 list.add((SupperVo)vo);
		}
		return list;
	}
	

	
//////////////////////////////////////////////////////////////////////////////////////////////////
//以下代码是从2000系统中抽取数据
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////////////////////////////
	//从2000系统中抽取实时数据,计算然后生成相应的数据
	//数据库Oracle:   通过104服务上的Oracle的dblink进行跨系统的数据抽取
	//数据表为:HISDB.CCBASE@ZDH.TMR.REGRESS.RDBMS.DEV.US.ORACLE.COM
	//电网电压 一条母线15分钟一个点 一个小时4条记录
	//		表格为          <--24小时-->
	//					4个点
	////////////////////////////////////////////////////////////////////
	public List<SupperVo> initVo_330()throws Exception{
		List<SupperVo> list = new ArrayList<SupperVo>();
		dar.setTime(new Date());
		dar.add(Calendar.HOUR_OF_DAY, -1);
		String sDate = sdf1.format(dar.getTime());
		String sDay = sDate.substring(0, 10);
		String sql = "SELECT ID, SDATE, DDATE, CTIME, DESCR, ONAME_Z, ONAME1, ONAME2, ONAME3," +
		" ONAME4, ONAME5, ST, KVLEVE, LINE, NUM, SJLX, YXDY, UPDATE_FLAG, Q_FLAG," +
		" V00, V01, V02, V03, V04, V05, V06, V07, V08, V09, V10, V11, V12, V13, V14," +
		" V15, V16, V17, V18, V19, V20, V21, V22, V23 " +
		"FROM HISDB.CCBASE@ZDH.TMR.REGRESS.RDBMS.DEV.US.ORACLE.COM t where t.id like '%330KHV'" +
		" and sdate =\'"+sDay+"\' order by id, ctime";
		String sHour = sDate.substring(11,13);
		String vColumn ="V"+sHour;
		ResultSet set = null;
		set = resuletSet(sql);
		
		
		
		String	MX_CODE;
		String	MX_NAME;
		String	COUNT_DATE=sDate;
		float	RUN_TIME=0;
		String	TOPLIMIT_CD="0";
		String	LOWERLIMIT_CD="0";
		float	TOPLIMIT = 0;
		String	TOPLIMIT_TIME=sDate;
		float	LOWERLIMIT =9999;
		String	LOWERLIMIT_TIME=sDate;
		String	PERCENTS="100.00";
		
		 
		 while(set != null && set.next()){
			 RUN_TIME += 15;
			 MX_CODE = set.getString("ID");
			 MX_NAME = set.getString("ST");
			 for(int j=0;j<3;j++){
				 if(!set.getString("ID").equals(MX_CODE))
				 {
					 break;
				 }
				 String temps = set.getString(vColumn);
				 if(temps == null){
					 temps = "0";
				 }
				 float temp = Float.parseFloat(temps);
				 String time = sDay+" "+sHour+":"+set.getString("CTIME")+":00";
				 if(temp > TOPLIMIT){
					 TOPLIMIT = temp;
					 TOPLIMIT_TIME=time;
				 }
				 if(temp < LOWERLIMIT){
						LOWERLIMIT =temp;
						LOWERLIMIT_TIME=time;
				}
				RUN_TIME+=15;
				if(set.next());
			 }
			 
			 VODWDY vo = new VODWDY();
			 vo.setMX_CODE(MX_CODE);
			 vo.setMX_NAME(MX_NAME);
			 vo.setCOUNT_DATE(COUNT_DATE);
			 vo.setRUN_TIME(String.valueOf(RUN_TIME));
			 vo.setTOPLIMIT_CD(TOPLIMIT_CD);
			 vo.setLOWERLIMIT_CD(LOWERLIMIT_CD);
			 vo.setTOPLIMIT(String.valueOf(TOPLIMIT));
			 vo.setTOPLIMIT_TIME(TOPLIMIT_TIME);
			 vo.setLOWERLIMIT(String.valueOf(TOPLIMIT));
			 vo.setLOWERLIMIT_TIME(LOWERLIMIT_TIME);
			 vo.setPERCENTS(PERCENTS);
			 
			 list.add(vo);
			 COUNT_DATE=sDate;
			 RUN_TIME=0;
			 TOPLIMIT_CD="0";
			 LOWERLIMIT_CD="0";
			 TOPLIMIT = 0;
			 TOPLIMIT_TIME=sDate;
			 LOWERLIMIT =9999;
			 LOWERLIMIT_TIME=sDate;
			 PERCENTS="100.00";
		 }
		return list;
	}
	public List<SupperVo> initVo_750()throws Exception{
		List<SupperVo> list = new ArrayList<SupperVo>();
		
		String sDate = sdf1.format(new Date());
		String sDay = sDate.substring(0, 10);
		String sql = "SELECT ID, SDATE, DDATE, CTIME, DESCR, ONAME_Z, ONAME1, ONAME2, ONAME3," +
		" ONAME4, ONAME5, ST, KVLEVE, LINE, NUM, SJLX, YXDY, UPDATE_FLAG, Q_FLAG," +
		" V00, V01, V02, V03, V04, V05, V06, V07, V08, V09, V10, V11, V12, V13, V14," +
		" V15, V16, V17, V18, V19, V20, V21, V22, V23 " +
		"FROM HISDB.CCBASE@ZDH.TMR.REGRESS.RDBMS.DEV.US.ORACLE.COM t where t.id like '%750KHV'" +
		" and sdate =\'"+sDay+"\' order by id, ctime";
		String sHour = sDate.substring(11,13);
		String vColumn ="V"+sHour;
		ResultSet set = null;
		set = resuletSet(sql);
		
		
		String	MX_CODE;
		String	MX_NAME;
		String	COUNT_DATE=sDate;
		float	RUN_TIME=0;
		String	TOPLIMIT_CD="0";
		String	LOWERLIMIT_CD="0";
		float	TOPLIMIT = 0;
		String	TOPLIMIT_TIME=sDate;
		float	LOWERLIMIT =9999;
		String	LOWERLIMIT_TIME=sDate;
		String	PERCENTS="100.00";
		
		 
		 while(set != null && set.next()){
			 RUN_TIME += 15;
			 MX_CODE = set.getString("ID");
			 MX_NAME = set.getString("ST");
			 for(int j=0;j<3;j++){
				 if(!set.getString("ID").equals(MX_CODE))
				 {
					 break;
				 }
				 String temps = set.getString(vColumn);
				 if(temps == null){
					 temps = "0";
				 }
				 float temp = Float.parseFloat(temps);
				 String time = sDay+" "+sHour+":"+set.getString("CTIME")+":00";
				 if(temp > TOPLIMIT){
					 TOPLIMIT = temp;
					 TOPLIMIT_TIME=time;
				 }
				 if(temp < LOWERLIMIT){
						LOWERLIMIT =temp;
						LOWERLIMIT_TIME=time;
				}
				RUN_TIME+=15;
				if(set.next());
			 }
			 
			 VODWDY vo = new VODWDY();
			 vo.setMX_CODE(MX_CODE);
			 vo.setMX_NAME(MX_NAME);
			 vo.setCOUNT_DATE(COUNT_DATE);
			 vo.setRUN_TIME(String.valueOf(RUN_TIME));
			 vo.setTOPLIMIT_CD(TOPLIMIT_CD);
			 vo.setLOWERLIMIT_CD(LOWERLIMIT_CD);
			 vo.setTOPLIMIT(String.valueOf(TOPLIMIT));
			 vo.setTOPLIMIT_TIME(TOPLIMIT_TIME);
			 vo.setLOWERLIMIT(String.valueOf(TOPLIMIT));
			 vo.setLOWERLIMIT_TIME(LOWERLIMIT_TIME);
			 vo.setPERCENTS(PERCENTS);
			 
			 list.add(vo);
			 COUNT_DATE=sDate;
			 RUN_TIME=0;
			 TOPLIMIT_CD="0";
			 LOWERLIMIT_CD="0";
			 TOPLIMIT = 0;
			 TOPLIMIT_TIME=sDate;
			 LOWERLIMIT =9999;
			 LOWERLIMIT_TIME=sDate;
			 PERCENTS="100.00";
		 }
		return list;
	}
}
