package priv.xzc.season2.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 分拣存储
 * 统计单词出现的次数
 * 思路：
 * 1.分割字符串
 * 2.分拣存储
 * 3.按要求查看 单词出现的次数
 *  
 * @author randall
 *
 */
public class MapDemo01 {

	public static void main(String[] args) {

		String[] arr = "this a cat and that is a mice and where is ".split(" ");

		/**
		 * 写法1
		 */
		Map<String, Integer> map = new HashMap<>();
		for (String key : arr) {
			//先遍历看看，然后在处理逻辑
			if (!map.containsKey(key)) {//查看是否存储
				map.put(key, 1);
			} else {
				map.put(key, map.get(key)+1);
			}

		}
		System.out.println(map);

		Set<String> keySet = map.keySet();
		//获取迭代器对象
		Iterator<String> it = keySet.iterator();

		while (it.hasNext()) {//判断
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key + "---->" + value); 
		}


		/**
		 * 写法2
		 */
		for (String key : keySet) {
			Integer value = map.get(key);
			if (null == value) {//不存在
				map.put(key, 1);
			} else {
				map.put(key, value+1);
			}
		}

	}
}
