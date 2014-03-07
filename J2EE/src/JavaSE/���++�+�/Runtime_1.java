package JavaSE.常用类库;

/**
 * 
 * @author 禅师
 * @resume
 * 		获得JVM的内存空间信息
 */
public class Runtime_1 {


	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		
		System.out.println("JVM的最大内存空间:" + run.maxMemory());
		
		//做一个很消耗内存空间的操作
		String str = "hello world";
		System.out.println("利用字符串消耗内存:"+str );
		for(int i=0; i < 2000 ;i++){
			str += i;
		}
		System.out.println("JVM的空闲内存:"+run.freeMemory());
		
		//进行垃圾回收
		run.gc();
		System.out.println("垃圾回收后的空闲内存:"+run.freeMemory());
	}

}
