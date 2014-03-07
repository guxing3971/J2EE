package JavaSE;
import java.util.*;
public class WeakMapDemo{
	public static void main(String[] args){
		Map<String,String> map = null;
		map = new WeakHashMap<String,String>();
		map.put(new String("BT"),new String("www.baidu.com"));
		map.put(new String("lolo"),new String("lol.qq.com"));
		map.put(new String("QQ"),new String("im.qq.com"));

		System.gc();
		map.put(new String("cf"),new String("cf.qq.com"));

		//涓€鑸彧锲炲墿涓嬫渶鍚庝竴涓唴瀹?
		System.out.println(map);
	}
}