package dnzl.Core.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("static-access")
public class FTPDao extends SysdbConn {
	private static Connection db_con = null;

	public void initdb() {
		db_con = SysdbConn.initByJNDI("DNZL");
	}

	public void destory(){
		try {
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Object> AllPushJob() throws SQLException {
		ResultSet res = null;
		initdb();
		List<Object> list = new ArrayList<Object>();
		String sql = "SELECT recordid, hostName, hostStatus, FTP_Ename, FTP_Cname,FTP_port, FTP_user, FTP_pass, FTP_status, FTP_Readme FROM INTERFACE.FTP_config";
		res = this.db_con.createStatement().executeQuery(sql);
		while (res.next()) {
			FTPVO ftpvo = new FTPVO();
			ftpvo.setRecordid(res.getString("recordid"));
			ftpvo.setHostName(res.getString("hostName"));
			ftpvo.setHostStatus(res.getString("hostStatus"));
			ftpvo.setFTP_EName(res.getString("FTP_Ename"));
			ftpvo.setFTP_CName(res.getString("FTP_Cname"));
			ftpvo.setFTP_user(res.getString("FTP_user"));
			ftpvo.setFTP_pass(res.getString("FTP_pass"));
			ftpvo.setFTP_port(res.getString("FTP_port"));
			ftpvo.setFTP_status(res.getString("FTP_status"));
			ftpvo.setFTP_readme(res.getString("FTP_Readme"));

			list.add(ftpvo);
		}
		destory();
		return list;
	}

	public boolean Update(String column, String value, String recordid)
			throws SQLException {
		boolean res = false;
		initdb();
		String sql = "update INTERFACE.ftp_config set " + column + "=" + value
				+ " where recordid=" + recordid;
		res = this.db_con.createStatement().execute(sql);
		destory();
		return res;
	}

	public FTPVO getVOByEname(String ename) throws SQLException {
		initdb();
		FTPVO vo = new FTPVO();
		ResultSet res = null;
		String sql = "SELECT recordid, hostName, hostStatus,FTP_Ename, FTP_Cname, FTP_user, FTP_pass, FTP_port,FTP_status,"
				+ " FTP_Readme FROM INTERFACE.FTP_config where FTP_Ename=\'"
				+ ename + "\'";
		res = this.db_con.createStatement().executeQuery(sql);
		while (res.next()) {
			vo.setRecordid(res.getString("recordid"));
			vo.setHostName(res.getString("hostName"));
			vo.setHostStatus(res.getString("hostStatus"));
			vo.setFTP_EName(res.getString("FTP_Ename"));
			vo.setFTP_CName(res.getString("FTP_Cname"));
			vo.setFTP_user(res.getString("FTP_user"));
			vo.setFTP_pass(res.getString("FTP_pass"));
			vo.setFTP_port(res.getString("FTP_port"));
			vo.setFTP_status(res.getString("FTP_status"));
			vo.setFTP_readme(res.getString("FTP_Readme"));
		}
		destory();
		return vo;
	}
}
