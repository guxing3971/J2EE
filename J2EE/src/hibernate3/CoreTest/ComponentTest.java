package hibernate3.CoreTest;

import hibernate3.POJO.Coder;
import hibernate3.POJO.Skill;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ComponentTest {
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
	
	/**
	 * 测试hibernate组成关系映射
	 */
	@Test
	public void testComponentSave(){

		
		Skill skill = new Skill();
		
		skill.setOs("linux");
		skill.setLanguage("Java/Python/web");
		skill.setAdept("AV");
		
		Coder coder = new Coder();
		coder.setName("N");
		coder.setSex("男");
		coder.setSkill(skill);
		
		Coder coder1 = new Coder();
		coder1.setName("N");
		coder1.setSex("男");
		coder1.setSkill(skill);
		
		//注意此处不能将skill对象进行持久化，因为它是值类型的
		session.save(coder);
		session.save(coder1);
	}
	@Test
	public void testComponentLoad(){
		Coder coder = (Coder) session.load(Coder.class, (long)5);
		System.out.println(coder);
		System.out.println(coder.getSkill());
	}
	
}
