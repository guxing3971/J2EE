package dnzl.Core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import dnzl.Core.db.PushLogVO;
import dnzl.Core.db.PushVO;
import dnzl.Core.db.PushgLogDao;

public class Push_Task_SuperClass implements Runnable{
	
	public SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");
	
	private  static PushgLogDao log_db = new PushgLogDao();
	
	private  static Random random1 = new Random(100);
	
	private  boolean isLog = true;
	
	private  boolean isNeed = true;
	
	public	 StringBuffer msg = new StringBuffer();
	
	public PushVO vo = null;
	
	public PushLogVO log = new PushLogVO();
	
	
	public void run() {
		synchronized(this){
		init_log();
		initData();
		if(isNeed){
			log.setTime_Start(sdf1.format(new Date()));
			boolean falg = Push(vo);
			if(falg){
				log.setStatus("true");
			}else{
				log.setStatus("false");
			}
			log.setTime_End(sdf1.format(new Date()));
			log.setStatusNode(msg.toString());
			if(isLog){
				log_db.Update_db(log);
			}
		}
		}
	}


	public void setVo(PushVO vo) {
		this.vo = vo;
	}


	private void init_log(){
		log.setRecordid(String.valueOf(System.currentTimeMillis()+random1.nextInt()));
		log.setJobEname(vo.getJobEname());
		log.setJobCname(vo.getJobCname());
		log.setJobType(vo.getJobType());
	}


	public Push_Task_SuperClass() {
		sdf1.setTimeZone(timezone);
	}

	public void IsLog(boolean flag){
		this.isLog = flag;
	}
	public void IsNeed(boolean flag){
		this.isNeed = flag;
	}
	public synchronized boolean  Push(PushVO vo){
		return false;
	}
	public void initData(){
		
	}
}
