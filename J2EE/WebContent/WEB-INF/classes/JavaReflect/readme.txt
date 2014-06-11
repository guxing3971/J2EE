Java反射

	所谓反射通俗的说就是通过对象实例获取类相关信息.
	主要的操作包有：
		java.lang.reflect包中
	

Java中的反射主要靠Class类来完成.
	在java.lang.reflect包中常用的类有
		Constructor		表示类中的构造方法
		Filed			表示类中的属性
		method			表示类中的方法


【实例化对象】
	- 通过无参构造实例化对象
		需要调用Class类的newInstance方法.必须保证类有无参构造
		demo 实例化对象.newInstance
	- 通过有参构造实例化对象
		· 通过Class类的getConstructors方法取得全部的构造方法
		· 想构造方法传递参数，以数组的形式
		· 通过构造方法实例创建对象实例
		
【调用实例的方法】
	如果想要通过反射调用那个对象的方法。
		· 首先要通过Class的getMethods方法获取对象的方法的实例Method
		· 设置参数
		· 通过Method类的invoke方法调用
	