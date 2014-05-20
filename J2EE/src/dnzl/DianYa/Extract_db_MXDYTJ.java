package dnzl.DianYa;
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
import dnzl.DataFactory.VODWDYTJ;
import dnzl.common.CommonTime;

public class Extract_db_MXDYTJ extends Extract_Data_SuperClass{
	
	
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
			list.addAll(initVO_MONTH());
		}
		if(ct.isYear()){
			list.addAll(initVO_YEAR());
		}
		return list;
	}
	
	public List<SupperVo> initVO_YEAR() throws Exception, InterruptedException{
		List<SupperVo> list = new ArrayList<SupperVo>();
		dar.setTime(new Date());
		dar.add(Calendar.DAY_OF_YEAR, -1);
		String sDate = sdf1.format(dar.getTime());
		String sDay = sDate.substring(0, 10);
		String sql = "select KHID,ID,SDATE,HGL " +
				"from HISKH.hiskh_statistic_YEAR@ZDH.TMR.REGRESS.RDBMS.DEV.US.ORACLE.COM t " +
				"where KHID like '%330KHV' " +
				"and operation ='dyhgla'  " +
				"and sdate ='"+sDay+"'";
		

		ResultSet set = null;
		set = resuletSet(sql);
		
		
		
		String companyid="";
		String companyName="";
		String COUNTCYCLE="04";
		String COUNT_DATE=sDay;
		String INDEX_NAME="01";
		String INDEX_VALUE="100";
		String Year_Totacl="100";
		while(set.next()){
			companyid=set.getString("KHID");
			companyName=set.getString("ID");
			COUNT_DATE=set.getString("SDATE");
			INDEX_VALUE=set.getString("HGL");
			
			VODWDYTJ vo = new VODWDYTJ();
			vo.setCOMPANYID(companyid);
			vo.setCOMPANYNAME(companyName);
			vo.setCOUNTCYCLE(COUNTCYCLE);
			vo.setCOUNT_DATE(COUNT_DATE);
			vo.setINDEX_NAME(INDEX_NAME);
			vo.setINDEX_VALUE(INDEX_VALUE);
			vo.setYear_Totacl(Year_Totacl);
			
			list.add(vo);
		}
		return list;
	}
	
	
	public List<SupperVo> initVO_MONTH() throws Exception, InterruptedException{
		List<SupperVo> list = new ArrayList<SupperVo>();
		dar.setTime(new Date());
		dar.add(Calendar.DAY_OF_YEAR, -1);
		String sDate = sdf1.format(dar.getTime());
		String sDay = sDate.substring(0, 10);
		String sql = "select KHID,ID,SDATE,HGL " +
				"from HISKH.hiskh_statistic_month@ZDH.TMR.REGRESS.RDBMS.DEV.US.ORACLE.COM t " +
				"where KHID like '%330KHV' " +
				"and operation ='dyhgla'  " +
				"and sdate ='"+sDay+"'";
		ResultSet set = null;
		set = resuletSet(sql);
		String companyid="";
		String companyName="";
		String COUNTCYCLE="02";
		String COUNT_DATE=sDay;
		String INDEX_NAME="01";
		String INDEX_VALUE="100";
		String Year_Totacl="100";
		while(set.next()){
			companyid=set.getString("KHID");
			companyName=set.getString("ID");
			COUNT_DATE=set.getString("SDATE");
			INDEX_VALUE=set.getString("HGL");
			
			VODWDYTJ vo = new VODWDYTJ();
			vo.setCOMPANYID(companyid);
			vo.setCOMPANYNAME(companyName);
			vo.setCOUNTCYCLE(COUNTCYCLE);
			vo.setCOUNT_DATE(COUNT_DATE);
			vo.setINDEX_NAME(INDEX_NAME);
			vo.setINDEX_VALUE(INDEX_VALUE);
			vo.setYear_Totacl(Year_Totacl);
			
			list.add(vo);
		}
		return list;
	}
	
	public List<SupperVo> initVO_Day() throws InterruptedException, Exception{
		List<SupperVo> list = new ArrayList<SupperVo>();
		dar.setTime(new Date());
		dar.add(Calendar.DAY_OF_YEAR, -1);
		String sDate = sdf1.format(dar.getTime());
		String sDay = sDate.substring(0, 10);
		String sql ="SELECT  KHID,ID,SDATE,HGL FROM " +
					"HISKH.hiskh_statistic_day@ZDH.TMR.REGRESS.RDBMS.DEV.US.ORACLE.COM"+
					" WHERE khid like '%330KHV' AND operation NOT like '%a'" +
					" and sdate='"+sDay+"'";
		
		
		ResultSet set = null;
		set = resuletSet(sql);
		String companyid="";
		String companyName="";
		String COUNTCYCLE="01";
		String COUNT_DATE=sDay;
		String INDEX_NAME="01";
		String INDEX_VALUE="100";
		String Year_Totacl="100";
		while(set != null && set.next()){
			companyid=set.getString("KHID");
			companyName=set.getString("ID");
			companyName=companyName.substring(0,companyName.indexOf("3"));
			COUNT_DATE = set.getString("SDATE");
			INDEX_VALUE= set.getString("HGL");
			
			VODWDYTJ vo = new VODWDYTJ();
			vo.setCOMPANYID(companyid);
			vo.setCOMPANYNAME(companyName);
			vo.setCOUNTCYCLE(COUNTCYCLE);
			vo.setCOUNT_DATE(COUNT_DATE);
			vo.setINDEX_NAME(INDEX_NAME);
			vo.setINDEX_VALUE(INDEX_VALUE);
			vo.setYear_Totacl(Year_Totacl);
			list.add(vo);
			
		}

		return list;
	}
	
}
