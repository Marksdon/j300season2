package priv.com.season2.syncread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 制作同步容器（容器的同步控制）
 * 使用Collections的sychronied某某某
 * Collections.synchronizedXxx();包装一下即可
 * 		Collections.synchronizedList(list)
 * 		Collections.synchronizedMap(map);
 * 		Collections.synchronizedSet(s)
 * @author randall
 *
 */
public class SychronizedCollectionTest {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "bbb");
		map.put("bbb", "ccc");
		Map<String, String> synchrMap = Collections.synchronizedMap(map);
		System.out.println(synchrMap);
		
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		List<String> synchrList = Collections.synchronizedList(list);
		System.out.println(synchrList);
		
		Set<String> set = new HashSet<>();
		set.add("aaa");
		set.add("bbb");
		Set<String> synchrSet = Collections.synchronizedSet(set);
		System.out.println(synchrSet);
		
	}
}
