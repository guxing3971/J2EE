package JavaSE;
import java.util.*;

public class CollectionsDemo1{
	public static void main(String[] args){
		List<String> list =new ArrayList<String>();
		Collections.addAll(list,"test","text","java");

		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+"--");
		}
	}
}