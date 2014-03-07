package JavaSE;
import java.io.*;
public class inputKEY{
	public static void main(String[] args){
		BufferedReader buf = null;
		buf = new BufferedReader(new InputStreamReader(System.in));

		String str = null;
		System.out.print("content:");
		try{
			str = buf.readLine();
		}catch(Exception e ){
			e.printStackTrace();
		}
		System.out.print(str);
	}
}