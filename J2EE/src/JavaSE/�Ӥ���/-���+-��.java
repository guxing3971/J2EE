package JavaSE.多线程;

/**
 * @author 禅师
 * resume:
 * 		展现多线程同步问题
 */
public class 同步问题 {


	public static void main(String[] args) {

		demo5 temp = new demo5();
		Thread thread1 = new Thread(temp);
		Thread thread2 = new Thread(temp);
		Thread thread3 = new Thread(temp);
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}

class demo5 implements Runnable{
	private int  resource = 5;
	@Override
	public void run() {
		for(int i = 5; i > 0; i--){
			String name = Thread.currentThread().getName();
			
			if(resource > 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " use resource : ["+ resource-- +"]");
			}	
		}

	}
}