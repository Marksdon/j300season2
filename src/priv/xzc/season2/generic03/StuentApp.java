package priv.xzc.season2.generic03;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 泛型的嵌套
 * 洋葱一层层剥开----由外而内
 * @author randall
 *
 */
public class StuentApp {
	public static void main(String[] args) {
		Student<String> stu = new Student<>();
		stu.setScore("优秀");
		
		//泛型嵌套
		Bjsxt<Student<String>> bjsxt = new Bjsxt<>();
		bjsxt.setStu(stu);
		
		stu = bjsxt.getStu();
		String score = stu.getScore();
		System.out.println(score);
		
		/**
		 * 例子，遍历hashMap
		 */
		//HashMap
		Map<String, String> map = new HashMap<>();
		map.put("a", "java300");
		map.put("b", "马士兵javase");
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		for(Entry<String, String> entry: entrySet){
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "---->"+value);
		}
		
	}
}
