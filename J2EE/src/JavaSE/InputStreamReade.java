package JavaSE;
import java.io.*;
public class InputStreamReade{
	public static void main(String[] args)throws Exception{
		File f = new File("d:"+File.separator+"test.txt");
		Reader read = new InputStreamReader(new FileInputStream(f));
		char[] c= new char[1024];
		int len = read.read(c);
		read.close();
		System.out.println(new String(c,0,len));
	}
}