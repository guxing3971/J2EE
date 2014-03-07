package JavaSE;
import java.io.*;
import java.util.zip.*;
public class zipdemo1{
	public static void main(String[] args)throws Exception{
		File file = new File("d:"+File.separator+"text.zip");
		ZipFile zipFile = new ZipFile(file);
		System.out.println("zipfile-name:"+zipFile.getName());
	}
}