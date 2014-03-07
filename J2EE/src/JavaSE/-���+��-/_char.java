/**
 * 在java中char类型占俩个字节,所以既能存储英文也能存储汉字.
 * java使用unicode来存储.
 */

package JavaSE.数据类型;

public class _char {
	public static void main(String[] args){
		
		char a ='b';
		System.out.println(a);
		System.out.println("char:" + Character.SIZE);
		
		char b = '中';
		System.out.println(b);
		System.out.println("char:" + Character.SIZE);
	}
}
