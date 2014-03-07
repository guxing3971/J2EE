package JavaSE;
import java.util.ArrayList;
import java.util.List;

public class foreacDemo{
	public static void main(String[] args){
		List<String> all = new ArrayList<String>();
		all.add("hello");
		all.add("world");

		for(String temp:all){
			System.out.print(temp+"~");
		}
	}
}