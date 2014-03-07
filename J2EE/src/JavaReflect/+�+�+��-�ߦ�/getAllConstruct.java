package JavaReflect.获取类的结构;

import java.lang.reflect.Constructor;

/**
 * 
 * @author 禅师
 * @resume 获取全部的构造方法
 */
public class getAllConstruct {


	public static void main(String[] args) {
		Class<?> c1 = null;
		
		try {
			c1 = Class.forName("获取类的结构.getAllConstructDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Constructor<?> con[] = null;
		
		con = c1.getConstructors();
		
		//直接输出
		for(int i =0; i < con.length;i++){
			System.out.println(con[i]);
		}
	}

}
class getAllConstructDemo{
	private String name;
	private String home;
	private String email;
	private String phone;
	private int age;
	
	public getAllConstructDemo() {

	}

	public getAllConstructDemo(String name) {
		this.name = name;
	}

	public getAllConstructDemo(String name, String home) {
		super();
		this.name = name;
		this.home = home;
	}

	public getAllConstructDemo(String name, String home, String email) {
		super();
		this.name = name;
		this.home = home;
		this.email = email;
	}

	public getAllConstructDemo(String name, String home, String email,
			String phone) {
		super();
		this.name = name;
		this.home = home;
		this.email = email;
		this.phone = phone;
	}

	public getAllConstructDemo(String name, String home, String email,
			String phone, int age) {
		super();
		this.name = name;
		this.home = home;
		this.email = email;
		this.phone = phone;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
