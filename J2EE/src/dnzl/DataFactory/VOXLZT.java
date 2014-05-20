package dnzl.DataFactory;

public class VOXLZT extends SupperVo{
/*
 	--线路状态切换
	--66kV及以上设备停运记录数据
	CREATE TABLE DIANNENGZHILIANG.HANDLERESULT_ZT_XL(
		recordid		NUMBER(20),		--主键
		COMPANYID		VARCHAR2(50),	--所属市局编码
		COMPANYNAME		VARCHAR2(128),	--所属市局名称
		LINE_CODE		VARCHAR2(42),	--线路编码
		LINE_NAME		VARCHAR2(128),	--线路名称
		CHANGE_TIME		DATETIME,		--切换时刻
		LAST_I			NUMBER(2),		--切换前I端状态	0表示断开 1表示合上
		LOWER_I			NUMBER(2),		--切换后I端状态 0表示断开 1表示合上
		LAST_J			NUMBER(2),		--切换前J端状态 0表示断开 1表示合上
		LOWER_J			NUMBER(2)		--切换后J端状态 0表示断开 1表示合上
	);
 */
	public String recordid="DIANNENGZHILIANG.SEQ_RECORDID.nextval";
	public String COMPANYID="41301056630101000";
	public String COMPANYNAME="青海省电力公司";
	public String LINE_CODE;
	public String LINE_NAME;
	public String CHANGE_TIME;
	public String LAST_I;
	public String LOWER_I;
	public String LAST_J;
	public String LOWER_J;
	
	
	
	@Override
	public String SaveStr() {
		String temp="INSERT INTO DIANNENGZHILIANG.HANDLERESULT_ZT_XL(" +
				"recordid,"+
				"COMPANYID,"+
				"COMPANYNAME,"+
				"LINE_CODE,"+
				"LINE_NAME,"+
				"CHANGE_TIME,"+
				"LAST_I,"+
				"LOWER_I,"+
				"LAST_J,"+
				"LOWER_J) VALUES(" +
				recordid+","+
				"\'"+COMPANYID+"\',"+
				"\'"+COMPANYNAME+"\',"+
				"\'"+LINE_CODE+"\',"+
				"\'"+LINE_NAME+"\',"+
				"to_date(\'"+CHANGE_TIME+"\',\'yyyy-MM-dd HH:mi:ss\')"+","+
				LAST_I+","+
				LOWER_I+","+
				LAST_J+","+
				LOWER_J+
				")";
		return temp;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public String toString() {
		return "VOXLZT [CHANGE_TIME=" + CHANGE_TIME + ", COMPANYID="
				+ COMPANYID + ", COMPANYNAME=" + COMPANYNAME + ", LAST_I="
				+ LAST_I + ", LAST_J=" + LAST_J + ", LINE_CODE=" + LINE_CODE
				+ ", LINE_NAME=" + LINE_NAME + ", LOWER_I=" + LOWER_I
				+ ", LOWER_J=" + LOWER_J + ", recordid=" + recordid + "]";
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
	public String getLINE_CODE() {
		return LINE_CODE;
	}
	public void setLINE_CODE(String lINECODE) {
		LINE_CODE = lINECODE;
	}
	public String getLINE_NAME() {
		return LINE_NAME;
	}
	public void setLINE_NAME(String lINENAME) {
		LINE_NAME = lINENAME;
	}
	public String getCHANGE_TIME() {
		return CHANGE_TIME;
	}
	public void setCHANGE_TIME(String cHANGETIME) {
		CHANGE_TIME = cHANGETIME;
	}
	public String getLAST_I() {
		return LAST_I;
	}
	public void setLAST_I(String lASTI) {
		LAST_I = lASTI;
	}
	public String getLOWER_I() {
		return LOWER_I;
	}
	public void setLOWER_I(String lOWERI) {
		LOWER_I = lOWERI;
	}
	public String getLAST_J() {
		return LAST_J;
	}
	public void setLAST_J(String lASTJ) {
		LAST_J = lASTJ;
	}
	public String getLOWER_J() {
		return LOWER_J;
	}
	public void setLOWER_J(String lOWERJ) {
		LOWER_J = lOWERJ;
	}
	
	
}
