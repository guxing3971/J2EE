package JavaSE;
import java.util.Set;
import java.util.TreeSet;

public class TreesetDemo{
	public static void main(String[] args){
		Set<String> set = new TreeSet<String>();
		set.add("B");
		set.add("E");
		set.add("A");
		set.add("A");
		set.add("A");
		set.add("D");
		set.add("C");
		System.out.println(set);
	}
}