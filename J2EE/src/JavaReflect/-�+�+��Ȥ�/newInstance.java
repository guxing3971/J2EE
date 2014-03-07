package JavaReflect.实例化对象;
/**
 * 
 * @author 禅师
 * @resume 利用对象的无参构造方法实例化对象。需要调用Class的Instance完成
 */
public class newInstance {

	public static void main(String[] args) {
		Class<?> c1 = null;
		
		try {
			c1 = Class.forName("实例化对象.demo1");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//通过对象的无参构造方法构造demo1的对象
		demo1 d = null;
		
		try {
			d = (demo1)c1.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		System.out.println(d);
	}

}

class demo1 {
	private String str = "current-class demo1";

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "demo1 [str=" + str + "]";
	}
}
