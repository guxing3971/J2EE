package JavaSE;
import java.util.Scanner;
public class scann{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		while(sc.hasNext()){
			System.out.println("content:"+sc.next());
		}
	}
}