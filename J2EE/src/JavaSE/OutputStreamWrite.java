package JavaSE;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWrite{
	public static void main(String[] args)throws Exception{
		File f = new File("D:"+File.separator+"test.txt");
		Writer out = null;
		out = new OutputStreamWriter(new FileOutputStream(f));
		out.write("hello world");
		out.write("禅师");
		out.close();
	}
}