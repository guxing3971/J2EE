package JavaSE.日期操作;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author 禅师
 * @resume
 * 		利用Date类获取系统当前时间;
 */
public class datetoShiJianChui {
	
	public static void main(String[] args) throws ParseException {
	      SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

	       String time="1970-01-06 11:45:55";

	       Date date = format.parse(time);

	       System.out.print("Format To times:"+date.getTime());

		
	}

}
