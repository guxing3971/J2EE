package JavaSE;
import java.util.*;

public class unmodifiable{
	public static void main(String[] args){
		List<String> unmod_list = Collections.emptyList();
		Set<String> unmod_set = Collections.singleton("java");

		Map<String,Integer> sorces = new HashMap<String,Integer>();
		sorces.put("English",90);
		sorces.put("Computer",80);
		//杩斿洖鏅€氶泦鍚堜笉鍙彉镄勯泦鍚堜綋
		Map<String,Integer> unmod_sorces = Collections.unmodifiableMap(sorces);
	}
}