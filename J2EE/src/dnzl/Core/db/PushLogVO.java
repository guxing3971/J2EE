package dnzl.Core.db;

public class PushLogVO {
	private String recordid;
	private String JobEname;
	private String JobCname;
	private String JobType;
	private String Time_Start;
	private String Time_End;
	private String F_count;
	private String T_count;
	private String status;
	private String statusNode;

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

	public String getTime_Start() {
		return Time_Start;
	}

	public void setTime_Start(String timeStart) {
		Time_Start = timeStart;
	}

	public String getTime_End() {
		return Time_End;
	}

	public void setTime_End(String timeEnd) {
		Time_End = timeEnd;
	}

	public String getF_count() {
		return F_count;
	}

	public void setF_count(String fCount) {
		F_count = fCount;
	}

	public String getT_count() {
		return T_count;
	}

	public void setT_count(String tCount) {
		T_count = tCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusNode() {
		return statusNode;
	}

	public void setStatusNode(String statusNode) {
		this.statusNode = statusNode;
	}

	@Override
	public String toString() {
		return "PusgLogDao [F_count=" + F_count + ", JobCname=" + JobCname
				+ ", JobEname=" + JobEname + ", JobType=" + JobType
				+ ", T_count=" + T_count + ", Time_End=" + Time_End
				+ ", Time_Start=" + Time_Start + ", recordid=" + recordid
				+ ", status=" + status + ", statusNode=" + statusNode + "]";
	}
}
