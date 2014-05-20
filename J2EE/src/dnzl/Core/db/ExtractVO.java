package dnzl.Core.db;

public class ExtractVO {
	private String recordid;
	private String JobEname;
	private String JobCname;
	private String JobType;
	private String F_Data;
	private String F_SQL;
	private String T_Data;
	private String T_SQL;
	private String FTP_Ename;
	private String FTP_Cname;
	private String Task;
	private String cron;
	private String status;

	public String getRecordid() {
		return recordid;
	}

	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}

	public String getJobEname() {
		return JobEname;
	}

	public void setJobEname(String jobEname) {
		JobEname = jobEname;
	}

	public String getJobCname() {
		return JobCname;
	}

	public void setJobCname(String jobCname) {
		JobCname = jobCname;
	}

	public String getJobType() {
		return JobType;
	}

	public void setJobType(String jobType) {
		JobType = jobType;
	}

	public String getF_Data() {
		return F_Data;
	}

	public void setF_Data(String fData) {
		F_Data = fData;
	}

	public String getF_SQL() {
		return F_SQL;
	}

	public void setF_SQL(String fSQL) {
		F_SQL = fSQL;
	}

	public String getT_Data() {
		return T_Data;
	}

	public void setT_Data(String tData) {
		T_Data = tData;
	}

	public String getT_SQL() {
		return T_SQL;
	}

	public void setT_SQL(String tSQL) {
		T_SQL = tSQL;
	}

	public String getFTP_Ename() {
		return FTP_Ename;
	}

	public void setFTP_Ename(String fTPEname) {
		FTP_Ename = fTPEname;
	}

	public String getFTP_Cname() {
		return FTP_Cname;
	}

	public void setFTP_Cname(String fTPCname) {
		FTP_Cname = fTPCname;
	}

	public String getTask() {
		return Task;
	}

	public void setTask(String task) {
		Task = task;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ExtractVO [FTP_Cname=" + FTP_Cname + ", FTP_Ename=" + FTP_Ename
				+ ", F_Data=" + F_Data + ", F_SQL=" + F_SQL + ", JobCname="
				+ JobCname + ", JobEname=" + JobEname + ", JobType=" + JobType
				+ ", T_Data=" + T_Data + ", T_SQL=" + T_SQL + ", Task=" + Task
				+ ", cron=" + cron + ", recordid=" + recordid + ", status="
				+ status + "]";
	}

}
