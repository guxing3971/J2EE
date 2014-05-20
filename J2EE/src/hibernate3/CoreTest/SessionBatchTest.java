package hibernate3.CoreTest;

import hibernate3.POJO.Customer;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @测试Session的批量操作 
 * 批量处理数据是指在一个事务中处理大量数据，在应用层就像批量操作，主要有以下集中方式
	通过Session
	通过HQL
	通过StatelessSession
	通过JDBC API

	如果通过一个Session对象来处理大量持久化对象，应该及时从缓存中清空已经处理完毕并且不会在访问的对象
	具体的做法是在处理完一个对象的或一小批对象后，立即用条用flush()方法清理缓存，然后在调用clear()方法清空缓存。
 */
public class SessionBatchTest {
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
	public void SessionBatch_Insert(){
		long startTime = System.currentTimeMillis();
		Customer cust = null;
		for(int i=1;i<100000;i++){
			cust = new Customer();
			cust.setCustomerName("cust"+i);
			session.save(cust);
			if(i % 100 == 0){
				session.flush();
				session.clear();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime -startTime);
	}
	
	@Test
	public void SessionBatch_Update(){
		long startTime = System.currentTimeMillis();
		ScrollableResults sr= session.createQuery("FROM Customer").scroll();
		Customer cust = null;
		Integer i = 0;
		while(sr.next()){
			cust = (Customer) sr.get(0);
			cust.setCustomerName(cust.getCustomerName()+"***");
			if(i % 100 == 0){
				session.flush();
				session.clear();
			}
			i++;
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
	}
}
