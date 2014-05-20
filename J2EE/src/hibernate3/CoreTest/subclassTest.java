package hibernate3.CoreTest;

import hibernate3.POJO.extend.subclass.Employee;
import hibernate3.POJO.extend.subclass.Loader;
import hibernate3.POJO.extend.subclass.Managaer;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class subclassTest {

	private Configuration configuration;
	
	private SessionFactory sessionFactory;
	
	private Session session;
	
	private Transaction tx;
	
	@Before
	public void before(){
		configuration = new Configuration().configure();
		
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
	public void subclassTestSave() {
		Employee emp = new Employee();
		emp.setUserName("小和尚");
		
		Managaer man = new Managaer();
		man.setUserName("主持");
		man.setManagerDept("寺院");
		
		Loader load = new Loader();
		load.setUserName("方丈");
		load.setLoadDept("少林寺");
		
		session.save(emp);
		session.save(man);
		session.save(load);
	}
	
	@SuppressWarnings("unchecked")
	@Test 
	public void subclassTestLoad(){
		List<Employee> userlist =  session.createQuery("from Employee").list();
		Iterator<Employee> iter = userlist.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().toString());
		}
	}

}
