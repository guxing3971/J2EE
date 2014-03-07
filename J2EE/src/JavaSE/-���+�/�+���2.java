package JavaSE.数组类;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author 禅师
 * @resume 通过Comparator接口对已经实现的类 定制排序规则
 */
public class 比较器2 {

	public static void main(String[] args) {
		coder st[] = new coder[5];
		st[0] = new coder("禅师",0);
		st[1] = new coder("禅师",4);
		st[2] = new coder("禅师",3);
		st[3] = new coder("禅师",2);
		st[4] = new coder("禅师",1);

		System.out.println(Arrays.toString(st));
		
		//指定排序规则
		Arrays.sort(st,new codersort());  
		System.out.println(Arrays.toString(st));	

	}

}

class coder implements Cloneable {
	private String name;
	private int age;

	public coder() {

	}

	public coder(String name, int age) {
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
		return "coder [name=" + name + ", age=" + age + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

}

class codersort implements Comparator<coder>{

	@Override
	public int compare(coder arg0, coder arg1) {
		if(arg0 != arg1){
			if(arg0.getAge() > arg1.getAge()){
				return 1;
			}else{
				return -1;
			}
		}else{
			return 0;
		}
	}
	
}