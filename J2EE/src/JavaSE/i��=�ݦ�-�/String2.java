package JavaSE.正则表达式;

public class String2 {

	public static void main(String[] args) {

	//	String temp ="2012-12-21";
		
		String temp ="2012 12 21";
		
		//进行格式验证
		if(temp.matches("\\d{4}-\\d{2}-\\d{2}")){
			System.out.println("正确的日期格式");
		}else{
			System.out.println("错误的日期格式");
		}
	}

}
