package priv.xzc.season2.compara;

import java.util.Comparator;
import java.util.List;

public class Utils {

	/**
	 *List排序使用 comparator 
	 */
	@SuppressWarnings("unchecked")
	public static <T> void bubbleSort(List<T> list,
			Comparator<T> com ){
		//第一步，容器转换成为数组
		Object[] arr = list.toArray();
		bubbleSort(arr, com);
		//相继改变容器的值
		for(int i = 0 ; i < arr.length; i ++){
			list.set(i, (T)arr[i]);
		}
	}
	
	
	/**
	 * 使用Comparator
	 * 
	 * 升序排序
	 * @param arr
	 */
	@SuppressWarnings("unchecked")
	public static <T> void bubbleSort(Object [] arr, Comparator<T> com){
		boolean sorted = false;
		Object temp = null;
		for(int i = arr.length; i > 0; i -- ){
			for(int j = 0; j+1 < i ; j ++){
				if (com.compare((T)arr[j], (T)arr[j+1]) > 0) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					sorted = true;
				}
			}
			if (!sorted) {
				break;
			}

		}

	}
	
	
	

	
	
	/**
	 * 重载的，优先使用泛型方法
	 */
	
	/**
	 * 容器排序
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void bubbleSort(List<T> list){
		//第一步，容器转换成为数组
		Object[] arr = list.toArray();
		bubbleSort(arr);
		//相继改变容器的值
		for(int i = 0 ; i < arr.length; i ++){
			list.set(i, (T)arr[i]);
		}
	}
	
	
	
	/**
	 * 泛型的数组排序
	 */
	public static <T extends Comparable<T>> void bubbleSort(T [] arr){
		boolean sorted = false;
		T temp = null;
		for(int i = arr.length; i > 0; i -- ){
			for(int j = 0; j+1 < i ; j ++){
				if (((Comparable)arr[j]).compareTo(arr[j+1]) > 0) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					sorted = true;
				}
			}
			if (!sorted) {
				break;
			}

		}

	}
	
	
	
	/**
	 * 升序排序
	 * @param arr
	 */
	public static void bubbleSort(Object [] arr){
		boolean sorted = false;
		Object temp = null;
		for(int i = arr.length; i > 0; i -- ){
			for(int j = 0; j+1 < i ; j ++){
				if (((Comparable)arr[j]).compareTo(arr[j+1]) > 0) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					sorted = true;
				}
			}
			if (!sorted) {
				break;
			}

		}

	}
	
	
}
