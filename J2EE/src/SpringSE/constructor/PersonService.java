package SpringSE.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonService {
	private String name ="这是默认的名字";
	
	private String say ="当构造方法多个参数时可以通过type和Index指定参数的对应关系";
	
	private int age = 20;
	

	public void setName(String name) {
		this.name = name;
	}

	public void info() {
		System.out.println("此人名为：" + name +"\t"+age+"\t"+say);
	}

	public PersonService(String name) {
		this.name = name;
	}

	
	public PersonService(String name, String say, int age) {
		super();
		this.name = name;
		this.say = say;
		this.age = age;
	}

	public PersonService() {
		
		
	}
	
	public static void main(String[] args){
		ApplicationContext cxt = new ClassPathXmlApplicationContext("consturctor.xml");
		PersonService test =(PersonService) cxt.getBean("person1");
		PersonService test1 =(PersonService) cxt.getBean("person2");
		PersonService test2 =(PersonService) cxt.getBean("person3");
		
		test.info();
		test1.info();
		test2.info();
	
	}

}
