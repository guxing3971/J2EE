package JavaSE.定时调度;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo1 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		myTask task = new myTask();
		
		//一秒后开始执行myTask，以后每5秒执行一次
		timer.schedule(task, 1000, 5000);
		System.gc();

	}

}

/**
 * @type class
 * @resume 定时任务调度的任务指定
 *
 */
class myTask extends TimerTask{
	private String dateStr = null;
	@Override
	public void run() {

		//SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println("系统当前时间为："+date.format(new Date()));
		System.out.println(dateStr);
	}
	public myTask(){
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.dateStr = date.format(new Date());
	}
}
