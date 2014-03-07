package JavaIO.Serilizable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 
 * @author 禅师
 * @resume 对象反序列号
 */
public class unSeriliz {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		File file = new File("c:\\seri.txt");
		
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file));
		Person per = null;
		per = (Person)ois.readObject();
		System.out.println(per);
		ois.close();
	}

}
