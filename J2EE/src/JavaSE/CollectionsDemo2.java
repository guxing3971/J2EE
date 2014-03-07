package JavaSE;
import java.util.*;

public class CollectionsDemo2{
	public static void main(String[] args){
		List<String>  list = new ArrayList<String>();
		Collections.addAll(list,"text","test","qq");

		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+"--");
		}
		
		int point = Collections.binarySearch(list,"text");
		System.out.println("indexof-text:"+point);

	}
}