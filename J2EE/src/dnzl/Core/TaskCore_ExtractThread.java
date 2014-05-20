package dnzl.Core;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dnzl.Core.db.ExtractDao;
import dnzl.Core.db.ExtractVO;

public class TaskCore_ExtractThread implements Runnable{
	
	private static ExtractDao dao = new  ExtractDao();
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void run() {
		synchronized(this){
			List<Object> list = null;
			try {
				list = dao.AllDataSource();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("数据抽取Job共计"+list.size()+"个");
			Iterator<Object> iterator = list.iterator();
			while(iterator.hasNext()){
				ExtractVO ex = (ExtractVO)iterator.next();
				String Cname = ex.getJobCname();
				if(Cname.length() < 5){
					Cname = Cname+"\t";
				}
				String jobType = ex.getJobType();
				String job_info =sdf.format(new Date())+"\t"
							+Cname+"\tJob类型:"+jobType;
				Class<?> c  = null;
				try {
					c = Class.forName(ex.getTask());
					try {
						Extract_Task_SuperClass task = (Extract_Task_SuperClass)c.newInstance();
						task.setVo(ex);
						Thread th = new Thread(task);
						th.start();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println(job_info);
			}
		}
	}
}
