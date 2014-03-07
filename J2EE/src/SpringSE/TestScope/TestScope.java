package SpringSE.TestScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
	
	public String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public static void main(String[] args){
		ApplicationContext cxt = new ClassPathXmlApplicationContext("bean.xml");
		
		for(int i=0;i<5;i++){
			TestScope test = (TestScope) cxt.getBean("testScope");
			
			System.out.println(test);	
		}

		
	}
}
