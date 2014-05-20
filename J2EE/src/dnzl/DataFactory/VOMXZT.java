package dnzl.DataFactory;

public class VOMXZT extends SupperVo {

	/*
	 * --数据包括为：66KV及以上设备停运记录数据规范
		CREATE TABLE DIANNENGZHILIANG.HANDLERESULT_ZT_MX(
			recordid		NUMBER(20),		--主键
			COMPANYID		VARCHAR2(50),	--所属市局编码
			COMPANYNAME		VARCHAR2(128),	--所属市局名称
			MX_CODE			VARCHAR2(42),	--母线编码
			MX_NAME			VARCHAR2(128),	--母线名称
			CHANGE_TIME		DATETIME,		--状态切换时刻
			LAST_STATUS		NUMBER(2),		--切换前状态
			LOWER_STATUS	NUMBER(2)		--切换后状态
		);
	 */
	public String recordid ="DIANNENGZHILIANG.SEQ_RECORDID.nextval";
	public String COMPANYID="41301056630101000";
	public String COMPANYNAME="青海省电力公司";
	public String MX_CODE;
	public String MX_NAME;
	public String CHANGE_TIME;
	public String LAST_STATUS;
	public String LOWER_STATUS;
	
	
	
	@Override
	public String SaveStr() {
		String temp ="INSERT INTO DIANNENGZHILIANG.HANDLERESULT_ZT_MX(" +
				"recordid,"+
				"COMPANYID,"+
				"COMPANYNAME,"+
				"MX_CODE,"+
				"MX_NAME,"+
				"CHANGE_TIME,"+
				"LAST_STATUS,"+
				"LOWER_STATUS) VALUES(" +
				recordid+","+
				"\'"+COMPANYID+"\',"+
				"\'"+COMPANYNAME+"\',"+
				"\'"+MX_CODE+"\',"+
				"\'"+MX_NAME+"\',"+
				"to_date(\'"+CHANGE_TIME+"\',\'yyyy-MM-dd HH:mi:ss\')"+","+
				LAST_STATUS+","+
				LOWER_STATUS+
				")";
		return temp;
	}
	@Override
	public String toString() {
		return "VOMXZT [CHANGE_TIME=" + CHANGE_TIME + ", COMPANYID="
				+ COMPANYID + ", COMPANYNAME=" + COMPANYNAME + ", LAST_STATUS="
				+ LAST_STATUS + ", LOWER_STATUS=" + LOWER_STATUS + ", MX_CODE="
				+ MX_CODE + ", MX_NAME=" + MX_NAME + ", recordid=" + recordid
				+ "]";
	}
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
	public String getCHANGE_TIME() {
		return CHANGE_TIME;
	}
	public void setCHANGE_TIME(String cHANGETIME) {
		CHANGE_TIME = cHANGETIME;
	}
	public String getLAST_STATUS() {
		return LAST_STATUS;
	}
	public void setLAST_STATUS(String lASTSTATUS) {
		LAST_STATUS = lASTSTATUS;
	}
	public String getLOWER_STATUS() {
		return LOWER_STATUS;
	}
	public void setLOWER_STATUS(String lOWERSTATUS) {
		LOWER_STATUS = lOWERSTATUS;
	}
	
	
}
