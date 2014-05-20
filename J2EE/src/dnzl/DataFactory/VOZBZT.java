package dnzl.DataFactory;

public class VOZBZT extends SupperVo{
/*
 * 
	--主网变压器状态切换
	--66kV及以上设备停运记录数据
	CREATE TABLE DIANNENGZHILIANG.HANDLERESULT_ZT_ZB(
		recordid		NUMBER(20),		--主键
		COMPANYID		VARCHAR2(50),	--所属市局编码
		COMPANYNAME		VARCHAR2(128),	--所属市局名称
		SUB_CODE		VARCHAR2(42),	--变压器编码
		SUB_NAME		VARCHAR2(128),	--变压器名称
		CHANGE_TIME		DATETIME,		--切换时刻
		G_YOUGONG		NUMBER(12,3),	--高压端有功
		Z_YOUGONG		NUMBER(12,3),	--中压端有功
		D_YOUGONG		NUMBER(12,3),	--低压端有功
		G_WEIZHI		VARCHAR2(60),	--高压侧接头位置
		Z_WEIZHI		VARCHAR2(60),	--中压侧接头位置
		LAST_G			NUMBER(2),		--切换前高压侧状态 0表示断开 1表示合上
		LAST_Z			NUMBER(2),		--切换前中压侧状态 0表示断开 1表示合上
		LAST_D			NUMBER(2),		--切换前低压侧状态 0表示断开 1表示合上
		LOWER_G			NUMBER(2),		--切换后高压侧状态 0表示断开 1表示合上
		LOWER_Z			NUMBER(2),		--切换后中压侧状态 0表示断开 1表示合上
		LOWER_D			NUMBER(2)		--切换后低压侧状态 0表示断开 1表示合上	
	);
 */
	public String	recordid="DIANNENGZHILIANG.SEQ_RECORDID.nextval";
	public String	COMPANYID="41301056630101000";
	public String	COMPANYNAME="青海省电力公司";
	public String	SUB_CODE;
	public String	SUB_NAME;
	public String	CHANGE_TIME;
	public String	G_YOUGONG;
	public String	Z_YOUGONG;
	public String	D_YOUGONG;
	public String	G_WEIZHI;
	public String	Z_WEIZHI;
	public String	LAST_G;
	public String	LAST_Z;
	public String	LAST_D;
	public String	LOWER_G;
	public String	LOWER_Z;
	public String	LOWER_D;
	
	@Override
	public String SaveStr() {
		String temp="INSERT INTO DIANNENGZHILIANG.HANDLERESULT_ZT_ZB(" +
				"recordid,"+
				"COMPANYID,"+
				"COMPANYNAME,"+
				"SUB_CODE,"+
				"SUB_NAME,"+
				"CHANGE_TIME,"+
				"G_YOUGONG,"+
				"Z_YOUGONG,"+
				"D_YOUGONG,"+
				"G_WEIZHI,"+
				"Z_WEIZHI,"+
				"LAST_G,"+
				"LAST_Z,"+
				"LAST_D,"+
				"LOWER_G,"+
				"LOWER_Z,"+
				"LOWER_D) VALUES(" +
				recordid+","+
				"\'"+COMPANYID+"\',"+
				"\'"+COMPANYNAME+"\',"+
				"\'"+SUB_CODE+"\',"+
				"\'"+SUB_NAME+"\',"+
				"to_date(\'"+CHANGE_TIME+"\',\'yyyy-MM-dd HH:mi:ss\')"+","+
				G_YOUGONG+","+
				Z_YOUGONG+","+
				D_YOUGONG+","+
				"\'"+G_WEIZHI+","+
				"\'"+Z_WEIZHI+","+
				LAST_G+","+
				LAST_Z+","+
				LAST_D+","+
				LOWER_G+","+
				LOWER_Z+","+
				LOWER_D+
				")";
		return temp;
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
	public String getSUB_CODE() {
		return SUB_CODE;
	}
	public void setSUB_CODE(String sUBCODE) {
		SUB_CODE = sUBCODE;
	}
	public String getSUB_NAME() {
		return SUB_NAME;
	}
	public void setSUB_NAME(String sUBNAME) {
		SUB_NAME = sUBNAME;
	}
	public String getCHANGE_TIME() {
		return CHANGE_TIME;
	}
	public void setCHANGE_TIME(String cHANGETIME) {
		CHANGE_TIME = cHANGETIME;
	}
	public String getG_YOUGONG() {
		return G_YOUGONG;
	}
	public void setG_YOUGONG(String gYOUGONG) {
		G_YOUGONG = gYOUGONG;
	}
	public String getZ_YOUGONG() {
		return Z_YOUGONG;
	}
	public void setZ_YOUGONG(String zYOUGONG) {
		Z_YOUGONG = zYOUGONG;
	}
	public String getD_YOUGONG() {
		return D_YOUGONG;
	}
	public void setD_YOUGONG(String dYOUGONG) {
		D_YOUGONG = dYOUGONG;
	}
	public String getG_WEIZHI() {
		return G_WEIZHI;
	}
	public void setG_WEIZHI(String gWEIZHI) {
		G_WEIZHI = gWEIZHI;
	}
	public String getZ_WEIZHI() {
		return Z_WEIZHI;
	}
	public void setZ_WEIZHI(String zWEIZHI) {
		Z_WEIZHI = zWEIZHI;
	}
	public String getLAST_G() {
		return LAST_G;
	}
	public void setLAST_G(String lASTG) {
		LAST_G = lASTG;
	}
	public String getLAST_Z() {
		return LAST_Z;
	}
	public void setLAST_Z(String lASTZ) {
		LAST_Z = lASTZ;
	}
	public String getLAST_D() {
		return LAST_D;
	}
	public void setLAST_D(String lASTD) {
		LAST_D = lASTD;
	}
	public String getLOWER_G() {
		return LOWER_G;
	}
	public void setLOWER_G(String lOWERG) {
		LOWER_G = lOWERG;
	}
	public String getLOWER_Z() {
		return LOWER_Z;
	}
	public void setLOWER_Z(String lOWERZ) {
		LOWER_Z = lOWERZ;
	}
	public String getLOWER_D() {
		return LOWER_D;
	}
	public void setLOWER_D(String lOWERD) {
		LOWER_D = lOWERD;
	}
	@Override
	public String toString() {
		return "VOZBZT [CHANGE_TIME=" + CHANGE_TIME + ", COMPANYID="
				+ COMPANYID + ", COMPANYNAME=" + COMPANYNAME + ", D_YOUGONG="
				+ D_YOUGONG + ", G_WEIZHI=" + G_WEIZHI + ", G_YOUGONG="
				+ G_YOUGONG + ", LAST_D=" + LAST_D + ", LAST_G=" + LAST_G
				+ ", LAST_Z=" + LAST_Z + ", LOWER_D=" + LOWER_D + ", LOWER_G="
				+ LOWER_G + ", LOWER_Z=" + LOWER_Z + ", SUB_CODE=" + SUB_CODE
				+ ", SUB_NAME=" + SUB_NAME + ", Z_WEIZHI=" + Z_WEIZHI
				+ ", Z_YOUGONG=" + Z_YOUGONG + ", recordid=" + recordid + "]";
	}
	
	
	
}
