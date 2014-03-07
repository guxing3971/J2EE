package JavaSE.常用类库;

/**
 * 
 * @author 禅师
 * @resume
 * 		通过System类提供的方法获取一个函数执行的时间
 */
public class System_1 {

	public static void main(String[] args) throws InterruptedException {

		long  startTime = System.currentTimeMillis();
		
		//一个耗时操作	
		for(int i =0; i < 1000;i ++){
			i += i;
			Thread.sleep(200);
		}
	
		
		long endTime	= System.currentTimeMillis();
		
		System.out.println("该函数耗时:" + (endTime-startTime) +"毫秒");
	}

}
