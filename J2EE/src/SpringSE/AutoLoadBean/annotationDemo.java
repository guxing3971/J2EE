package SpringSE.AutoLoadBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class annotationDemo {

	public	Person	per;

	public Person getPer() {
		return per;
	}

	@Autowired
	public void setPer(Person per) {
		this.per = per;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("AutoLoadBean.xml");
		annotationDemo test = (annotationDemo) ctx.getBean("autoDemo");
		test.per.say();
	}

}
