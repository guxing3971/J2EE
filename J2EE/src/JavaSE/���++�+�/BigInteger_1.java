package JavaSE.常用类库;

import java.math.BigInteger;

/**
 * 
 * @author 禅师
 * @resume 用于完成超大数据的运算
 */
public class BigInteger_1 {

	public static void main(String[] args) {

		BigInteger big1 = new BigInteger("1234567890");
		BigInteger big2 = new BigInteger("9876543210");
		
		System.out.println("超大数据相加 :"+big1.add(big2));
		System.out.println("超大数据相减 :"+big1.subtract(big2));
		System.out.println("超大数据相乘 :"+big1.multiply(big2));
		System.out.println("超大数据相除 :"+big1.divide(big2));
		
		//求余数
		BigInteger res[] = big2.divideAndRemainder(big1) ;
		System.out.println("商:"+res[0] +"余数:"+res[1]);
	}
	

}
