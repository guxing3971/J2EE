package JavaSE;
import java.io.*;
import java.util.zip.*;

public class zipdemo2{
	public static void main(String[] args)throws Exception{
		File file = new File("d:"+File.separator+"text.zip");
		File newfile = new File("d:"+File.separator+"text_unzip.txt");

		ZipFile zipFile = new ZipFile(file);
		ZipEntry entry = zipFile.getEntry("text.txt");
		InputStream input = zipFile.getInputStream(entry);
		OutputStream out = new FileOutputStream(newfile);

		int temp= 0;
		while((temp = input.read()) != -1){
			out.write(temp);
		}
		input.close();
		out.close();
	}
}