package JavaSE;

import java.io.*;
public class DataRead{
	public static void main(String[] args)throws Exception{
		DataInputStream dis = null;
		File f = new File("d:"+File.separator+"test.txt");

		dis = new DataInputStream(new FileInputStream(f));
		
		String name = null;
		float price = 0.0f;
		int num = 0;
		char temp[] = null;
		char c=0;
		int len = 0;
		try{
			while(true){
				temp = new char[200];
				len = 0;
				while( (c = dis.readChar() ) != '\t'){
					temp[len] = c;
					len++;
				}
				name = new String(temp,0,len);
				price = dis.readFloat();
				dis.readChar();
				num = dis.readInt();
				dis.readChar();
				System.out.printf("name:%s \tprice:%5.2f\tnums:%d\n",name,price,num);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		dis.close();
	}
}