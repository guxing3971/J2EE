=String and StringBuffer=
	String类封装了字符串操作的一些常用方法.但String类型的变量一旦声明就不能改变.要想改变就必须重新赋值.
	即重新建立新的引用关系.
	
	假如一个字符串要经常改变,建议使用StringBuffer类.该类便于操作,同时也提供了很好的性能.

=Runtime=
	运行时类,代表一个jvm进程.每一个jvm都会初始化一个Runtime类.该类采用单继承方式.要想获得一个该类的实例
	可以通过如下形式:
	Runtime run = Runtime.getRuntime();
	
	通过该实例可以获取一些系统信息,并执行一些系统命令
	
=System=
	System类同Runtime类相似可以获取系统属性
	
=Math=
	该类提供一些常用的数学操作
=Random=
	主要用于产生随机数
	
=NumberFormat=
	主用用于数字的格式化显式.功能更强大的数字显式请查阅DecimalFormat类
	
=BigInteger=
	方便的完成超大数据的运算
	