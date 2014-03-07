package JavaSE.日期操作;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * @author 禅师
 * @resume
 * 		利用SimpleDateFormat类将2013-2-20 21:54:37转换为2013年2月20日 21时54分37秒
 */
public class SimpleDateFormat_1 {

	public static void main(String[] args) {

		String date ="2013-2-20 21:54:37";
		
		//准备模式
		String pat1 = "yyyy-MM-dd HH:mm:ss";
		String pat2 = "yyyy年MM月dd日  HH时mm分ss秒";
		
		SimpleDateFormat date1 = new SimpleDateFormat(pat1);
		SimpleDateFormat date2 = new SimpleDateFormat(pat2);
		
		Date result = null;
		
		try {
			result = date1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date2.format(result));
	}

}
