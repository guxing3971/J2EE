package JavaSE.正则表达式;
/**
 * 
 * @author 禅师
 * @resume 字符串类String对正则表达式的支持
 */
public class String1 {

	public static void main(String[] args) {

		String str = "AA22BB33CC44DD55EE";
		System.out.println("原字符串:"+str);
		System.out.println("新字符串:"+str.replaceAll("\\d+", "__"));
	}

}
