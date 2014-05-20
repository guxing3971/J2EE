package hibernate3.CoreTest;

import hibernate3.POJO.extend.union.CBook;
import hibernate3.POJO.extend.union.JavaBook;
import hibernate3.POJO.extend.union.book;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class unionTest {

	private Configuration configuration ;

	private SessionFactory sessionFactory;

	private Session  session;
	
	private Transaction tx;
	
	@Before
	public void before(){
		configuration  = new Configuration().configure();
		
		sessionFactory = configuration.buildSessionFactory();
		
		session = sessionFactory.openSession();
		
		tx = session.beginTransaction();
		
	}
	
	@After
	public void after(){
		tx.commit();
		
		session.close();
		
		sessionFactory.close();
	}
	
	
	@Test
	public void unionTestSave(){
		book  book1 = new book();
		book1.setBookName("易经");

		CBook book2 = new CBook();
		book2.setAuthor("AA");
		book2.setBookName("C语言编码规范");
		book2.setAbstracts("讲述C语言的编码规范");
		book2.setProductTime(new Date());
		
		JavaBook jbook = new JavaBook();
		jbook.setAuthor("李兴华");
		jbook.setBookName("java实战开发经典");
		
		session.save(book1);
		session.save(book2);
		session.save(jbook);
	}
}
