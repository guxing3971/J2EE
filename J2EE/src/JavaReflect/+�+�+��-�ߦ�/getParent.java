package JavaReflect.获取类的结构;

/**
 * 
 * @author 禅师
 * @resume 获得父类
 */
public class getParent {

	public static void main(String[] args) {
		Class<?> c1 = null;
		
		try {
			c1 = Class.forName("获取类的结构.getParentDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Parent-class ->"+c1.getSuperclass());
	}

}

class getParentDemo{
	
}
