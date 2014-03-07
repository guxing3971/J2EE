package JavaSE.日期操作;

import java.util.Date;

/**
 * 
 * @author 禅师
 * @resume
 * 		利用Date类获取系统当前时间;
 */
public class Date_1 {
	
	public static void main(String[] args) {
		Date time = null;
		time = new Date();
		System.out.println("系统当前时间为: "+ time.toString());
		
	}

}
