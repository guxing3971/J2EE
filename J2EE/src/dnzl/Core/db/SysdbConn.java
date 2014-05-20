package dnzl.Core.db;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

public class SysdbConn {

	public static Connection initByJNDI(String JNDI_NAME) {
		Connection conn = null;
		String JNDINAME = "java:comp/env/" + JNDI_NAME;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(JNDINAME);
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("数据源错误: JNDI-Name->" + JNDINAME);
			System.out.println(e);
		}
		return conn;
	}

	public Connection DNZL() {
		String Drivers = "dm.jdbc.driver.DmDriver";
		String DBURL = "jdbc:dm://127.0.0.1:12345/DNZL";
		String DBUSER = "INTERFACE";
		String DBPASS = "INTERFACE";
		Connection con = null;
		try {
			Class.forName(Drivers);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动异常：" + Drivers);
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败");
			e.printStackTrace();
		}
		return con;

	}

	public Connection C5000() {
		Connection con = null;
		String DBURL = "jdbc:dm://192.168.30.150:12345/HISDB";
		String DBUSER = "HISDB";
		String DBPASS = "HISDB";
		String Drivers = "dm.jdbc.driver.DmDriver";
		try {
			Class.forName(Drivers);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动异常：" + Drivers);
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败");
			e.printStackTrace();
		}
		return con;

	}

	public static  Connection staticdb() {
		String Drivers = "dm.jdbc.driver.DmDriver";
		String DBURL = "jdbc:dm://127.0.0.1:12345/DNZL";
		String DBUSER = "INTERFACE";
		String DBPASS = "INTERFACE";
		Connection con = null;
		try {
			Class.forName(Drivers);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动异常：" + Drivers);
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败");
			e.printStackTrace();
		}
		return con;
	}
}
