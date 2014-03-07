package JavaSE;
import java.util.*;

public class TreeMapDemo{
	public static void main(String[] args){
		Map<String,String> map = null;
		map = new TreeMap<String,String>();
		map.put("D-demo","this is demo");
		map.put("C-text","this is String");
		map.put("A-test","this is test");
		map.put("B-String","this is String");
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String str = iter.next();
			System.out.println(str + "--->"+ map.get(str));
		}
	}
}