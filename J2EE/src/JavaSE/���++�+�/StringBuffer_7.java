package JavaSE.常用类库;
/**
 * 
 * @author 禅师
 * @resume
 * 		查找指定的字符串是否存在
 */
public class StringBuffer_7 {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer();
		str.append("hello ").append("world");
		
		System.out.println(str);
		if(str.indexOf("ll") == -1){
			System.out.println("字符串str中没有ll子字符串");
		}else{
			System.out.println("字符串str中有ll子字符串.从 "+ (str.indexOf("ll")+1) +"开始");
		}
	}

}
