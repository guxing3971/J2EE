package JavaReflect.获取类的结构;

import java.lang.reflect.Method;

public class getAllMethods {

	public static void main(String[] args) {
		Class<?> c1 = null;
		
		try {
			c1 = Class.forName("获取类的结构.getAllMethodsDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method met[] = null;
		met =c1.getMethods();
		
		//直接输出
		for(int i = 0;i< met.length;i++){
			System.out.println(met[i]);
		}
		
	}

}

class  getAllMethodsDemo{
	private String name;
	private String email;
	private String qq;
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
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
