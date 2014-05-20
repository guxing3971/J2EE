package dnzl.Core;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.lang.Class;
import dnzl.Core.db.PushgLogDao;
import dnzl.Core.db.PushDao;
import dnzl.Core.db.PushVO;
@SuppressWarnings("unused")
public class TaskCore_PushThread implements Runnable {
	
	private static PushDao dao = new PushDao();
	
	private List<Object> list = null;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void run() {
		synchronized(this){
		System.out.println("开始启用数据推送Job");
		try {
			list = dao.AllPushJob();
			System.out.println("数据推送Job共计:>"+list.size()+"个Job");
		} catch (SQLException e) {
			System.out.println("数据推送Job配置读取-->失败\tclass:>dnzl.Core.TaskCore_PushThread");
			e.printStackTrace();
		}
		
		Iterator<Object> iter =list.iterator();
		while(iter.hasNext()){
			PushVO ex = (PushVO) iter.next();
			String jobType = ex.getJobType();
			String class_task = ex.getTask();
			String job_info =sdf.format(new Date())+"\t"
					+ex.getJobCname()+"\tJob类型:"+jobType;//+"\t实现类"+class_task;
			dnzl.Core.Push_Task_SuperClass task = null;
			try {
				Class<?> c = java.lang.Class.forName(class_task);
				task = (Push_Task_SuperClass) c.newInstance();
				task.setVo(ex);
				Thread th = new Thread(task);
				th.start();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			System.out.println(job_info);
		}	
	}
	}
}
