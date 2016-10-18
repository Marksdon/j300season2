package priv.xzc.season2.compara;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 内置类的排序
 * 1.comparable
 * 2.comparator
 * @author randall
 */
public class Demo3 {
	public static void main(String[] args) {


		String[] arr = {"f","abc","dd","sdf"};
		Utils.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));


		/**
		 * 时间排序
		 */
		Date[] dateArr = new Date[3];

		dateArr[0] = new Date(System.currentTimeMillis()-1000*60*60);
		dateArr[1] = new Date(System.currentTimeMillis()+1000*60*60);
		dateArr[2] = new Date();

		Utils.bubbleSort(dateArr);
		System.out.println(Arrays.toString(dateArr));

		System.out.println("==================list 排序 ===============");

		List<String> list = new ArrayList<>();
		list.add("f");
		list.add("abc");
		list.add("dd");
		list.add("sdf");
		Utils.bubbleSort(list);
		System.out.println(list);
		
		System.out.println("==============Comparator 排序======================");
		String[] strArr = {"a","abc","c","ff","bbb"};
		Utils.bubbleSort(strArr, new StringComp());
		System.out.println(Arrays.toString(strArr));
		
		System.out.println("================List 排序 ============");
		list.clear();
		list.add("f");
		list.add("abc");
		list.add("dd");
		list.add("sdf");
		Utils.bubbleSort(list, new StringComp());
		
		System.out.println(list);

	}
}
