package JavaSE;
import java.util.List;
import java.util.Vector;

public class VectorDemo{
	public static void main(String[] args){
		List<String> allList = null;
		allList = new Vector<String>();

		allList.add("hello");
		allList.add(0,"ChanShi");


		for(int i =0; i< allList.size();i++){
			System.out.println(allList.get(i));
		}
		System.out.println(allList);
	}
}