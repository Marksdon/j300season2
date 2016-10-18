package priv.xzc.season2.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试map的用法
 * @author randal
 *
 */
public class MapTest {
	public static void main(String[] args) {
		
		/**
		 * HashMap和 HashTable的关系就像ArrayList和Vector、
		 * StringBuilder和StringBuffer的关系是一样的。
		 */
		
		Map<Object, Object> map = new HashMap<>();
		map.put("谢谢", "小逻辑");
		map.putAll(map);
		System.out.println(map);
		map.remove("龙龙");
		System.out.println(map);
	}
	
	
}
