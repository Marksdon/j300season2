package priv.xzc.season2.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Set的基本用法
 * @author randall
 * 
 */
public class SetTest {
	public static void main(String[] args) {
		Set<Object> set = new HashSet<Object>();
		set.add("aaa");
		set.add(new String("aaa"));
		System.out.println(set.size());
	}
}
