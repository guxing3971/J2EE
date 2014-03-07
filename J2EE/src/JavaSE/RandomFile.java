package JavaSE;
import java.io.File;
import java.io.RandomAccessFile;

public class RandomFile{
	public static void main(String[] args) throws Exception{

		File f = new File("d:"+File.separator+"test.txt");
		RandomAccessFile rdf = null;
		rdf = new RandomAccessFile(f,"rw");

		String name=null;
		int age = 0;
		name ="zhangsan";
		age =30;
		rdf.writeBytes(name);
		rdf.writeInt(age);
		name="lisi    ";
		age =31;
		rdf.writeBytes(name);
		rdf.writeInt(age);	
		name="wangwu  ";
		age =32;
		rdf.writeBytes(name);
		rdf.writeInt(age);


		rdf.close();


		RandomAccessFile red = null;
		red = new RandomAccessFile(f,"rw");
		byte b[] = new byte[8];
		red.skipBytes(12);
		for(int i = 0;i<b.length;i++){
			b[i] = red.readByte();
		}
		System.out.println(new String(b));
		System.out.println(red.readInt());

	}
}