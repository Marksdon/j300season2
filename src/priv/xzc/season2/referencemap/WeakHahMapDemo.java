package priv.xzc.season2.referencemap;

import java.util.WeakHashMap;

/**
 * WeakHashMapDemo
 * 键为弱类型，gc运行立即回收
 * @author Administrator
 *
 */
public class WeakHahMapDemo {

	public static void main(String[] args) {
		WeakHashMap<String, String> map = new WeakHashMap<>();
		//测试数据
		map.put("a", "aaa");
		map.put("a", "bbb");
		map.put(new String("a"), "a");
		map.put(new String("b"), "b");
		
		//通知回收
		System.gc();
		System.runFinalization();
		
		System.out.println(map.size());
		
	}
}
