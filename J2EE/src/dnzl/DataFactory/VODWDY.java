package dnzl.DataFactory;
/*
 * --电网电压
	CREATE TABLE DIANNENGZHILIANG.HANDLERESULT_DWDY(
		recordid		NUMBER(20),		--主键
		COMPANYID		VARCHAR2(50),	--单位编码
		COMPANYNAME		VARCHAR2(128),	--所属单位名称
		MX_CODE			VARCHAR2(42),	--母线编码
		MX_NAME			VARCHAR2(60),	--母线名称
		COUNT_DATE		DATETIME,		--统计日期 YYYY-MM-DD HH:MM:SS
		RUN_TIME		NUMBER(10),		--上一小时运行时间总长
		TOPLIMIT_CD		NUMBER(10),		--上一小时越上限时间总长
		LOWERLIMIT_CD	NUMBER(10),		--上一小时越下限时间总长
		TOPLIMIT		NUMBER(12,3),	--上一小时最高电压 KV
		TOPLIMIT_TIME	DATETIME,		--最高电压发生时刻
		LOWERLIMIT		NUMBER(12,3),	--上一小时最低电压
		LOWERLIMIT_TIME	DATETIME,		--最低电压发生时刻
		PERCENTS		NUMBER(12,3)	--上一小时合格率
	);
 */
public class VODWDY extends SupperVo{
	@Override
	public String toString() {
		return "VODWDY [COMPANYID=" + COMPANYID + ", COMPANYNAME="
				+ COMPANYNAME + ", COUNT_DATE=" + COUNT_DATE + ", LOWERLIMIT="
				+ LOWERLIMIT + ", LOWERLIMIT_CD=" + LOWERLIMIT_CD
				+ ", LOWERLIMIT_TIME=" + LOWERLIMIT_TIME + ", MX_CODE="
				+ MX_CODE + ", MX_NAME=" + MX_NAME + ", PERCENTS=" + PERCENTS
				+ ", RUN_TIME=" + RUN_TIME + ", TOPLIMIT=" + TOPLIMIT
				+ ", TOPLIMIT_CD=" + TOPLIMIT_CD + ", TOPLIMIT_TIME="
				+ TOPLIMIT_TIME + ", recordid=" + recordid + "]";
	}




	private	String	recordid="DIANNENGZHILIANG.SEQ_RECORDID.nextval";
	private	String	COMPANYID="41301056630101000";
	private	String	COMPANYNAME="青海省电力公司";
	private	String	MX_CODE;
	private	String	MX_NAME;
	private	String	COUNT_DATE = sDate;
	private	String	RUN_TIME;
	private	String	TOPLIMIT_CD="0";
	private	String	LOWERLIMIT_CD="0";
	private	String	TOPLIMIT;
	private	String	TOPLIMIT_TIME;
	private	String	LOWERLIMIT;
	private	String	LOWERLIMIT_TIME;
	private	String	PERCENTS="100.00";
	
	
	
	
	@Override
	public String SaveStr() {
		StringBuffer temp = new StringBuffer();
		temp.append("INSERT INTO DIANNENGZHILIANG.HANDLERESULT_DWDY(" +
				"recordid,"+
				"COMPANYID,"+
				"COMPANYNAME,"+
				"MX_CODE,"+
				"MX_NAME,"+
				"COUNT_DATE,"+
				"RUN_TIME,"+
				"TOPLIMIT_CD,"+
				"LOWERLIMIT_CD,"+
				"TOPLIMIT,"+
				"TOPLIMIT_TIME,"+
				"LOWERLIMIT,"+
				"LOWERLIMIT_TIME,"+
				"PERCENTS) VALUES("+
					recordid+",\'"+
					COMPANYID+"\',\'"+
					COMPANYNAME+"\',\'"+
					MX_CODE+"\',\'"+
					MX_NAME+"\',"+
					"TO_DATE(\'"+COUNT_DATE+"\'),"+
					RUN_TIME+","+
					TOPLIMIT_CD+","+
					LOWERLIMIT_CD+","+
					TOPLIMIT+","+
					"TO_DATE(\'"+TOPLIMIT_TIME+"\'),"+
					LOWERLIMIT+","+
					"TO_DATE(\'"+LOWERLIMIT_TIME+"\'),"+
					PERCENTS
				+")"
			);
		return	temp.toString().replaceAll("to_date('null')", "null");
	}





	
	
	
	
	
	
	
	
	//getter setter
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




	public String getMX_CODE() {
		return MX_CODE;
	}




	public void setMX_CODE(String mXCODE) {
		MX_CODE = mXCODE;
	}




	public String getMX_NAME() {
		return MX_NAME;
	}




	public void setMX_NAME(String mXNAME) {
		MX_NAME = mXNAME;
	}




	public String getCOUNT_DATE() {
		return COUNT_DATE;
	}




	public void setCOUNT_DATE(String cOUNTDATE) {
		COUNT_DATE = cOUNTDATE;
	}




	public String getRUN_TIME() {
		return RUN_TIME;
	}




	public void setRUN_TIME(String rUNTIME) {
		RUN_TIME = rUNTIME;
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

	
	
}
