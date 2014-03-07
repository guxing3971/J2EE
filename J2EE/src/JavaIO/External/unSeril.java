package JavaIO.External;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class unSeril {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("c:\\seri.txt");
		ObjectInputStream ois = null;
		ois = new ObjectInputStream(new FileInputStream(file));
		
		Person per = null;
		per = (Person) ois.readObject();
		System.out.println(per);
		ois.close();
		
	}

}
