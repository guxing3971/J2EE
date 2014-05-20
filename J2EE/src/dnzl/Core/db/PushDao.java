package dnzl.Core.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("static-access")
public class PushDao extends SysdbConn {
	private static Connection db_con =null;

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
		initdb();
		ResultSet res = null;
		List<Object> list = new ArrayList<Object>();
		String sql = "SELECT recordid, JobEname, JobCname, JobType, F_Data, F_SQL, T_Data, T_SQL, "
				+ "FTP_Ename, FTP_Cname, Esb_URL,"
				+ " Esb_type, Task, cron, status FROM INTERFACE.push_Job_Config where status='ok'";
		res = this.db_con.createStatement().executeQuery(sql);
		while (res.next()) {
			PushVO push = new PushVO();
			push.setRecordid(res.getString("recordid"));
			push.setJobEname(res.getString("JobEname"));
			push.setJobCname(res.getString("JobCname"));
			push.setJobType(res.getString("JobType"));
			push.setF_Data(res.getString("F_Data"));
			push.setF_SQL(res.getString("F_SQL"));
			push.setT_Data(res.getString("T_Data"));
			push.setT_SQL(res.getString("T_SQL"));
			push.setFTP_Ename(res.getString("FTP_Ename"));
			push.setFTP_Cname(res.getString("FTP_Cname"));
			push.setESB_URL(res.getString("Esb_URL"));
			push.setESB_type(res.getString("Esb_type"));
			push.setTask(res.getString("Task"));
			push.setCron(res.getString("cron"));
			push.setStatus(res.getString("status"));

			list.add(push);

		}
		destory();
		return list;
	}

	public boolean Update(String column, String value, String recordid)
			throws SQLException {
		initdb();
		boolean res = false;
		String sql = "update INTERFACE.push_Job_Config set " + column + "="
				+ value + " where recordid=" + recordid;
		res = this.db_con.createStatement().execute(sql);
		destory();
		return res;
	}
}
