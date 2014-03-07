package JavaSE.多线程;

/**
 * file-name: API_demo4
 * 
 * @author 禅师 resume: 线程优先级测试
 */
public class API_demo4 {

	public static void main(String[] args) {

		demo4 temp = new demo4();

		Thread thread1 = new Thread(temp);
		thread1.setPriority(Thread.MIN_PRIORITY);
		Thread thread2 = new Thread(temp);
		thread2.setPriority(Thread.NORM_PRIORITY);
		Thread thread3 = new Thread(temp);
		thread3.setPriority(Thread.MAX_PRIORITY);
		
		thread1.start();
		thread2.start();
		thread3.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);
	}

}

class demo4 implements Runnable {

	@Override
	public void run() {
		String name;
		name = Thread.currentThread().getName();
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("线程休眠异常");
				e.printStackTrace();
			}
			System.out.println(name + "正在运行" + "优先级为:   ["
					+ Thread.currentThread().getPriority() + "]");
		}
	}
}
