package JavaIO.System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 键盘输入3 {

	public static void main(String[] args) throws IOException {
		BufferedReader buf = null;
		
		buf = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;
		int i = 0;
		str = buf.readLine();
		
		if(str.matches("^\\d+$")){
			i = Integer.parseInt(str);
			System.out.println(i);
		}else{
			System.out.println("输入的数据不合法");
		}
		
		buf.close();
	}

}
