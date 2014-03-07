package JavaSE;
import java.io.*;
public class Person implements Externalizable{
	private static final String String = null;
	private Object name;
	private int age;
	public Person(){

	}
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	public String toString(){
		return " name :"+this.name +"\t age:"+this.age;

	}

	public void readExternal(ObjectInput in) throws ClassNotFoundException, IOException{
		this.name = in.readObject();
		this.age = in.readInt();
	}
	public void writeExternal(ObjectOutput out) throws IOException{
		out.writeObject(this.name);
		out.writeInt(this.age);
	}
}