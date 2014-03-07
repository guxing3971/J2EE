package JavaReflect.获取类的结构;

import java.io.Serializable;

/**
 * 
 * @author 禅师
 * @resume 获取类的全部接口
 */
public class getInterface {

	public static void main(String[] args) {
		Class<?> c1 = null;
		
		try {
			c1 = Class.forName("获取类的结构.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Class<?> Inter[] = c1.getInterfaces();
		System.out.println("获取类的结构.Person实现的接口有：");
		for(int i= 0; i < Inter.length;i++){
			System.out.print(Inter[i].getName() + "\t");
		}
	}

}

class Person implements Serializable,Comparable<Person>,Cloneable{

	private static final long serialVersionUID = 1L;

	@Override
	public int compareTo(Person arg0) {
		// TODO Auto-generated method stub
		return 0;
	}}
