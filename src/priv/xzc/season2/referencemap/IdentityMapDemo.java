package priv.xzc.season2.referencemap;

import java.util.IdentityHashMap;

/**
 * IdentityHashMap--键比较地址去重
 * 注意：键是常量池中的字符串 
 * @author Administrator
 *
 */
public class IdentityMapDemo {
	public static void main(String[] args) {
		IdentityHashMap<String, String> map = new IdentityHashMap<>();
		
		//常量池中的“a”
		map.put("a", "a");
		map.put("a", "c");
		System.out.println(map.size());//1 ,应为"a"是常量池中的，凡是常量池中的，存在即获取
		
		map.put(new String("a"), "b");
		map.put(new String("b"), "c");
		
		System.out.println(map.size());
	}
}
