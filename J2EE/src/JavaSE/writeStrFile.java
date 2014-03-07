package JavaSE;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class writeStrFile{
	public static void main(String[] agrs) throws Exception {
		File f = new File("d:"+File.separator+"test.txt");
		OutputStream out = null;
		out = new FileOutputStream(f);

		String str = "测试";
		byte b[] = str.getBytes();
		out.write(b);
		out.close();
	}
}