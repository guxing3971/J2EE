package JavaSE.dateDemo.copy;

import java.util.TimeZone;

import org.junit.Test;

public class testDate {
	@Test
	public void getNextMonth() {
		TimeZone tz = TimeZone.getTimeZone("Etc/GMT-8"); 
		TimeZone.setDefault(tz);
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("MM");
		java.util.Date date = new java.util.Date(new java.util.Date().getTime());
		String currentTime = format.format(date);
		int tempmonth=0;
		if(currentTime.equals("12")){
			currentTime="01";	
		}
		else
		{
			tempmonth = Integer.parseInt(currentTime);
			if(tempmonth<10){
				currentTime="0"+tempmonth;	
			}
			else{
				currentTime=""+tempmonth;	
			}
			
		}
		System.out.println(currentTime);
	}
}
