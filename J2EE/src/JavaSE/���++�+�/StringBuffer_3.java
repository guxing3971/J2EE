package JavaSE.常用类库;

/**
 * 
 * @author 禅师
 * @resume:
 * 		字符串反转  即将hello该为olleh
 * 		
 */
public class StringBuffer_3 {


	public static void main(String[] args) {

		StringBuffer str = new StringBuffer();
		str.append("hello");
		
		//字符串反转
		str.reverse();
		System.out.println(str);
	}

}
