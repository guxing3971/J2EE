package JavaSE.常用类库;

import java.io.IOException;

/**
 * 
 * @author 禅师
 * @resume
 * 		利用Runtime类运行本机命令 
 */
public class Runtime_2 {

	public static void main(String[] args) {


		Runtime run = Runtime.getRuntime();
		
		//利用Runtime类打开记事本
		try {
			run.exec("notepad.exe");
		} catch (IOException e) {
			System.out.println("利用Runtime运行本机命令失败");
			e.printStackTrace();
		}
	}

}
