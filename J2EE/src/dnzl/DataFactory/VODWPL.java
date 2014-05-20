package dnzl.DataFactory;



/*
 * --recordid的序列
 	SEQ_RECORDID
 * --电网频率
	CREATE TABLE DIANNENGZHILIANG.HANDLERESULT_DWPL(
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
public class VODWPL extends SupperVo{
	
	
	@Override
	public String toString() {
		return "VODWPL [COMPANYID=" + COMPANYID + ", COMPANYNAME="
				+ COMPANYNAME + ", COUNT_DATE=" + COUNT_DATE + ", LOWERLIMIT="
				+ LOWERLIMIT + ", LOWERLIMIT_CD=" + LOWERLIMIT_CD
				+ ", LOWERLIMIT_TIME=" + LOWERLIMIT_TIME + ", PERCENTS="
				+ PERCENTS + ", TOPLIMIT=" + TOPLIMIT + ", TOPLIMIT_CD="
				+ TOPLIMIT_CD + ", TOPLIMIT_TIME=" + TOPLIMIT_TIME
				+ ", YearLowerLimit_CD=" + YearLowerLimit_CD
				+ ", YearPercents=" + YearPercents + ", YearTopLimit_CD="
				+ YearTopLimit_CD + ", recordid=" + recordid + "]";
	}







	public String recordid	="DIANNENGZHILIANG.SEQ_RECORDID.nextval";
	public String COMPANYID ="41301056630101000";
	public String COMPANYNAME="青海省电力公司";
	public String COUNT_DATE =sDate;
	public String TOPLIMIT_CD;
	public String LOWERLIMIT_CD;
	public String TOPLIMIT;
	public String TOPLIMIT_TIME;
	public String LOWERLIMIT;
	public String LOWERLIMIT_TIME;
	public String PERCENTS;
	public String YearTopLimit_CD;
	public String YearLowerLimit_CD;
	public String YearPercents;

	
	
	
	public String getRecordid() {
		return recordid;
	}




	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}




	public String getCOMPANYID() {
		return COMPANYID;
	}




	public void setCOMPANYID(String cOMPANYID) {
		COMPANYID = cOMPANYID;
	}




	public String getCOMPANYNAME() {
		return COMPANYNAME;
	}




	public void setCOMPANYNAME(String cOMPANYNAME) {
		COMPANYNAME = cOMPANYNAME;
	}




	public String getCOUNT_DATE() {
		return COUNT_DATE;
	}




	public void setCOUNT_DATE(String cOUNTDATE) {
		COUNT_DATE = cOUNTDATE;
	}




	public String getTOPLIMIT_CD() {
		return TOPLIMIT_CD;
	}




	public void setTOPLIMIT_CD(String tOPLIMITCD) {
		TOPLIMIT_CD = tOPLIMITCD;
	}




	public String getLOWERLIMIT_CD() {
		return LOWERLIMIT_CD;
	}




	public void setLOWERLIMIT_CD(String lOWERLIMITCD) {
		LOWERLIMIT_CD = lOWERLIMITCD;
	}




	public String getTOPLIMIT() {
		return TOPLIMIT;
	}




	public void setTOPLIMIT(String tOPLIMIT) {
		TOPLIMIT = tOPLIMIT;
	}




	public String getTOPLIMIT_TIME() {
		return TOPLIMIT_TIME;
	}




	public void setTOPLIMIT_TIME(String tOPLIMITTIME) {
		TOPLIMIT_TIME = tOPLIMITTIME;
	}




	public String getLOWERLIMIT() {
		return LOWERLIMIT;
	}




	public void setLOWERLIMIT(String lOWERLIMIT) {
		LOWERLIMIT = lOWERLIMIT;
	}




	public String getLOWERLIMIT_TIME() {
		return LOWERLIMIT_TIME;
	}




	public void setLOWERLIMIT_TIME(String lOWERLIMITTIME) {
		LOWERLIMIT_TIME = lOWERLIMITTIME;
	}




	public String getPERCENTS() {
		return PERCENTS;
	}




	public void setPERCENTS(String pERCENTS) {
		PERCENTS = pERCENTS;
	}




	public String getYearTopLimit_CD() {
		return YearTopLimit_CD;
	}




	public void setYearTopLimit_CD(String yearTopLimitCD) {
		YearTopLimit_CD = yearTopLimitCD;
	}




	public String getYearLowerLimit_CD() {
		return YearLowerLimit_CD;
	}




	public void setYearLowerLimit_CD(String yearLowerLimitCD) {
		YearLowerLimit_CD = yearLowerLimitCD;
	}




	public String getYearPercents() {
		return YearPercents;
	}




	public void setYearPercents(String yearPercents) {
		YearPercents = yearPercents;
	}







	@Override
	public String SaveStr() {
		StringBuffer temp = new StringBuffer();
		temp.append("INSERT INTO DIANNENGZHILIANG.HANDLERESULT_DWPL(" +
				"recordid,COMPANYID,COMPANYNAME,COUNT_DATE,TOPLIMIT_CD," +
				"LOWERLIMIT_CD,TOPLIMIT,TOPLIMIT_TIME,LOWERLIMIT,LOWERLIMIT_TIME," +
				"PERCENTS,YearTopLimit_CD,YearLowerLimit_CD,YearPercents) VALUES("+
				recordid+",\'"+
				COMPANYID+"\',\'"+
				COMPANYNAME+"\',"+
				"to_date(\'"+COUNT_DATE+"\'),"+
				TOPLIMIT_CD+","+
				LOWERLIMIT_CD+","+
				TOPLIMIT+","+
				"to_date(\'"+TOPLIMIT_TIME+"\'),"+
				LOWERLIMIT+","+
				"to_date(\'"+LOWERLIMIT_TIME+"\'),"+
				PERCENTS+","+
				YearTopLimit_CD+","+
				YearLowerLimit_CD+","+
				YearPercents+")");
		return	temp.toString().replaceAll("to_date('null')", "null");
	}

}
