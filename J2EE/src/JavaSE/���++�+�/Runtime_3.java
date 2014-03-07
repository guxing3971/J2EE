package JavaSE.常用类库;

import java.io.IOException;

/**
 * 
 * @author 禅师
 * @resume
 * 		利用runtime类运行记事本,并在5秒后关闭该记事本
 */
public class Runtime_3 {


	public static void main(String[] args) {

		Runtime run = Runtime.getRuntime();
		
		Process pro = null;
		try {
			 pro = run.exec("notepad.exe");
		} catch (IOException e) {
			System.out.println("利用Runtime类执行本机命令失败");
			e.printStackTrace();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("线程休眠异常");
			e.printStackTrace();
		}
		
		pro.destroy();
	}

}
