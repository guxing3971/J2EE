package JavaSE.常用类库;

import java.util.Random;

/**
 * 
 * @author 禅师
 * @resume	产生随机数
 */
public class Random_1 {

	public static void main(String[] args) {
		
		//产生10个0到100之间的随机数
		Random rand = new Random();
		for(int i=0; i < 10;i++){
			System.out.print(rand.nextInt(100) + "  ");
		}

	}

}
