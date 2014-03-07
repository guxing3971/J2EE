package JavaIO.External;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 
 * @author 禅师
 * @resume 有选择的进行对象序列化
 */
public class Seril {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		File file = new File("c:\\Seri.txt");
		ObjectOutputStream oos = null;
		oos = new ObjectOutputStream(new FileOutputStream(file));
		
		Person per = null;
		per = new Person("禅师",20);
		oos.writeObject(per);
		
		oos.close();
	}

}
