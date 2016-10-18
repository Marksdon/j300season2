package priv.xzc.season2.collection;

import java.util.HashMap;

/**
 * 自己实现个HashSet
 * @author randall
 *
 */
public class MyHashSet {
	
	HashMap<Object, Object> map;
	
	private static final Object PRESENT = new Object();
	
	public MyHashSet() {
		map = new HashMap<>();
	}
	
	/**
	 * 获取set包含的元素的个数
	 * @return 当前set对象包含元素的个数
	 */
	public int size(){
		return map.size();
	}
	
	  /**
     * Returns <tt>true</tt> if this set contains no elements.
     *
     * @return <tt>true</tt> if this set contains no elements
     */
	public boolean isEmpty(){
		return map.isEmpty();
	}
	
	/**
	 * 向set中添加某个元素{@code obj},如果set中已经存在该元素即返回false否则为true
	 * @param obj element to be added to this set
	 * @return false if the element already exists in this set,
	 * otherwise , true; 
	 */
	public boolean add(Object obj){
		return map.put(obj, PRESENT) == null;
	}
	
	
	public boolean contains(Object obj){
		return map.containsKey(obj);
	}
	
	
	
}
