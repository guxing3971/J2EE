java.util.Arrays类封装了许多数组相关的操作类



该类可以对  "对象数组"进行排序.但前提是对象必须实现比较器,即要实现Comparable接口
	该接口定义如下方法
		public int compareTo(T o);
	该方法必须返回如下值:
		1 : 表示大于
		0 : 表示等于
		-1 :表示小于
		
Comparable比较器只能对已经实现该接口的类进行比较.如果要想对没有实现Comparable接口的类进行比较.可以使用Comparator比较器.
该接口定义如下的方法
	public int CompareTo(T o1,To2); //返回值同上
	boolean equals(Object obj);