package dnzl.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CommonTime {
	public Date date = null;

	public static boolean isDebug = false;

	public static final Calendar dar = Calendar.getInstance();

	public static final SimpleDateFormat sdf_day = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static final SimpleDateFormat sdf_time = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");

	public String sDate;

	public String sDay;

	public static void println(String str) {
		if (isDebug) {
			System.out.println(str);
		}
	}

	// 是否该日的第一次 以便做日统计
	public boolean isDay() {
		boolean falg = false;
		String str = sDate.substring(11, 13);
		println(str);
		if ("00".equals(str)) {
			falg = true;
		}
		return falg;
	}

	// 判断是否是该月的第一次,以便做月统计
	public boolean isMonth() {
		boolean falg = false;
		String str = sDate.substring(8, 13);
		println(str);
		if ("01 00".equals(str)) {
			falg = true;
		}
		return falg;
	}

	// 判断是否是该季度的第一次,以便做季度统计
	public boolean isQuarter() {
		boolean falg = false;
		String str = sDate.substring(5, 13);
		println(str);
		if ("01-01 00".equals(str) || "04-01 00".equals(str)
				|| "07-01 00".equals(str) || "10-01 00".equals(str)) {
			falg = true;
		}
		return falg;
	}

	// 判断是否是该年度的第一次,以便做年度统计
	public boolean isYear() {
		boolean falg = false;
		String str = sDate.substring(5, 13);
		println(str);
		if ("01-01 00".equals(str)) {
			falg = true;
		}
		return falg;
	}

	public CommonTime() {
		this.date = new Date();
		sdf_day.setTimeZone(timezone);
		sdf_time.setTimeZone(timezone);
		sDate = sdf_time.format(date);
		sDay = sdf_day.format(date);
	}

	public static void main(String[] args) {
		CommonTime obj = new CommonTime();
		System.out.println(obj.isDay());
		System.out.println(obj.isMonth());
		System.out.println(obj.isQuarter());
		System.out.println(obj.isYear());
	}
}
