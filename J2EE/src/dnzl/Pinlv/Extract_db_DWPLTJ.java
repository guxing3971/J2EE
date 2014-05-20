package dnzl.Pinlv;
/***********************************************************************
 * 
 * @summary 从2000系统中采集数据
 ***********************************************************************/
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dnzl.Core.Extract_Data_SuperClass;
import dnzl.DataFactory.SupperVo;
import dnzl.DataFactory.VODWPLTJ;
import dnzl.common.CommonTime;
public class Extract_db_DWPLTJ extends Extract_Data_SuperClass {

	
	@Override
	public void initData() {
		this.SetMethod("deal");
		CommonTime ct = new CommonTime();
		if(!ct.isDay()){
			this.IsNeed(false);
			this.IsLog(false);
		}else{
			List<SupperVo> list=null;
			try {
				list = initVo();
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.SetVoList(list);
		}
	}
	
	public List<SupperVo> initVo() throws Exception{
		List<SupperVo> list = new ArrayList<SupperVo>();
		CommonTime ct = new CommonTime();
		list.addAll(initVO_Day());
		if(ct.isMonth()){
			list.addAll(initVO_Month());
		}
		if(ct.isYear()){
			list.addAll(initV0_Year());
		}

		return list;
	}
	
	public List<SupperVo> initVO_Day() throws Exception, InterruptedException{
		List<SupperVo> list = new ArrayList<SupperVo>();
		dar.setTime(new Date());
		dar.add(Calendar.DAY_OF_YEAR, -1);
		String sDate = sdf1.format(dar.getTime());
		String sDay = sDate.substring(0, 10);
		String sql ="select KHID,ID,SDATE,HGL " +
		"from HISKH.hiskh_statistic_day@ZDH.TMR.REGRESS.RDBMS.DEV.US.ORACLE.COM t " +
		"where KHID ='sysqwFhgl.sysqwF' " +
		"and sdate ='"+sDay+"'";
		
		ResultSet set = null;
		set = resuletSet(sql);
		
		
		
		String COUNTCYCLE="01";
		String COUNT_DATE;
		String INDEX_NAME="01";
		String INDEX_VALUE;
		String Year_Totacl="100";
		while(set != null && set.next()){
			COUNT_DATE = set.getString("SDATE");
			if(COUNT_DATE ==null){
				COUNT_DATE="";
			}
			INDEX_VALUE = set.getString("HGL");
			if(INDEX_VALUE == null){
				INDEX_VALUE="";
			}
			
			VODWPLTJ vo = new VODWPLTJ();
			vo.setCOUNT_DATE(COUNT_DATE);
			vo.setCOUNTCYCLE(COUNTCYCLE);
			vo.setINDEX_NAME(INDEX_NAME);
			vo.setINDEX_VALUE(INDEX_VALUE);
			vo.setYeartotal(Year_Totacl);
			list.add(vo);
		}
		return list;
	}
	
	public List<SupperVo> initVO_Month() throws Exception, InterruptedException{
		List<SupperVo> list = new ArrayList<SupperVo>();
		dar.setTime(new Date());
		dar.add(Calendar.DAY_OF_YEAR, -1);
		String sDate = sdf1.format(dar.getTime());
		String sDay = sDate.substring(0, 10);
		String sql ="select KHID,ID,SDATE,HGL " +
		"from HISKH.hiskh_statistic_MONTH@ZDH.TMR.REGRESS.RDBMS.DEV.US.ORACLE.COM t " +
		"where KHID ='sysqwFhgl.sysqwF' " +
		"and sdate ='"+sDay+"'";
		
		ResultSet set = null;
		set = resuletSet(sql);
		String COUNTCYCLE="02";
		String COUNT_DATE;
		String INDEX_NAME="01";
		String INDEX_VALUE;
		String Year_Totacl="100";
		while(set.next()){
			COUNT_DATE = set.getString("SDATE");
			INDEX_VALUE = set.getString("HGL");
			if(COUNT_DATE ==null){
				COUNT_DATE="";
			}
			INDEX_VALUE = set.getString("HGL");
			if(INDEX_VALUE == null){
				INDEX_VALUE="";
			}
			
			VODWPLTJ vo = new VODWPLTJ();
			vo.setCOUNT_DATE(COUNT_DATE);
			vo.setCOUNTCYCLE(COUNTCYCLE);
			vo.setINDEX_NAME(INDEX_NAME);
			vo.setINDEX_VALUE(INDEX_VALUE);
			vo.setYeartotal(Year_Totacl);
			list.add(vo);
		}
		return list;
	}
	public List<SupperVo> initV0_Year() throws Exception, InterruptedException{
		List<SupperVo> list = new ArrayList<SupperVo>();
		dar.setTime(new Date());
		dar.add(Calendar.DAY_OF_YEAR, -1);
		String sDate = sdf1.format(dar.getTime());
		String sDay = sDate.substring(0, 10);
		String sql ="select KHID,ID,SDATE,HGL " +
		"from HISKH.hiskh_statistic_YEAR@ZDH.TMR.REGRESS.RDBMS.DEV.US.ORACLE.COM t " +
		"where KHID ='sysqwFhgl.sysqwF' " +
		"and sdate ='"+sDay+"'";
		
		ResultSet set = null;
		set = resuletSet(sql);
		String COUNTCYCLE="04";
		String COUNT_DATE;
		String INDEX_NAME="01";
		String INDEX_VALUE;
		String Year_Totacl="100";
		while(set.next()){
			COUNT_DATE = set.getString("SDATE");
			INDEX_VALUE = set.getString("HGL");
			if(COUNT_DATE ==null){
				COUNT_DATE="";
			}
			INDEX_VALUE = set.getString("HGL");
			if(INDEX_VALUE == null){
				INDEX_VALUE="";
			}
			VODWPLTJ vo = new VODWPLTJ();
			vo.setCOUNT_DATE(COUNT_DATE);
			vo.setCOUNTCYCLE(COUNTCYCLE);
			vo.setINDEX_NAME(INDEX_NAME);
			vo.setINDEX_VALUE(INDEX_VALUE);
			vo.setYeartotal(Year_Totacl);
			list.add(vo);
		}
		return list;
	}

	/*
	 * --电网频率统计
		CREATE TABLE dnzlZHILIANG.HANDLERESULT_DWDYTJ(
			recordid		NUMBER(20),		--主键
			COMPANYID		VARCHAR2(50),	--单位编码
			COMPANYNAME		VARCHAR2(128),	--所属单位名称
			COUNTCYCLE		VARCHAR2(10),	--统计周期 01:日02:月03:季04:年
			COUNT_DATE		DATETIME,		--统计日期 YYYY-MM-DD HH:MM:SS
			INDEX_NAME		VARCHAR2(10),	--指标名称01合格率
			INDEX_VALUE		NUMBER(12,5),	--合格率：单位：%
			Year_Totacl		NUMBER(20,4)	--年累计值
		);
	 */	
}
