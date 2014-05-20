package JavaSE.charset;

import java.nio.*;
import java.nio.charset.*;

public class charsetDemo{
	public static void main(String[] args)throws Exception{
		Charset set = Charset.forName("GBK");
		CharsetEncoder encoder = set.newEncoder();
		CharsetDecoder decoder = set.newDecoder();

		CharBuffer buff = CharBuffer.allocate(8);
		buff.put('t');
		buff.put('e');
		buff.put('s');
		buff.put('t');
		buff.flip();

		ByteBuffer bbuff = encoder.encode(buff);

		for(int i = 0;i < bbuff.limit();i++){
			System.out.print(bbuff.get(i)+" ");
		}
		System.out.println("\n"+decoder.decode(bbuff));


	}
}