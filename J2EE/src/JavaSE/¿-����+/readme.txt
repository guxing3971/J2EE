定时调度

	在java中可以使用Timer类来完成定时调度.Timer类是一种线程实施.可以在指定在某一时间,或某段时间后执行一次或重复执行一调度任务.
	该功能要用TimerTask配合使用.TimerTask类主要用于指定调度任务
	
	Timer对象都代表一个线程。因此计时器调用的任务，应及时完成，否则可能出现任务延迟执行。
	
　　构造方法:
　　public  Timer()								//用来创建一个计时器并启动该计时器
　　public  void cancel()							//用来终止该计时器,并放弃所有已安排的任务.对当前正在执行的任务没有影响
　　public  int purge()								//将所有已经取消的任务移除,一般用来释放内存空间
　　public  void schedule(TimerTask task,Date time)	//安排一个任务在指定的时间执行,然后以固定的频率(单位:毫秒)重复执行
　　public  void schedule(TimerTask task, long delay)	//安排一个任务在一段时间(单位:毫秒)后执行
　　public  void scheduleAtFixedRate(TimerTask task,Date firstTime,long period)	//安排一个任务在指定的时间执行,然后以近似的固定频率重复执行
　　public  void scheduleAtFixedRate(TimerTask task,long delay,long period)	//安排一个任务在一段时间后执行,然后以近似固定的频率重复执行

　　上述,schedule()与scheduleAtFixedRate()方法的区别在于重复执行任务相对于时间间隔出现延迟的情况除了:
　　+ schedule() 方法的执行时间间隔永远是固定的,如果之前出现了延迟的情况,之后也会继续按照设定好的间隔时间来执行
　　+ scheduleAtFixedRate() 方法可以根据出现的延迟时间自动调整下一次间隔的执行时间.

　　要执行具体的任务.则必须适用TimerTask类.TimerTask类是一个抽象类,如果要适用该类,需要自己建立一个类来继续继承此类.并实现其中的抽象方法.TimerTask
　　中的常用方法有:
　　public void cancel() 					//用来终止此任务,如果该任务只执行一次且没有执行,则永远不会执行,如果为重复执行任务,则之后不会再执行.
　　public void run()						//该任务所要执行的具体操作,该方法为引入的接口Runnable中的方法,子类需要覆写此方法
　　public long scheduledExecutionTime() 	//返回最近一次要执行该任务的时间.(如果正在执行,则返回此任务的执行安排时间)
　　//一般在run()方法调用,用来判断当前是否有足够的时间来执行完成该任务.