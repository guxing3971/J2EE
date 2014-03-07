package JavaSE;
import java.io.*;
public class unser{
	public static void main(String[] args)throws Exception{
		File f = new File("d:"+File.separator+"text.txt");
		ObjectInputStream ois = null;
		InputStream input = new FileInputStream(f);
		ois = new ObjectInputStream(input);
		Object obj = ois.readObject();
		ois.close();
		System.out.println(obj);
	}
}