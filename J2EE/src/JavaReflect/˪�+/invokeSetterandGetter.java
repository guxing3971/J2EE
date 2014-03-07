package JavaReflect.应用;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 禅师
 * @resume 调用对象的setter和getter方法
 */
public class invokeSetterandGetter {

	public static void main(String[] args) {

		//实例化化Class
		Class<?> c = null;
		try {
			c = Class.forName("应用.invokeSetterandGetterDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//实例化一个应用.invokeSetterandGetterDemo对象
		
		//利用反射调用无参构造实例化对象
		invokeSetterandGetterDemo temp = null;
		try {
			temp = (invokeSetterandGetterDemo)c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		setter(temp,"name","禅师",String.class);
		setter(temp,"email","snakeam@163.com",String.class);
		setter(temp,"age","20",int.class);
		
		getter(temp,"name");
		getter(temp,"email");
		getter(temp,"age");
		//调用对象setter和getter方法
		
	}

	/**
	 * @name : static setter
	 * @resume: 统一setter方法的调用
	 * @param: 
	 * 			obj ：对象实例
	 * 			field： 对象的属性字段
	 * 			value: 设置的值
	 * 			type : 属性的类型
	 */
	public static void setter(Object obj,String field,String value,Class<?> Type){
		

		
		String funname = "set" + forStr(field);
		Method fun = null;
		try {
			fun  = obj.getClass().getMethod(funname,Type);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		if(Type == (int.class)){
			int Intvalue = Integer.parseInt(value);
			try {
				fun.invoke(obj, Intvalue);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}else{
			try {
				fun.invoke(obj, value);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * @name: static getter
	 * @resume: 统一get方法的调用
	 */
	public static void getter(Object obj,String field){
		Method fun = null;
		
		try {
			fun = obj.getClass().getMethod("get"+forStr(field));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			//直接输出结果
			System.out.println(fun.invoke(obj));
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @name: forStr
	 * @resume : 格式化getter和setter的field字段
	 */
	public static String forStr(String field){
		String temp =null;
		//将首字母大写
		temp = field.substring(0, 1).toUpperCase() + field.substring(1);
		return temp;
	}
}

class invokeSetterandGetterDemo{
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
		return "invokeSetterandGetterDemo [name=" + name + ", email=" + email
				+ ", age=" + age + "]";
	}
	
}