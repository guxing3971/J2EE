package JavaReflect.应用;

import java.lang.reflect.Method;

/**
 * 
 * @author 禅师
 * @resume 利用反射调用对象的方法
 */
public class invokeMethod1 {

	public static void main(String[] args) throws InstantiationException, ReflectiveOperationException {
		
		//实例化Class
		Class<?> c1 = null;
		try {
			c1 = Class.forName("应用.invokeMethod1Demo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Method fun[] = new Method[3];
		try {
			fun[0]= c1.getMethod("setName",String.class);
			fun[1]= c1.getMethod("setEmail",String.class);
			fun[2]= c1.getMethod("setAge",int.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		//调用时必须传递实例对象
		//因为调用的方法返回值是void所以不需要结束，如果调用的方法有返回值还需要接收
		invokeMethod1Demo temp = (invokeMethod1Demo)c1.newInstance();
		fun[0].invoke(temp,"禅师");
		fun[1].invoke(temp, "snakeam@163.com");
		fun[2].invoke(temp, 20);
		
		
		//调用toString
		System.out.println(temp);

	}

}

class invokeMethod1Demo{
	private String name;
	private String email;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "invokeMethod1Demo [name=" + name + ", email=" + email
				+ ", age=" + age + "]";
	}
	
	
}
