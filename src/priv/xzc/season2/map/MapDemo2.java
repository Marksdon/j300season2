package priv.xzc.season2.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 分拣存储
 * 统计单词出现的次数
 * 思路：
 * 1.分割字符串
 * 2.分拣存储
 * 3.按要求查看 单词出现的次数
 * 4.加入面向对象
 *  
 * @author randall
 *
 */
public class MapDemo2 {

	public static void main(String[] args) {

		String[] arr = "this a cat and that is a mice and where is ".split(" ");


		Map<String, Letter> map = new HashMap<>();

		for (String key : arr) {
			if (!map.containsKey(key)) {
				map.put(key, new Letter(key));
			}
			//获取具体的袋子
			Letter value = map.get(key);
			value.setCount(value.getCount()+1);
		}

	}
}
