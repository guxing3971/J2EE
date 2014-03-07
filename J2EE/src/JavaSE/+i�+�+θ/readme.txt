java对日期操作提供很好编辑的系统库支持有:
	java.util包下的Date和Calendar
	java.text包下的SimpleDateFormat
	
其中Calendar类是抽象类,常用GregorianCalendar类实例化.

DateFormat类:
	java.util包先的Date类所获取的系统时间是相当精确的.但其显式格式不是很理想,为此提供DateFormat类
	
	
如果要将
	2013-2-20 21:54:37形式的时间转换为2013年2月20日 21时54分37秒这中形式的.可以使用SimpleDateFormat类来完成