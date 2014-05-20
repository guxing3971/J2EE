package dnzl.Core;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TaskCoreJob implements Job{
	
	@Override
	public synchronized void execute(JobExecutionContext arg0) throws JobExecutionException {
			System.out.println("[---------电能质量在线检测Job启动------------]");
	
			Thread ExtractThread = new Thread(new dnzl.Core.TaskCore_ExtractThread());
			Thread PushThread = new Thread(new TaskCore_PushThread());
			
			ExtractThread.setName("TaskCore_ExtractThread");
			PushThread.setName("TaskCore_PushThread");
			
			ExtractThread.start();
			try {
				Thread.sleep(1000 * 60 * 3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				PushThread.start();
			}
	}
}
