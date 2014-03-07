package JavaSE.日期操作;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author 禅师
 * @resume
 * 		利用Calendar类获取系统当前时间
 */
public class Calendar_1 {

	public static void main(String[] args) {

		Calendar Cale = null;
		Cale = new GregorianCalendar();
		
		System.out.print(Cale.get(Calendar.YEAR)  +"年");
		System.out.print(Cale.get(Calendar.MONTH)+1  +"月");
		System.out.print(Cale.get(Calendar.DAY_OF_MONTH)  +"日");
		System.out.print(Cale.get(Calendar.HOUR_OF_DAY)  +"时");
		System.out.print(Cale.get(Calendar.MINUTE)  +"分");
		System.out.print(Cale.get(Calendar.SECOND)  +"秒");
	}

}
