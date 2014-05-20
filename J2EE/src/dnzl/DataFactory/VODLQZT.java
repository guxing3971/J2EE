package dnzl.DataFactory;

public class VODLQZT extends SupperVo{
/*
 * --断路器状态切换
	--66kV及以上设备停运记录数据
	CREATE TABLE DIANNENGZHILIANG.HANDLERESULT_ZT_DLQ(
		recordid		NUMBER(20),		--主键
		COMPANYID		VARCHAR2(50),	--所属市局编码
		COMPANYNAME		VARCHAR2(128),	--所属市局名称
		BREAKER_CODE	VARCHAR2(42),	--断路器编码
		BREAKER_NAME	VARCHAR2(128),	--断路器名称
		CHANGe_TIME		DATETIME,		--切换时候
		LAST_STATUS		NUMBER(2),		--切换前断路器状态 0表示断开 1表示合上
		LOWER_STATUS	NUMBER(2)		--切换后断路器状态 0表示断开 1表示合上
	);
 */
	
	public String recordid="DIANNENGZHILIANG.SEQ_RECORDID.nextval";
	public String COMPANYID="41301056630101000";
	public String COMPANYNAME="青海省电力公司";
	public String BREAKER_CODE;
	public String BREAKER_NAME;
	public String CHANGe_TIME;
	public String LAST_STATUS;
	public String LOWER_STATUS;
	
	
	@Override
	public String SaveStr() {
		String str_ChangeTime = null;
		if("null".equals(CHANGe_TIME)){
			str_ChangeTime ="null";
		}else{
			str_ChangeTime ="to_date(\'"+CHANGe_TIME+"\',\'yyyy-MM-dd HH:mi:ss\')";
		}
		String temp="INSERT INTO DIANNENGZHILIANG.HANDLERESULT_ZT_DLQ(" +
				"recordid,"+
				"COMPANYID,"+
				"COMPANYNAME,"+
				"BREAKER_CODE,"+
				"BREAKER_NAME,"+
				"CHANGe_TIME,"+
				"LAST_STATUS,"+
				"LOWER_STATUS) VALUES(" +
				recordid+","+
				"\'"+COMPANYID+"\',"+
				"\'"+COMPANYNAME+"\',"+
				"\'"+BREAKER_CODE+"\',"+
				"\'"+BREAKER_NAME+"\',"+
				str_ChangeTime+","+
				LAST_STATUS+","+
				LOWER_STATUS+
				")";
		return temp;
	}
	@Override
	public String toString() {
		return "VODLQZT [BREAKER_CODE=" + BREAKER_CODE + ", BREAKER_NAME="
				+ BREAKER_NAME + ", CHANG_TIME=" + CHANGe_TIME + ", COMPANYID="
				+ COMPANYID + ", COMPANYNAME=" + COMPANYNAME + ", LAST_STATUS="
				+ LAST_STATUS + ", LOWER_STATUS=" + LOWER_STATUS
				+ ", recordid=" + recordid + "]";
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
	public String getBREAKER_CODE() {
		return BREAKER_CODE;
	}
	public void setBREAKER_CODE(String bREAKERCODE) {
		BREAKER_CODE = bREAKERCODE;
	}
	public String getBREAKER_NAME() {
		return BREAKER_NAME;
	}
	public void setBREAKER_NAME(String bREAKERNAME) {
		BREAKER_NAME = bREAKERNAME;
	}
	public String getCHANG_TIME() {
		return CHANGe_TIME;
	}
	public void setCHANG_TIME(String cHANGTIME) {
		CHANGe_TIME = cHANGTIME;
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
