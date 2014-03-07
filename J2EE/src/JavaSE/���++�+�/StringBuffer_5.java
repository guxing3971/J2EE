package JavaSE.常用类库;
/**
 * 
 * @author 禅师
 * @resume
 * 		字符串截取
 */
public class StringBuffer_5 {
	public static void main(String[] args) {
		
		StringBuffer str = new StringBuffer();
		str.append("hello ").append("world");
		System.out.println(str);
		//使用substring来截取字符串
		String temp = str.substring(6,8);
		System.out.println(temp);
		System.out.println(str);
	}

}
