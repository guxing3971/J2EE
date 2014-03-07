package JavaSE.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @author 禅师
 * @resume 演示正则的使用
 */
public class demo1 {

	public static void main(String[] args) {

		//String str = "2012-12-11";
		String str = "2012 12 11";
		String pat = "\\d{4}-\\d{2}-\\d{2}";
		
		//定义验证规则
		Pattern patter = Pattern.compile(pat);
		Matcher matcher = patter.matcher(str);
		//执行验证
		if(matcher.matches()){
			System.out.println("合法字符串");
		}else{
			System.out.println("非法字符串");
		}
	}

}
