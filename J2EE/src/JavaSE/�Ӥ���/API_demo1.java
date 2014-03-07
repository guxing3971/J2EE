package JavaSE.多线程;

public class API_demo1 {

	public static void main(String[] args) {

		GetThreadName temp = new GetThreadName();
		
		//手动设置线程的名称
		Thread thread = new Thread(temp,"线程-1");
		thread.start();
		
		//系统自动手中线程的名称
		new Thread(temp).start();
		
		
		//该线程的名称
		thread.setName("线程的新名字");
		
	}

}


class GetThreadName implements Runnable{

	@Override
	public void run() {
		String ThreadName;
		
		ThreadName = Thread.currentThread().getName();
		
		//获取线程名
		System.out.println("当前运行的线程名为: " + ThreadName);	
		
		//线程休眠
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("延迟-线程的名字: " + ThreadName);
	}
	
	
}
