package dnzl.FengGuPing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import dnzl.Core.Push_FTP_SuperClass;

public class Push_FTP_FGP extends Push_FTP_SuperClass{
	private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd_HH");
	
	private TimeZone timezone = TimeZone.getTimeZone("Asia/Shanghai");
	public String filename = "";
	public boolean flag = false;
	
	public void SpellFileName(){
		sdf1.setTimeZone(timezone);
		String str_time = sdf1.format(new Date());
		String str_node = str_time.substring(9, 11);
		if(str_node.equals("02") || str_node.equals("10") || str_node.equals("20")){
			flag = true;
		}
		filename="青海_"+str_time+"00.QS";
	}	
	
	@Override
	public void initData() {
		SpellFileName();
		this.setFile_name(filename);
		this.IsNeed(flag);
		this.IsLog(flag);
	}
}
