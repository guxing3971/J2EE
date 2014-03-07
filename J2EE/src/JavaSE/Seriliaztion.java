package JavaSE;
import java.io.*;
class Persons implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;

	public Persons(String name,int age){
		this.name = name;
		this.age = age;
	}
	public String toString(){
		return "name:"+this.name+"age:"+this.age;
	}
}

public class Seriliaztion{
	public static void main(String[] args)throws Exception{
		File f = new File("d:"+File.separator+"text.txt");
		ObjectOutputStream oos = null;
		OutputStream out = new FileOutputStream(f);
		oos = new ObjectOutputStream(out);
		oos.writeObject(new Persons("test",30));
		oos.close();
	}
}