package dnzl.Core.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("static-access")
public class ExtractDao {

	private static Connection db_con = null;

	public List<Object> AllDataSource() throws SQLException {
		db_con = SysdbConn.initByJNDI("DNZL");
		
		List<Object> dbList = new ArrayList<Object>();
		ResultSet resultSet = null;
		String sql = "SELECT recordid, JobEname, JobCname, JobType, F_Data, F_SQL, T_Data, T_SQL, FTP_Ename, "
				+ "FTP_Cname, Task, cron, status FROM INTERFACE.Extract_Job_Config where status=\'ok\'";
		resultSet = this.db_con.createStatement().executeQuery(sql);

		while (resultSet.next()) {
			ExtractVO Ex = new ExtractVO();
			Ex.setRecordid(resultSet.getString("recordid"));
			Ex.setJobEname(resultSet.getString("JobEname"));
			Ex.setJobCname(resultSet.getString("JobCname"));
			Ex.setJobType(resultSet.getString("JobType"));
			Ex.setF_Data(resultSet.getString("F_Data"));
			Ex.setF_SQL(resultSet.getString("F_SQL"));
			Ex.setT_Data(resultSet.getString("T_Data"));
			Ex.setT_SQL(resultSet.getString("T_SQL"));
			Ex.setFTP_Ename(resultSet.getString("FTP_Ename"));
			Ex.setFTP_Cname(resultSet.getString("FTP_Cname"));
			Ex.setTask(resultSet.getString("Task"));
			Ex.setCron(resultSet.getString("cron"));
			Ex.setStatus(resultSet.getString("status"));
			dbList.add(Ex);
		}
		db_con.close();
		return dbList;
	}

	public boolean Update(String column, String value, String recordid)
			throws SQLException {
		db_con = SysdbConn.initByJNDI("DNZL");
		boolean res = false;
		String sql = "update INTERFACE.Extract_Config set " + column + "="
				+ value + " where recordid=" + recordid;
		res = this.db_con.createStatement().execute(sql);
		db_con.close();
		return res;
	}
}
