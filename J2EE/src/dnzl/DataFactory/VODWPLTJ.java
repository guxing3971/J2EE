package dnzl.DataFactory;
/*
 * --电网频率统计值
	CREATE TABLE DIANNENGZHILIANG.HANDLERESULT_DWPLTJ(
		recordid		NUMBER(20),		--主键
		COMPANYID		VARCHAR2(50),	--单位编码
		COMPANYNAME		VARCHAR2(128),	--所属单位名称
		COUNTCYCLE		VARCHAR2(10),	--统计周期 01:日02:月03:季04:年
		COUNT_DATE		DATETIME,		--统计日期 YYYY-MM-DD HH:MM:SS
		INDEX_NAME		VARCHAR2(10),	--指标名称01合格率02越上限时长03越下限时长
		INDEX_VALUE		NUMBER(12,5),	--合格率：单位：%；越限时长：分钟
		yeartotal		NUMBER(20,4)	--年累计值	
	);
 */
public class VODWPLTJ extends SupperVo{
	@Override
	public String toString() {
		return "VODWPLTJ [COMPANYID=" + COMPANYID + ", COMPANYNAME="
				+ COMPANYNAME + ", COUNTCYCLE=" + COUNTCYCLE + ", COUNT_DATE="
				+ COUNT_DATE + ", INDEX_NAME=" + INDEX_NAME + ", INDEX_VALUE="
				+ INDEX_VALUE + ", recordid=" + recordid + ", yeartotal="
				+ yeartotal + "]";
	}

	public String recordid ="DIANNENGZHILIANG.SEQ_RECORDID.nextval";
	public String COMPANYID="41301056630101000";
	public String COMPANYNAME="青海省电力公司";
	public String COUNTCYCLE;
	public String COUNT_DATE;
	public String INDEX_NAME;
	public String INDEX_VALUE;
	public String yeartotal;
	

	@Override
	public String SaveStr() {
		StringBuffer temp = new StringBuffer();
		temp.append("INSERT INTO DIANNENGZHILIANG.HANDLERESULT_DWPLTJ(" +
				"recordid," +
				"COMPANYID," +
				"COMPANYNAME," +
				"COUNTCYCLE," +
				"COUNT_DATE," +
				"INDEX_NAME," +
				"INDEX_VALUE," +
				"yeartotal) VALUES(" +
				recordid+","+
				"\'"+COMPANYID+"\',"+
				"\'"+COMPANYNAME+"\',"+
				"\'"+COUNTCYCLE+"\',"+
				"to_date(\'"+COUNT_DATE+"\',\'yyyy-MM-dd HH:mi:ss\')"+","+
				"\'"+INDEX_NAME+"\',"+
				INDEX_VALUE+","+
				yeartotal+
				")");
		return temp.toString();
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

	public String getCOUNTCYCLE() {
		return COUNTCYCLE;
	}

	public void setCOUNTCYCLE(String cOUNTCYCLE) {
		COUNTCYCLE = cOUNTCYCLE;
	}

	public String getCOUNT_DATE() {
		return COUNT_DATE;
	}

	public void setCOUNT_DATE(String cOUNTDATE) {
		COUNT_DATE = cOUNTDATE;
	}

	public String getINDEX_NAME() {
		return INDEX_NAME;
	}

	public void setINDEX_NAME(String iNDEXNAME) {
		INDEX_NAME = iNDEXNAME;
	}

	public String getINDEX_VALUE() {
		return INDEX_VALUE;
	}

	public void setINDEX_VALUE(String iNDEXVALUE) {
		INDEX_VALUE = iNDEXVALUE;
	}

	public String getYeartotal() {
		return yeartotal;
	}

	public void setYeartotal(String yeartotal) {
		this.yeartotal = yeartotal;
	}
	
	
}
