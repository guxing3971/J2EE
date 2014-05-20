package dnzl.Core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import dnzl.Core.db.ExtractLogDao;
import dnzl.Core.db.ExtractLogVO;
import dnzl.Core.db.ExtractVO;

public class Extract_Task_SuperClass implements Runnable {

	public ExtractVO vo = null;

	private static ExtractLogDao log_db = new ExtractLogDao();

	public ExtractLogVO log = new ExtractLogVO();

	public SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd HH");

	public TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");

	private boolean isLog = true;

	private static Random random1 = new Random(100);

	private boolean isNeed = true;

	public StringBuffer msg = new StringBuffer();

	public void run() {
		sdf1.setTimeZone(timezone);
		sdf2.setTimeZone(timezone);
		synchronized (this) {
			init_log();
			initData();
			if (isNeed) {
				log.setTime_Start(sdf1.format(new Date()));
				boolean falg = Extract(vo);
				if (falg) {
					log.setStatus("true");
				} else {
					log.setStatus("false");
				}
				log.setTime_End(sdf1.format(new Date()));
				if (isLog) {
					log.setStatusNode(msg.toString().trim());
					log_db.Update_db(log);
				}
			}
		}
	}

	public void IsNeed(boolean flag) {
		this.isNeed = flag;
	}

	public void IsLog(boolean flag) {
		this.isLog = flag;
	}

	public Extract_Task_SuperClass() {
		sdf1.setTimeZone(timezone);
	}

	public void setVo(ExtractVO vo) {
		this.vo = vo;
	}

	private void init_log() {
		log.setRecordid(String.valueOf(System.currentTimeMillis()+ random1.nextInt(100000)));
		log.setJobEName(vo.getJobEname());
		log.setJobCName(vo.getJobCname());
		log.setJobType(vo.getJobType());
	}

	/**
	 * 子类必须覆盖此类来完成数据抽取的任务
	 * 
	 * @param vo
	 *            一个数据抽取任务的VO对象
	 * 
	 *            注意子类可以直接使用log可以方便的记录运行日志信息
	 */
	public synchronized boolean Extract(ExtractVO vo) {
		return false;
	}

	public void initData() {

	}
}
