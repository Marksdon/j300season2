package priv.xzc.season2.guava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 查看教师交的每门课程
 * Multimap<T1, T2>---键是无序可重复的
 * 
 * 
 * @author randall
 *
 */
public class Demo6 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		//加入测试数据
		map.put("改革开放", "邓爷爷");
		map.put("三个代表", "江主席");
		map.put("科学发展观", "胡主席");
		map.put("八荣八耻", "胡主席");
		map.put("中国梦", "习主席");
		
		//
		Multimap<String, String> multimap = ArrayListMultimap.create();
		
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			String key = entry.getKey();//课程
			String value = entry.getValue();//老师
			multimap.put(value, key);//对调一下
			
		}
		
		//查看multimap
		Set<String> set = multimap.keySet();
		for (String key : set) {
			Collection<String> collection = multimap.get(key);
			System.out.println(key + "-->"+ collection);
		}
		
		
	}
}
