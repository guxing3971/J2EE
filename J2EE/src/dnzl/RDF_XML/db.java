package dnzl.RDF_XML;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dnzl.Core.db.SysdbConn;

public class db {
	
	public static Connection db_con= null;
	
	public static SysdbConn  db= new SysdbConn();
	
	public ResultSet select(String select_sql) throws SQLException{
		db_con=SysdbConn.initByJNDI("DNZL");
		ResultSet res = null;
		Statement stmt = db_con.createStatement();
		res = stmt.executeQuery(select_sql);
		return res;
	}
}
