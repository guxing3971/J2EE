package JavaSE.数组类;

import java.util.Arrays;

/**
 * 
 * @author 禅师
 * @resume 完成数组的排序功能
 */
public class 排序 {

	public static void main(String[] args) {

		int temp[] = {9,2,5,3,1,8,4,7,6,0};
		
		System.out.println(Arrays.toString(temp));
		
		//对数组进行排序
		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));
	}

}
