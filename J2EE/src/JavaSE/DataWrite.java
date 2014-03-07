package JavaSE;

import java.io.*;
public class DataWrite{
	public static void main(String[] args)throws Exception{
		DataOutputStream dos = null;
		File f = new File("d:"+File.separator+"test.txt");

		dos = new DataOutputStream(new FileOutputStream(f));
		String names[] ={"yf","st","wj"};
		float prices[] = {98.3f,30.3f,50.5f};
		int nums[] ={3,2,1};

		for(int i = 0;i<names.length;i++){
			dos.writeChars(names[i]);
			dos.writeChar('\t');
			dos.writeFloat(prices[i]);
			dos.writeChar('\t');
			dos.writeInt(nums[i]);
			dos.writeChar('\t');
		}
		dos.close();
	}
}