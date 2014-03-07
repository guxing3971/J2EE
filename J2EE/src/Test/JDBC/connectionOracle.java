package Test.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionOracle {

	private static final String Drivers ="oracle.jdbc.driver.OracleDriver";
	private static final String DBURL ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String DBUSER ="scott";
	private static final String DBPASS ="tiger";
	public static void main(String[] args) {
		
		//用于表示一个连接
		Connection  con = null;
		
		//加载驱动
		try {
			Class.forName(Drivers);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动异常："+ Drivers);
			e.printStackTrace();
		}
		
		
		//获得数据连接
		try {
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败");
			e.printStackTrace();
		}
		
		System.out.println(con);
		//让线程休眠便于查看是否真的连接到数据库上
		
		//在Oracle中可以在sqlplus中一sys用户登录执行
			/**
			 * select username,count(username) from v$session 
			 * 		where username is not null group by username
			 */
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		//关闭数据库连接
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
