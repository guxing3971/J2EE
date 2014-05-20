package hibernate3.CoreTest;

import java.util.Iterator;

import hibernate3.POJO.many2many.RuleInfo;
import hibernate3.POJO.many2many.UserInfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * 测试：单向多对对
 */
public class many2manyTest {
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
	 * 单向多对多保存
	 */
	@Test
	public void testMany2manySave(){
		RuleInfo urle = new RuleInfo();
		urle.setRuleName("root");
		
		RuleInfo urle1 = new RuleInfo();
		urle1.setRuleName("dba");
		
		UserInfo user1 = new UserInfo();
		user1.getRuleSet().add(urle1);
		user1.getRuleSet().add(urle);
		
		session.save(user1);
	}
	
	/**
	 * 单向多对多加载
	 */
	@Test
	public void testMany2manyLoad(){
		UserInfo user1 = (UserInfo) session.load(UserInfo.class,1);
		System.out.println(user1.getUserName());
		Iterator<RuleInfo> ruleSet = user1.getRuleSet().iterator();
		while(ruleSet.hasNext()){
			System.out.println(ruleSet.next());
		}
	}
}
