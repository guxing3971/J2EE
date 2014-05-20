package dnzl.Core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dnzl.Core.db.SysdbConn;

public class TaskCore_ProductDataAtHISDB implements Job{
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("开始计算数据:"+sdf.format(new Date()));
		Connection F_conn = SysdbConn.initByJNDI("CC5000");
		CallableStatement cstmt = null;
		try {
			cstmt = F_conn.prepareCall("call HISDB.GET_OMS_HOUR;");
			cstmt.execute();
			Thread.sleep(30000);
			System.out.println("计算数据结束:"+sdf.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				cstmt.close();
				F_conn.commit();
				F_conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
