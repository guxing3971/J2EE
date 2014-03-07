package JavaSE.常用类库;

import java.text.NumberFormat;

/**
 * 
 * @author 禅师
 * @resume 根据本机语言环境,格式化大数字显式
 */
public class NumberFormat_1 {

	public static void main(String[] args) {

		NumberFormat dateFormat = null;
		dateFormat = NumberFormat.getInstance();
		System.out.println(dateFormat.format(1000000000));
		System.out.println(dateFormat.format(10000.1234));
	}

}
