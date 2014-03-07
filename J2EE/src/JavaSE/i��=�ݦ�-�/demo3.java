package JavaSE.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author 禅师
 * @resume 字符串替换
 */
public class demo3 {


	public static void main(String[] args) {
		String str = "AA11BB22CC33DD44EE";
		String pat = "\\d{2}";
		
		Pattern patt = Pattern.compile(pat);
		Matcher matcher = patt.matcher(str);
		
		String newString = matcher.replaceAll("__");
		System.out.println("原先字符串:"+str);
		System.out.println("替换后的字符串:"+newString);
		
		
		
	}

}
