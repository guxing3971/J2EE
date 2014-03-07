package JavaSE.对象克隆;

public class clone_1 {

	public static void main(String[] args) throws CloneNotSupportedException {

		Person per1 = new Person("禅师",0);
		Person per2 = (Person) per1.clone();
		
		per2.setName("尼姑");
		
		System.out.println(per1);
		System.out.println(per2);
	}

}

class Person implements Cloneable {
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
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
