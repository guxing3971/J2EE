package dnzl.DataFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import dnzl.Core.db.SysdbConn;
/////////////////////////////////////////////////////////////////////
//Summary:
//		定义所有所有Vo类的父类,改父类实现了VO类对应的数据库数据查询和保存
/////////////////////////////////////////////////////////////////////
public  class SupperVo {
	//public  static Connection db_con= SysdbConn.initByJNDI("DNZL");;
	
	public  static Connection db_con= SysdbConn.staticdb();
	
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");

	public static Calendar dar = Calendar.getInstance();
	
	
	static {
		sdf1.setTimeZone(timezone);
		dar.setTimeZone(timezone);
	}
	
	
	public String sDate;
	public String sDay;
	public String sHour;

	public SupperVo() {
		sDate = sdf1.format(new Date());
		sDay = sDate.substring(0, 10);
		sHour = sDate.substring(11,13);
		sDate = sDate.substring(0,13)+":00:00";
	}
	
	public String save_sql = "";
	
	public String select_sql = "";
	
	
	public static ResultSet select(String select_sql) throws SQLException{
		ResultSet res = null;
		Statement stmt = db_con.createStatement();
		res = stmt.executeQuery(select_sql);
		return res;
	}
	
	public static void update_status(String update_sql){
		try {
			Statement stmt =db_con.createStatement();
			stmt.execute(update_sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//子类通过覆写改方法入库的SQL语句
	public  String SaveStr(){
		return null;
	}
}
