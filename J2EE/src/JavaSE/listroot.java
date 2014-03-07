package JavaSE;

import java.io.File;
import java.io.FilenameFilter;

public class listroot{
	public static void main(String[] args){
		File file= new File(".");
		String[] list = file.list(new MyFilenameFilter());
		for(String name:list){
			System.out.print(name);
		}

	}
}
class MyFilenameFilter implements FilenameFilter{
	public boolean accept(File dir,String name){
		//濡傛灉鏂囦欢鍚崭互.java缁揿熬.鎴栬€呮枃浠跺悕瀵瑰簲涓€涓矾寰勮繑锲潇rue
		return name.endsWith(".java") 
			|| new File(name).isDirectory();
	}
}