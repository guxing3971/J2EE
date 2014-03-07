package SpringSE.test;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SpringSE.db.connection_db;


public class SpringTest {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		
		connection_db db = (connection_db) ctx.getBean("connection_db");
		try {
			db.query();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
