package JavaSE;
import java.io.InputStream;
public class input{
	public static void main(String[] args) throws Exception{
		InputStream in = System.in;
		byte[]  b = new byte[1024];
		System.out.print("please input:");
		int len = in.read(b);
		System.out.println("content:"+ new String(b,0,len));

		in.close();
	}
}