package JavaIO.System;

import java.io.IOException;
import java.io.InputStream;

public class 键盘输入1 {

	public static void main(String[] args) throws IOException {

		//因为System.in即代表键盘输入流对象
		InputStream input = System.in;
		
		
		
		byte temp[] = new byte[1024];
		int len = 0;
		
		System.out.println("请输入:");
		
		//按如下方式读去键盘输入时，当数据太长时无法全部读取，当temp数组为奇数时会出现乱码
		len = input.read(temp);
		System.out.println(new String(temp,0,len));
		input.close();
		
	}

}
