package JavaIO.System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 键盘输入的标准格式 {

	public static void main(String[] args) throws IOException {

		//例如System.in实例话一个BufferedReader对象
		BufferedReader buf = null;
		buf = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;
		
		System.out.println("请输入数据：");
		
		try{
			str = buf.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		System.out.println("输入的内容为："+str);
		buf.close();
	}

}
