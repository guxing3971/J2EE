JDK1.4中引入了正则表达式.

	要想在程序中使用正则表达式则必须有java.util.regex包下的Pattern和Matcher类完成.
	
	Pattern类主要用定义正则规则,
	Matcher类主要用于执行规则
	
String类对正则表达式也予以支持,如下3个函数支持正则表达式
	matches(String regex) 
	replaceAll(String regex, String replacement) 
	split(String regex) 