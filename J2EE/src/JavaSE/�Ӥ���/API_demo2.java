package JavaSE.多线程;

public class API_demo2 {

	public static void main(String[] args) {

		demo2 temp = new demo2();
		Thread thread = new Thread(temp);
		thread.start();
		
		//休眠4000毫秒后打断其运行
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println("线程修改异常");
			e.printStackTrace();
		}
		//强行中断线程
		thread.interrupt();
	}

}

class demo2 implements Runnable{

	@Override
	public void run() {
		// 线程中断
		String name;
		name = Thread.currentThread().getName();
		System.out.println(name + "启动");
		
		
		//休眠10000毫秒便于测试
		try {
			Thread.sleep(10000);
			System.out.println(name+"休眠结束");
		} catch (InterruptedException e) {
			System.out.println("线程修改异常");
			e.printStackTrace();
		}
		
		System.out.println(name + "正常结束");
		
	}
	
	
}
