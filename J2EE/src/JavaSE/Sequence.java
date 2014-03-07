package JavaSE;
import java.io.*;

public class Sequence{
	public static void main(String[] args)throws Exception{
		InputStream s1 = null;
		InputStream s2 = null;
		OutputStream os = null;
		SequenceInputStream sis = null;
		s1 = new FileInputStream("d:"+File.separator+"a.txt");
		s2 = new FileInputStream("d:"+File.separator+"b.txt");
		os = new FileOutputStream("d:"+File.separator+"ab.txt");
		sis = new SequenceInputStream(s1,s2);
		int temp =0;
		while((temp = sis.read())  != -1){
			os.write(temp);
		}
		sis.close();
		s1.close();
		s2.close();
		os.close();

	}
}