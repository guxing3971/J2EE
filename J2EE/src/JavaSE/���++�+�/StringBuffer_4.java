package JavaSE.常用类库;

/**
 * 
 * @author 禅师
 * @resume:
 * 		字符串替换
 */
public class StringBuffer_4 {

	public static void main(String[] args) {

		StringBuffer str = new StringBuffer();
		str.append("hello ");
		str.append("world");
		
		System.out.println(str);
		//字符串替换
		str.replace(6, 11, "everyone");
		
		System.out.println(str);
	}

}
