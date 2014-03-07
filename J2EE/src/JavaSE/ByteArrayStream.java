package JavaSE;
import java.io.*;
public class ByteArrayStream{
	public static void main(String[] args)throws Exception{
		String str="HELLOWORLD";
		ByteArrayInputStream bis = null;
		ByteArrayOutputStream bos = null;

		bis = new ByteArrayInputStream(str.getBytes());
		bos = new ByteArrayOutputStream();

		int temp = 0;
		while((temp = bis.read()) != -1){
			char c = (char)temp;		
			bos.write(Character.toLowerCase(c));
		}
		String newStr = bos.toString();

		bis.close();
		bos.close();
		System.out.println(newStr);
	}
}