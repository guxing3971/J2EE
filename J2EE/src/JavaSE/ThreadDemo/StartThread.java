package JavaSE.ThreadDemo;

public class StartThread {
	public static void main(String[] args) throws InterruptedException{
		Thread th1 = new Thread(new ThreadByRunnable());
		Thread th2 = new ThreadExtends();
		
		th1.start();
		Thread.sleep(1000 * 11);
		System.out.println("---");
		th1.start();
		Thread.sleep(1000 * 11);
		System.out.println("---");
		th2.start();
		Thread.sleep(1000 * 11);
		System.out.println("---");
		th2.start();
	}
}
