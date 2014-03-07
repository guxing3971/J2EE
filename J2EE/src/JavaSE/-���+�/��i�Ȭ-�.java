package JavaSE.数组类;

import java.util.Arrays;

public class 查找元素 {

	public static void main(String[] args) {
		int temp[] = {9,2,5,3,1,8,4,7,6,0};
		
		System.out.println(Arrays.toString(temp));
		Arrays.sort(temp);
		
		//在使用binarySearch进行检索钱必须多数据进行排序
		int index = Arrays.binarySearch(temp,2);
		System.out.println(" key(2) indexof is :" + (index + 1));
	}

}
