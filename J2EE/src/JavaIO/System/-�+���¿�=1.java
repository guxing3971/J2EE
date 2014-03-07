package JavaIO.System;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class 输入重定向1 {

	public static void main(String[] args) throws IOException {

		String path = "c:\\test.txt";
		File f = new File(path);
		
		System.setIn(new FileInputStream(f));
		
		InputStream input = System.in;
		byte temp[] = new byte[1024];
		int len = input.read(temp);
		System.out.println(new String(temp,0,len));
		input.close();
	}

}
