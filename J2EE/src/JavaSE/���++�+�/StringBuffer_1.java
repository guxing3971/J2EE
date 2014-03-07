package JavaSE.常用类库;

/**
 * @author 禅师
 * resume
 * 		StringBuffer类提供的常用方法演示 -> 字符串的追加
 */
public class StringBuffer_1 {

	public static void main(String[] args) {
		
		StringBuffer str = new StringBuffer();
		
		//使用append方法追加字符串
		str.append("hello");
		str.append(" java");
		str.append("!!!").append("从今天起开始认真学习java编程");
		
		System.out.println(str);

	}

}
