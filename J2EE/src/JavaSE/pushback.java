package JavaSE;
import java.io.*;
public class pushback{
	public static void main(String[] args)throws Exception{
		String str = "www.baidu.com";
		PushbackInputStream push = null;
		ByteArrayInputStream bai = null;
		bai = new ByteArrayInputStream(str.getBytes());
		push = new PushbackInputStream(bai);


		int temp = 0;						
		while((temp = push.read()) != -1){	//璇诲彇鏁版嵁
			if(temp == '.'){				
				push.unread(temp);			//锲为€€鍒扮紦鍐插尯鍓嶉溃
				temp = push.read();			//绌哄嚭姝ゆ暟鎹?

			}else{
				System.out.print((char)temp);
			}
		}
	}
}