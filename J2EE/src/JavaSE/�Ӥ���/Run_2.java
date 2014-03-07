package JavaSE.多线程;

public class Run_2 {

	public static void main(String[] args) {
		Run2 thr1 = new Run2();


		new Thread(thr1,"线程1").start();
		new Thread(thr1,"线程2").start();
		new Thread(thr1,"线程3").start();
		
	}

}

class Run2 implements Runnable{

	private int testResource = 5;
	@Override
	public void run() {
		for(int i =0;i < 5;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String currentThreadName = Thread.currentThread().getName();
			if(testResource > 0){
				System.out.println(currentThreadName + " use "+ testResource--);				
			}

		}
	}
	
}
