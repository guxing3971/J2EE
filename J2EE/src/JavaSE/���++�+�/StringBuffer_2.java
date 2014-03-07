package JavaSE.常用类库;

/**
 * 
 * @author 禅师
 * resume:
 * 		在任意位置为StringBuffer添加内容(insert方法)
 */
public class StringBuffer_2 {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer();
		str.append("hello everyone");
		
		//在hello和everyone中间添加学习家的
		str.insert(5,"学习java编程的每一个人");
		
		System.out.println(str);

	}

}
