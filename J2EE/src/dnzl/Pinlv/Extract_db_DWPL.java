package dnzl.Pinlv;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dnzl.Core.Extract_Data_SuperClass;
import dnzl.DataFactory.SupperVo;
import dnzl.DataFactory.VODWPL;
public class Extract_db_DWPL extends Extract_Data_SuperClass {
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
		list.addAll(initVo_5000());
		
		return list;
	}
	
	public List<SupperVo> initVo_5000() throws Exception{
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
			"FROM HISDB.SPECIAL_CALC_HOUR  WHERE code='sysqwF'  and "
			+ "to_char(ddate) = to_char(TO_DATE(DATEADD(HH,-1,CURDATE()),'yyyy-MM-dd')) and hour = "
			+ "to_char(DATEADD(HH,-1,CURDATE()),'HH24')" ;
		msg.append("[SQL]:"+sql);
		ResultSet set = resuletSet(sql);
		if(set == null) return null;
		while(set != null && set.next()){
			VODWPL vo = new VODWPL();
			vo.setTOPLIMIT_CD(set.getString("TOPLIMIT_CD"));
			vo.setLOWERLIMIT_CD(set.getString("LOWERLIMIT_CD"));
			vo.setTOPLIMIT(String.valueOf(set.getString("TOPLIMIT")));
			vo.setTOPLIMIT_TIME(set.getString("TOPLIMIT_TIME"));
			vo.setLOWERLIMIT(String.valueOf(set.getString("LOWERLIMIT")));
			vo.setLOWERLIMIT_TIME(set.getString("LOWERLIMIT_TIME"));
			vo.setPERCENTS(set.getString("PERCENTS"));
			vo.setYearTopLimit_CD(set.getString("TOPLIMIT_CD"));
			vo.setYearLowerLimit_CD(set.getString("LOWERLIMIT_CD"));
			vo.setYearPercents(set.getString("PERCENTS"));
			list.add((SupperVo)vo);
		}
		return list;
	}
	

/////////////////////////////////////////////////////////////////////////////////////////////////////
//从2000系统中查询数据
//
/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<SupperVo> initVo_2000() throws Exception, InterruptedException {
		List<SupperVo> list = new ArrayList<SupperVo>();
		dar.setTime(new Date());
		dar.add(Calendar.HOUR_OF_DAY, -1);
		String sDate = sdf1.format(dar.getTime());
		String sDay = sDate.substring(0, 10);
		String sql = "SELECT ID, SDATE, DDATE, CTIME, DESCR, ONAME_Z, ONAME1, ONAME2, ONAME3," +
		" ONAME4, ONAME5, ST, KVLEVE, LINE, NUM, SJLX, YXDY, UPDATE_FLAG, Q_FLAG," +
		" V00, V01, V02, V03, V04, V05, V06, V07, V08, V09, V10, V11, V12, V13, V14," +
		" V15, V16, V17, V18, V19, V20, V21, V22, V23 " +
		"FROM HISDB.CCBASE@ZDH.TMR.REGRESS.RDBMS.DEV.US.ORACLE.COM t where t.id='sysqwF'" +
		" and sdate =\'"+sDay+"\' order by ctime";
		String sHour = sDate.substring(11,13);
		String vColumn = "V" + sHour;
		ResultSet set = resuletSet(sql);
		
		
		String TOPLIMIT_CD = "0";
		String LOWERLIMIT_CD = "0";
		float TOPLIMIT = 0;
		String TOPLIMIT_TIME = sDate;
		float LOWERLIMIT = 100;
		String LOWERLIMIT_TIME = sDate;
		String PERCENTS = "100.00";
		String YearTopLimit_CD = "0";
		String YearLowerLimit_CD = "0";
		String YearPercents = "100.00";
		 
		 
		while(set != null && set.next()){
			float temp = set.getFloat(vColumn);
			String time = sDay+" "+sHour+":"+set.getString("CTIME")+":00";
			if(temp > TOPLIMIT){
				TOPLIMIT = temp;
				TOPLIMIT_TIME = time;
			}
			if(temp < LOWERLIMIT){
				LOWERLIMIT =temp;
				LOWERLIMIT_TIME=time;
			}
		}
		VODWPL vo = new VODWPL();
		vo.setTOPLIMIT_CD(TOPLIMIT_CD);
		vo.setLOWERLIMIT_CD(LOWERLIMIT_CD);
		vo.setTOPLIMIT(String.valueOf(TOPLIMIT));
		vo.setTOPLIMIT_TIME(TOPLIMIT_TIME);
		vo.setLOWERLIMIT(String.valueOf(LOWERLIMIT));
		vo.setLOWERLIMIT_TIME(LOWERLIMIT_TIME);
		vo.setPERCENTS(PERCENTS);
		vo.setYearTopLimit_CD(YearTopLimit_CD);
		vo.setYearLowerLimit_CD(YearLowerLimit_CD);
		vo.setYearPercents(YearPercents);
		list.add((SupperVo)vo);
		
		
		return list;
	}

	/*
	 * --recordid的序列
	 	SEQ_RECORDID
	 * --电网频率
		CREATE TABLE dnzlZHILIANG.HANDLERESULT_DWPL(
			recordid		NUMBER(20),		--主键
			COMPANYID		VARCHAR2(50),	--单位编码
			COMPANYNAME		VARCHAR2(128),	--所属单位名称
			COUNT_DATE		DATETIME,		--统计日期 YYYY-MM-DD HH:MM:SS
			TOPLIMIT_CD		NUMBER(10),		--上一小时责任频率越上限时间总长(分钟)
			LOWERLIMIT_CD	NUMBER(10),		--上一小时责任频率越下限时间总长(分钟)
			TOPLIMIT		NUMBER(12,3),	--上一小时最高频率(HZ)
			TOPLIMIT_TIME	DATETIME,		--最高频率发生时刻
			LOWERLIMIT		NUMBER(12,3),	--上一小时最低频率
			LOWERLIMIT_TIME	DATETIME,		--最低频率发生时刻
			PERCENTS		NUMBER(12,3),	--上一小时责任频率合格率
			YearTopLimit_CD	NUMBER(10),		--年累计责任频率越上限时间总长
			YearLowerLimit_CD NUMBER(10),	--年累计责任频率越下限时间总长
			YearPercents	NUMBER(12,3)	--年累计责任频率合格率
		);
	 */

}
