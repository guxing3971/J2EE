在Java中想实现多线程有各种方式:
	(1) 继承Thread类
	(2) 实现Runnable接口

	
=Thread=
	Thread类是java.lang包中定义的,要想通过Thread类来实现多线程,则必须在Thread的子类中实现run方法.
	该方式线程的主体.即要执行的代码.
	
	启动线程可以调用Thread类的start()方法.
	
	如果一个类通过继承Thread类来实现,那么只能调用一次start(),多次调用会出现异常
=Runnable=
	在Runnable接口中定义一个run()方法,即通过该方法的实现完成线程的功能.
	
	通过Runnable接口的实现类创建新线程:
		public  Thread(Runnable  target);
		public  Thread(Runnable target,String name)
	
=区别=
	Runnable接口可以理解为Thread类的代理.
	在使用上有不不同的区别.
	其次Thread类不支持多线程的资源共享.Runnable接口支持.
=线程的状态=
	在java中想要实现多线程的程序,则必须在主线程中创建新的线程.一般线程的状态分为如下5中状态:
	创建~就绪~运行~阻塞~死亡
	
	
	
	
	
