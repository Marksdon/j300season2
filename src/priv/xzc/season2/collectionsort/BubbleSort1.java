package priv.xzc.season2.collectionsort;

import java.util.Arrays;

/**
 * 冒泡算法的第一个版本
 * @author randall
 *
 */
public class BubbleSort1 {


	public static void main(String[] args) {
		int[] arr = {7,45,78,2,79};
		sort(arr);
	}


	public static void sort(int[] arr){

		int temp = 0;
		for(int j = arr.length-1; j > 0; j -- ){//减少交换次数
			for (int i = 0; i+1 < j; i++) {
				if (arr[i] > arr[i+1]) {
					temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));

	}

	
	public static void travel(int[] arr){
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}


