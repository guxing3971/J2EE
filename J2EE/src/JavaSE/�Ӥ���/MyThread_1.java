package JavaSE.多线程;

public class MyThread_1 extends Thread {

	private String name;
	
	public MyThread_1(String name) {
		this.name = name;
	}

	/**
	 * 线程运行体
	 */
	@Override
	public void run() {
		int i = 0;
		
		for(; i< 10;i++){
			System.out.println(name +"--->" + i);
		}
		
	}

	public static void main(String[] args) {
		
		//创建俩个线程
		MyThread_1 thread = new MyThread_1("线程1");
		MyThread_1 thread2 = new MyThread_1("线程2");
		
		//启动俩个线程
		thread.start();
		thread2.start();
		

	}

}
