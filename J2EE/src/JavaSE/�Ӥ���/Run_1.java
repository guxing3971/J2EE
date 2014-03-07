package JavaSE.多线程;

public class Run_1 implements Runnable{

	public static void main(String[] args) {
	
		//通过Runnable接口实现多线程序
		Run_1 th = new Run_1();
		new Thread(th,"Run线程1").start();
		new Thread(th,"Run线程2").start();

	}

	@Override
	public void run() {
		int i ;
		for(i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"--->" + i);
		}
		
	}
	
	
	

}
