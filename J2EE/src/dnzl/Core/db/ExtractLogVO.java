package dnzl.Core.db;

import java.io.Serializable;

public class ExtractLogVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String recordid;
	private String JobEName;
	private String JobCName;
	private String JobType;
	private String F_count;
	private String T_count;
	private String Time_Start;
	private String Time_End;
	private String status;
	private String statusNode;

	public String getRecordid() {
		return recordid;
	}

	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}

	public String getJobEName() {
		return JobEName;
	}

	public void setJobEName(String jobEName) {
		JobEName = jobEName;
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

	public String getJobCName() {
		return JobCName;
	}

	public void setJobCName(String jobCName) {
		JobCName = jobCName;
	}

	public String getJobType() {
		return JobType;
	}

	public void setJobType(String jobType) {
		JobType = jobType;
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
		return "ExtractLogVO [F_count=" + F_count + ", JobCName=" + JobCName
				+ ", JobEName=" + JobEName + ", JobType=" + JobType
				+ ", T_count=" + T_count + ", Time_End=" + Time_End
				+ ", Time_Start=" + Time_Start + ", recordid=" + recordid
				+ ", status=" + status + ", statusNode=" + statusNode + "]";
	}

}
