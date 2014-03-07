package JavaReflect.应用;

import java.lang.reflect.Field;

/**
 * 
 * @author 禅师
 * @resume 直接通过Field类操纵对象的Field类似setter和getter
 */
public class ControlField {
	public static void main(String[] args) {
		
		//实例化Class
		Class<?> c = null;
		try {
			c = Class.forName("应用.ControlFieldDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ControlFieldDemo temp = null;  
		Field name = null;
		Field email = null;
		Field age = null;
		
		try {
			temp = (ControlFieldDemo)c.newInstance();
			name = c.getDeclaredField("name");
			email = c.getDeclaredField("email");
			age = c.getDeclaredField("age");
		} catch (InstantiationException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		
		//设置field可访问
		name.setAccessible(true);
		email.setAccessible(true);
		age.setAccessible(true);
		try {
			name.set(temp,"禅师");
			email.set(temp, "snakeam@163.com");
			age.setInt(temp, 20);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		System.out.println(temp);
	}

}

class ControlFieldDemo{
	private String name;
	private String email;
	private int age;
	
	
	public ControlFieldDemo() {
	}
	public ControlFieldDemo(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}
	@Override
	public String toString() {
		return "ControlFieldDemo [name=" + name + ", email=" + email + ", age="
				+ age + "]";
	}

}