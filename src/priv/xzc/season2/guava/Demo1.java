package priv.xzc.season2.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * 只读设置
 * 对比JDK的java.uitl.Collections.unmodifiableXxx()
 * 和guava的ImmutableXxx.of()
 * @author randall
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("aa");
		set.add("bb");

		Set<String> readOnlySet = Collections.unmodifiableSet(set);
		readOnlySet.add("kkk");//java.lang.UnsupportedOperationException
		
		
		ImmutableSet<String> immutableSet = ImmutableSet.of("a","b");
		immutableSet.add("aa");//java.lang.UnsupportedOperationException
		
	}

	/**
	 * 对比JDK与guava对集合的只读操作
	 */
	public static void testReadOnlyList(){
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		//只读设置，这只是个视图，快照，当原有的list发生变动是，视图也是跟着该表，所以不够安全
		List<String> readOnlyList = Collections.unmodifiableList(list);
		System.out.println(readOnlyList);
		list.add("c");
		System.out.println(readOnlyList);

		/**
		 * 用guava 提供的ImmutableList，只读设置，安全
		 * 代码少
		 */
		List<String> immutableList = ImmutableList.of("a","b","c");
		immutableList.add("kkk");
		System.out.println(immutableList);
	}

}
