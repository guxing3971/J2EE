package JavaSE.正则表达式;

public class String3 {

	public static void main(String[] args) {
		String str= "AA11BB22CC3DD444EEE5555FFFF";
		
		//字符串拆分
		String res[] = str.split("\\d+");
		
		for(int i =0; i< res.length;i++){
			System.out.println(res[i]);
		}
	}

}
