package priv.com.season2.syncread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 容器的只读控制
 * 
 * @author Administrator
 *
 */
public class ReadOnlyTest {
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("aaa", "bbb");
		map.put("bbb", "ccc");

		//只读控制
//		Map<String, String> readOnlyMap = Collections.unmodifiableMap(map);
//		readOnlyMap.put("ccc", "ddd");//不被支持的操作，跑出异常

		//一个元素的不变容器测试

		List<String> onlyOneList = Collections.singletonList(new String());
		onlyOneList.add("aaa");
	}
	
	//空的不可变集合
	@SuppressWarnings("unchecked")
	public static Set<String> oper(Set<String> set){
		
		if (set == null) {
			return Collections.EMPTY_SET;//可以避免空指针
		}
		return set;
	}
	
}
