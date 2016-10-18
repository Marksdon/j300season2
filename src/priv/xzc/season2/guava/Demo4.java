package priv.xzc.season2.guava;

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * 集合的操作
 * 1.交集----Sets.intersection(set1, set2)
 * 2.并集----Sets.union(set1, set2)
 * 3.差集---- Sets.difference(set1, set2)
 * -----返回对象均为SetView<T>
 * 
 * Lists好像没有这个
 * 
 * 
 * @author Administrator
 *
 */
public class Demo4 {
	
	public static void main(String[] args) {
		Set<Integer> set1 = Sets.newHashSet(1,2,3,4,5,6);
		Set<Integer> set2 = Sets.newHashSet(3,4,5,6,7,8);
		
		//交集
		System.out.println("交集为：");
		SetView<Integer> intersection = Sets.intersection(set1, set2);
		for (Integer integer : intersection) {
			System.out.println(integer);
		}
		
		//差集
		System.out.println("差集为：");
		SetView<Integer> diff = Sets.difference(set1, set2);
		for (Integer integer : diff) {
			System.out.println(integer);
		}
		
		//并集
		System.out.println("并集为：");
		SetView<Integer> unit = Sets.union(set1, set2);
		System.out.println(unit);
		for (Integer integer : unit) {
			System.out.println(integer);
		}
		
		
		
	
		
		
	}
}
