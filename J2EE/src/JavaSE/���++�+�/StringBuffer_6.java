package JavaSE.常用类库;
/**
 * 
 * @author 禅师
 * @resume
 * 		删除指定范围内的字符串
 */
public class StringBuffer_6 {

	public static void main(String[] args) {

		StringBuffer str = new StringBuffer();
		str.append("hello ").append("world");
		System.out.println(str);
		
		//删除wo
		str.delete(6, 8);
		System.out.println(str);
	}

}
