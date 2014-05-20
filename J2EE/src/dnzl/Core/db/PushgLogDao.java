package dnzl.Core.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("static-access")
public class PushgLogDao {
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
		initdb();
		ResultSet res = null;
		List<Object> list = new ArrayList<Object>();
		String sql = "SELECT recordid, JobEname, JobCname, JobType, Time_Start, Time_end, F_count,"
				+ " T_count, status, statusNode FROM INTERFACE.push_Job_log";
		res = this.db_con.createStatement().executeQuery(sql);
		while (res.next()) {

			PushLogVO pushlog = new PushLogVO();
			pushlog.setRecordid(res.getString("recordid"));
			pushlog.setJobEname(res.getString("JobEname"));
			pushlog.setJobCname(res.getString("JobCname"));
			pushlog.setJobType(res.getString("JobType"));
			pushlog.setTime_Start(res.getString("Time_Start"));
			pushlog.setTime_End(res.getString("Time_end"));
			pushlog.setF_count(res.getString("F_count"));
			pushlog.setT_count(res.getString("T_count"));
			pushlog.setStatus(res.getString("status"));
			pushlog.setStatusNode(res.getString("statusNode"));

			list.add(pushlog);
		}
		destory();
		return list;
	}

	public boolean Update(String column, String value, String recordid)
			throws SQLException {
		initdb();
		boolean res = false;
		String sql = null;
		if (column.startsWith("Time")) {
			sql = "update INTERFACE.push_Job_log set " + column + "=\'" + value
					+ "\' where recordid=" + recordid;
		} else {
			sql = "update INTERFACE.push_Job_log set " + column + "=" + value
					+ " where recordid=" + recordid;
		}
		res = this.db_con.createStatement().execute(sql);
		return res;
	}

	public boolean Update_db(PushLogVO log) {
		boolean falg = false;
		initdb();
		String str = "INSERT INTO INTERFACE.push_Job_log(recordid,JobEname,JobCname,JobType,Time_Start,"
				+ "Time_end,F_count,T_count,status,statusNode) VALUES(";

		StringBuffer temp = new StringBuffer();
		temp.append(log.getRecordid());
		temp.append(",\'" + log.getJobEname() + "\'");
		temp.append(",\'" + log.getJobCname() + "\'");
		temp.append(",\'" + log.getJobType() + "\'");
		temp.append(",\'" + log.getTime_Start() + "\'");
		temp.append(",\'" + log.getTime_End() + "\'");
		temp.append(",\'" + log.getF_count() + "\'");
		temp.append(",\'" + log.getT_count() + "\'");
		temp.append(",\'" + log.getStatus() + "\'");
		temp.append(",\'" + log.getStatusNode() + "\')");
		str = str + temp.toString().replace("null", "0");

		try {
			falg = this.db_con.createStatement().execute(str);
		} catch (SQLException e) {
			System.out.println("更新数据推送日志出错" + str);
			e.printStackTrace();
		}
		destory();
		return falg;
	}
}
