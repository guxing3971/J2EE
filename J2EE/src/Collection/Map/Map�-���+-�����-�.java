package Collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 禅师
 * @resume map的标准输出流程：
 * 				1.通过entrySet将map转换为set集合
 * 				2.通过set集合实例化Iterator接口实例
 * 				3.以Map.Entry用Iterator实例遍历输出
 */
public class Map的标准输出格式 {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		
		//向map中添加内容
		map.put("1111", "禅师");
		map.put("2222", "尼姑");
		map.put("3333", "方丈");
		map.put("4444", "和尚");
		map.put("5555", "师太");
		
		//将Map集合转换为set集合
		Set<Map.Entry<String,String>> mapSet = map.entrySet();
		
		//实例化Iterator实例
		Iterator<Map.Entry<String,String>> mapIter = mapSet.iterator();
		
		//遍历输出
		while(mapIter.hasNext()){
			Map.Entry<String,String> element = mapIter.next();
			System.out.println("key : value -> " + element.getKey() + " : "+element.getValue());
		}
	}

}
