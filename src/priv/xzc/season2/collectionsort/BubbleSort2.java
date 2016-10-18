package priv.xzc.season2.collectionsort;

import java.util.Arrays;

/**
 * 最终版本
 * 两个优化：
 * 1.减少交换次数
 * 2.减少趟数
 * 减少趟数---设个变量，当没有交换了就退出循环
 * @author randall
 *
 */
public class BubbleSort2 {

	
	
	
	public static void sort(int[] arr){

		boolean sorted = false; //假设没有交换
		int temp = 0;
		for(int j = arr.length-1; j > 0; j -- ){//减少交换次数
			for (int i = 0; i+1 < j; i++) {
				if (arr[i] > arr[i+1]) {
					temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
					sorted = true;
				}
			}
			if (!sorted) {//没有交换
				break;
			}
		}
		System.out.println(Arrays.toString(arr));

	}
	
}
