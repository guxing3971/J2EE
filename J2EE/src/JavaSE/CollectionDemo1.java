package JavaSE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionDemo1{
	public static void main(String[] args){
		List<String>  allList = null;
		Collection<String> allCollection = null;

		allList = new ArrayList<String>();
		allCollection = new ArrayList<String>();

		allList.add("hello");
		allList.add(0,"ChanShi");
		System.out.println(allList);
		allCollection.add("sss");
		allCollection.add("www.baidu.com");
		allList.addAll(allCollection);
		System.out.println("list:\t"+allList);
		System.out.println("Collection:\t"+allCollection);
	}
}