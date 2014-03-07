package JavaSE.数组类;

import java.util.Arrays;

/**
 * 
 * @author 禅师
 * @resume 为对象实现比较功能,用Arrays对 对象数组 进行排序
 */
public class 比较器 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Person per[] = new Person[10];
		per[0]= new Person("禅师",0);
		
		for(int i = 1;i < 10;i++){
			per[i] = (Person) per[0].clone();
			per[i].setAge(i);	
		}
		
		per[2].setAge(20);
		per[4].setAge(30);
		per[7].setAge(80);
		per[9].setAge(99);
		
		System.out.println(Arrays.toString(per));
		
		//对数组进行排序(即按年龄排序)
		Arrays.sort(per);
		System.out.println(Arrays.toString(per));
		
		
		
		
	}

}

class Person implements Cloneable,Comparable<Person>{

	private String name;
	private int age;
	
	
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


	public Person() {
	}


	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	@Override
	public int compareTo(Person arg0) {
		// 通过年龄排序
		if(arg0 != this){
			if(arg0.getAge() > this.getAge()){
				return -1;
			}else{
				return 1;
			}
			
		}else{
			return 0;
		}

	}
	
}
