package JavaSE;
import java.util.*;
public class SortedMapDemo{
	public static void main(String[] args){
		SortedMap<String,String> map = null;
		map = new TreeMap<String,String>();
		map.put("D","www.baidu.com");
		map.put("A","www.aaa.com");
		map.put("C","CC");
		map.put("B","bbb");

		System.out.println("first Map.Entry: key->value:"+map.firstKey()+"->"+
				map.get(map.firstKey()));
		System.out.println("last Map.Entry: key->value:"+map.lastKey()+"->"+
				map.get(map.lastKey()));
		System.out.println("B~C Map.Entry: key->value:"+map.subMap("B","C").entrySet());
		System.out.println("> B Map.Entry: key->value:"+map.tailMap("B").entrySet());
		System.out.println("< B Map.Entry: key->value:"+map.headMap("B").entrySet());			
	}
}