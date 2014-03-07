package JavaSE;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetDemo{
	public static void main(String[] args){
		SortedSet<String> set = new TreeSet<String>();

		set.add("B");
		set.add("E");
		set.add("A");
		set.add("D");
		set.add("C");
		System.out.println(set);
		System.out.println("first-element:"+set.first());
		System.out.println("last-element:"+set.last());
		System.out.println("headSet:"+set.headSet("C"));
		System.out.println("tailSet:"+set.tailSet("C"));
		System.out.println("subSet:"+set.subSet("B","D"));
	}
}