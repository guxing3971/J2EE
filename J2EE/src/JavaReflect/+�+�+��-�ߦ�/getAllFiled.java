package JavaReflect.获取类的结构;

import java.lang.reflect.Field;

public class getAllFiled {

	public static void main(String[] args) {
		Class<?> c1 = null;
		
		try {
			c1 = Class.forName("获取类的结构.getAllFiledDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Field f[] = null;
		
		//取得本来声明的属性
		f = c1.getDeclaredFields();
		
		for(int i=0;i<f.length;i++){
			System.out.println(f[i].getName());
		}
	}

}

class getAllFiledDemo{
	
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
