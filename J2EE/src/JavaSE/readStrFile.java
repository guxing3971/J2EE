package JavaSE;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;

public class readStrFile{
	public static void main(String[] args)throws Exception{
		File f = new File("d:"+File.separator+"test.txt");
		InputStream input = null;
		input = new FileInputStream(f);

		int len = 0;
		byte b[] = new byte[1024];
		int temp = 0;
		while((temp = input.read())  != -1 ){
			b[len] = (byte)temp;
			len++;
		}
		input.close();
		System.out.println("content:"+new String(b,0,len));
	}
}