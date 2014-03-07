package JavaIO.System;

import java.io.IOException;
import java.io.InputStream;

public class 键盘输入2 {

	public static void main(String[] args) throws IOException {
		InputStream input = System.in;
		StringBuffer res = new StringBuffer();
		
		System.out.println("请输入数据：");
		int temp = 0;
		while((temp = input.read()) != -1){
			char c = (char)temp;
			//如果是回车标识结束
			if('\n' == c){
				break;
			}else{
				res.append(c);
			}
		}
		System.out.println("输入的内容为："+res);
		input.close();
	}

}
