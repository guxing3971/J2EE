package dnzl.Core.db;

public class FTPVO {
	private String recordid;
	private String hostName;
	private String hostStatus;
	private String FTP_EName;
	private String FTP_CName;
	private String FTP_user;
	private String FTP_pass;
	private String FTP_status;
	private String FTP_readme;
	private String FTP_port;

	public String getFTP_port() {
		return FTP_port;
	}

	public void setFTP_port(String fTPPort) {
		FTP_port = fTPPort;
	}

	public String getFTP_readme() {
		return FTP_readme;
	}

	public void setFTP_readme(String fTPReadme) {
		FTP_readme = fTPReadme;
	}

	public String getRecordid() {
		return recordid;
	}

	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostStatus() {
		return hostStatus;
	}

	public void setHostStatus(String hostStatus) {
		this.hostStatus = hostStatus;
	}

	public String getFTP_EName() {
		return FTP_EName;
	}

	public void setFTP_EName(String fTPEName) {
		FTP_EName = fTPEName;
	}

	public String getFTP_CName() {
		return FTP_CName;
	}

	public void setFTP_CName(String fTPCName) {
		FTP_CName = fTPCName;
	}

	public String getFTP_user() {
		return FTP_user;
	}

	public void setFTP_user(String fTPUser) {
		FTP_user = fTPUser;
	}

	public String getFTP_pass() {
		return FTP_pass;
	}

	public void setFTP_pass(String fTPPass) {
		FTP_pass = fTPPass;
	}

	public String getFTP_status() {
		return FTP_status;
	}

	public void setFTP_status(String fTPStatus) {
		FTP_status = fTPStatus;
	}

	@Override
	public String toString() {
		return "FTPVO [FTP_CName=" + FTP_CName + ", FTP_EName=" + FTP_EName
				+ ", FTP_pass=" + FTP_pass + ", FTP_port=" + FTP_port
				+ ", FTP_readme=" + FTP_readme + ", FTP_status=" + FTP_status
				+ ", FTP_user=" + FTP_user + ", hostName=" + hostName
				+ ", hostStatus=" + hostStatus + ", recordid=" + recordid + "]";
	}

}
