package Test.TimeTaskTest;
import java.util.TimerTask;
import java.util.Date;
public class Task extends TimerTask{


	@Override
	public void run() {
		System.out.println(new Date());
	}

}
