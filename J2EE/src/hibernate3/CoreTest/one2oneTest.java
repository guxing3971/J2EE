package hibernate3.CoreTest;



import hibernate3.POJO.one2one.Card;
import hibernate3.POJO.one2one.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class one2oneTest {
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
	 *测试保存(主键关联)
	 */
	@Test
	public void testOne2oneSave(){
		Person person = new Person();
		person.setPersonName("和尚");
		
		Card card = new Card();
		card.setCradName("少林寺");
		
		person.setCard(card);
		card.setPerson(person);
		
		session.save(person);
		
	}
	
	/**
	 * 测试加载(主键关联)
	 */
	@Test
	public void testOne2oneLoad(){
		Person person = (Person) session.get(Person.class, 1);
		System.out.println(person.getPersonName());
		System.out.println(person.getCard().getPerson().getPersonName());
	}
	
	
	
}
