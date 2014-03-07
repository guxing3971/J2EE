package JavaSE.多线程;

public class MyThread_2 {

	public static void main(String[] args) {
		MyThread2 Thr1 = new MyThread2();
		MyThread2 Thr2 = new MyThread2();
		MyThread2 Thr3 = new MyThread2();
		
		Thr1.start();
		Thr2.start();
		Thr3.start();

	}

}

class MyThread2 extends Thread{
	private int testResource = 5;

	@Override
	public void run() {
		for(int i =0; i < 5;i++){
			String currentThreadName = Thread.currentThread().getName();
			System.out.println(currentThreadName + " use " + testResource--);
		}
	}
		
}
