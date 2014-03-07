package JavaSE.多线程;

/**
 * @author 禅师
 * resume:
 * 		java中线程分为后台线程和前台线程,只要有一个前台线程在运行java就不会推出
 */

public class API_demo3 {

	public static void main(String[] args) {
		demo3 temp = new demo3();
		Thread thread = new Thread(temp);
		thread.start();
	
		
		//将线程设置为后台线程
		Thread thread1 = new Thread(temp);
		thread1.setDaemon(true);
		thread1.start();

	}

}
class demo3 implements Runnable{

	@Override
	public void run() {
		String name;
		name = Thread.currentThread().getName();
		System.out.println(name + "开始运行");
		
		try {
			System.out.println(name + "进入修改状态");
			Thread.sleep(3000);
			System.out.println(name + "正常休眠结束");
		} catch (InterruptedException e) {
			System.out.println("线程休眠异常");
			e.printStackTrace();
		}
		System.out.println(name +"线程正常结束");
	}
	
	
}



