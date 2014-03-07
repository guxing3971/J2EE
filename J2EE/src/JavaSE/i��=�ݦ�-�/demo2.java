package JavaSE.正则表达式;

import java.util.regex.Pattern;

/**
 * 
 * @author 禅师
 * @resume 按数字拆分字符串
 */
public class demo2 {

	public static void main(String[] args) {

		String str = "AA11BB22CC33DD44EE";
		String pat = "\\d{2}";
		
		Pattern patt = Pattern.compile(pat);
		String res[] = patt.split(str);
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]+"\t");
		}
	}

}
