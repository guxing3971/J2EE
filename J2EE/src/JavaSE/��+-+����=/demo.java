package JavaSE.国际化程序;

/**
 * 
 * @author 禅师
 * @resume
 * 		演示国家化程序的实现
 */
import java.util.*;


public class demo{

	public static void main(String[] args){
	
		//指定国家,语言
		Locale zhLocale = new  Locale("zh","CN");
		Locale enLocale = new Locale("en","US");
		
		//根据指定的国家/语言环境加载资源文件
		ResourceBundle zh_bundle = ResourceBundle.getBundle("mess",zhLocale);
		ResourceBundle en_bundle = ResourceBundle.getBundle("mess",enLocale);
		
		//打印从资源文件中获得的信息
		System.out.println(zh_bundle.getString("hello"));
		System.out.println(en_bundle.getString("hello"));
	
	}

}
