package JavaReflect.实例化对象;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 
 * @author 禅师
 * @resume 通过有参构造实例化对象
 * 		· 通过Class类的getConstructors方法取得全部的构造方法
 *		· 想构造方法传递参数，以数组的形式
 *		· 通过构造方法实例创建对象实例
 */

public class Construct {


	public static void main(String[] args) {
		Class<?> c = null;
		
		try {
			c = Class.forName("实例化对象.ConstructDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ConstructDemo temp = null;
		Constructor<?> con[] = null;
		
		con = c.getConstructors();
		
		//因为只有一个构造方法所以直接使用con[0]
		try {
			temp = (ConstructDemo) con[0].newInstance("禅师",20);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println(temp);
	}

}

class ConstructDemo{
	private String name;
	private int age;
	
	public ConstructDemo(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ConstructDemo [name=" + name + ", age=" + age + "]";
	}
	
	
}
