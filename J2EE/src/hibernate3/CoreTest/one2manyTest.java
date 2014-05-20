package hibernate3.CoreTest;


import java.util.Iterator;

import hibernate3.POJO.one2many.Customer;
import hibernate3.POJO.one2many.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class one2manyTest {

	private  Configuration configuration;
	
	private  SessionFactory sessionFactory;
	
	private  Session session;
	
	private  Transaction tx;
	
	@Before
	public  void before(){
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
	
	/**
	 *测试保存
	 */
	@Test
	public void testOne2manySave(){
		Customer customer1 = new Customer();
		customer1.setCustomerName("和尚");
		
		Order order1 = new Order();
		order1.setOrderId(String.valueOf(System.currentTimeMillis()));
		order1.setOrderName("袈裟");
		order1.setCustomer(customer1);
		
		Order order2 = new Order();
		order2.setOrderId(String.valueOf(System.currentTimeMillis()));
		order2.setOrderName("法杖");
		order2.setCustomer(customer1);	

		Order order3 = new Order();
		order3.setOrderId(String.valueOf(System.currentTimeMillis()));
		order3.setOrderName("佛珠");
		order3.setCustomer(customer1);	
		
		customer1.getOrderSet().add(order1);
		customer1.getOrderSet().add(order2);
		customer1.getOrderSet().add(order3);
		
		//对象持久化
		session.save(customer1);
		session.save(order1);
		session.save(order2);
		session.save(order3);
	}
	
	
	@Test
	public void testOne2manyLoad(){
		Customer customer1 = (Customer) session.load(Customer.class, 1);
		System.out.println(customer1);
		System.out.println(customer1.getOrderSet().size());
		Iterator<Order> iter = customer1.getOrderSet().iterator();
		while(iter.hasNext()){
			Order order = iter.next();
			System.out.println(order);
		}
	}
}
