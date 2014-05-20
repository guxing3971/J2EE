package dnzl.Core.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("static-access")
public class ExtractLogDao {
	private static Connection db_con = null;

	public List<Object> AllPushJob() throws SQLException, ParseException {
		
		db_con=SysdbConn.initByJNDI("DNZL");
		ResultSet res = null;

		List<Object> list = new ArrayList<Object>();
		String sql = "SELECT recordid, JobEName, JobCName, JobType, F_count, T_count, Time_Start,"
				+ " Time_End, status, statusNode FROM INTERFACE.Extract_Job_Log";
		res = this.db_con.createStatement().executeQuery(sql);
		while (res.next()) {
			ExtractLogVO Extractlog = new ExtractLogVO();
			Extractlog.setRecordid(res.getString("recordid"));
			Extractlog.setJobEName(res.getString("JobEname"));
			Extractlog.setJobCName(res.getString("JobCname"));
			Extractlog.setJobType(res.getString("JobType"));
			Extractlog.setTime_Start(res.getString("Time_Start"));
			Extractlog.setTime_End(res.getString("Time_End"));
			Extractlog.setF_count(res.getString("F_count"));
			Extractlog.setT_count(res.getString("T_count"));
			Extractlog.setStatus(res.getString("status"));
			Extractlog.setStatusNode(res.getString("statusNode"));

			list.add(Extractlog);
		}
		db_con.close();
		return list;
	}

	public boolean Update(String column, String value, String recordid)
			throws SQLException {
		db_con =SysdbConn.initByJNDI("DNZL");
		boolean res = false;
		String sql = null;
		if (column.startsWith("Time")) {
			sql = "update INTERFACE.Extract_Job_log set " + column + "=\'"
					+ value + "\' where recordid=" + recordid;
		} else {
			sql = "update INTERFACE.Extract_Job_log set " + column + "="
					+ value + " where recordid=" + recordid;
		}
		res = this.db_con.createStatement().execute(sql);
		db_con.close();
		return res;
	}

	public boolean Update_db(ExtractLogVO vo) {
		
		db_con = SysdbConn.initByJNDI("DNZL");
		boolean flag = false;
		String str = "INSERT INTO INTERFACE.Extract_job_Log("
				+ "recordid, JobEName, JobCName, JobType,"
				+ "F_count, T_count, Time_Start,"
				+ "Time_End, status, statusNode) VALUES(";

		StringBuffer temp = new StringBuffer();
		temp.append(vo.getRecordid());
		temp.append(",\'" + vo.getJobEName() + "\'");
		temp.append(",\'" + vo.getJobCName() + "\'");
		temp.append(",\'" + vo.getJobType() + "\'");
		temp.append(",\'" + vo.getF_count() + "\'");
		temp.append(",\'" + vo.getT_count() + "\'");
		temp.append(",\'" + vo.getTime_Start() + "\'");
		temp.append(",\'" + vo.getTime_End() + "\'");
		temp.append(",\'" + vo.getStatus() + "\'");
		temp.append(",\'" + vo.getStatusNode().replace("'", "''") + "\')");

		str = str + temp.toString().replace("null", "0");
		try {
			flag = this.db_con.createStatement().execute(str);

		} catch (SQLException e) {
			System.out.println("ExtractLogDao:更新日志出错");
			e.printStackTrace();
		}finally{
			try {
				db_con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}
}
