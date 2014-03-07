package JavaSE.日期操作;

import java.text.DateFormat;
import java.util.Date;

/**
 *  
 * @author 禅师
 * @resume
 * 		利用DateFormat格式化Date
 */
public class DateFormat_1 {

	public static void main(String[] args) {

		DateFormat date1 = DateFormat.getDateInstance();
		DateFormat date2 = DateFormat.getDateTimeInstance();
		
		System.out.println("Date:" + date1.format(new Date()));
		System.out.println("DateTime:"+date2.format(new Date()));
		

	}

}
