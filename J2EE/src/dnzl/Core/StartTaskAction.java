package dnzl.Core;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;

public class StartTaskAction extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
		 Scheduler sched;
		JobDetail jobDetail = 
				new JobDetail("Job_Dnzl",Scheduler.DEFAULT_GROUP,TaskCoreJob.class);
		JobDetail jobDetail1 = 
				new JobDetail("Job_Extract",Scheduler.DEFAULT_GROUP,Extract_ZT_SupperClass.class);		

		JobDetail jobDetail2 =
				new JobDetail("Job_calhisdb",Scheduler.DEFAULT_GROUP,TaskCore_ProductDataAtHISDB.class);
		
		CronTrigger trigger,trigger1,trigger2;
		try {
			trigger = new CronTrigger("Job_Dnzl_Task","Dnzl","55  05 * * * ?");
			trigger1 = new CronTrigger("Job_Extract","Dnzl","00 02  * * * ?");
			trigger2 = new CronTrigger("Job_calhisdb","Dnzl","00 02  * * * ?");
			sched = new org.quartz.impl.StdSchedulerFactory().getScheduler();
			sched.scheduleJob(jobDetail,trigger); 
			sched.scheduleJob(jobDetail1, trigger1);
			sched.scheduleJob(jobDetail2, trigger2);
			sched.start(); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
