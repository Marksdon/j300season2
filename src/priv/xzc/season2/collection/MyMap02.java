package priv.xzc.season2.collection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;

import org.junit.validator.ValidateWith;

/**
 * MyMap01还是有bug的，在查找元素是总是要遍历一次，效率很低。
 * 实际上，Map的底层实现是数组+链表
 * 数据结构就是以前学习的hash表的存储方式:
 * [hashCode address] ----(entry object)--()---()
 * [  ] ----()--()-()
 * [  ] ---()-()
 * [  ]
 * @author randall
 *
 */
public class MyMap02 {

	@SuppressWarnings("rawtypes")
	LinkedList[] arr;

	int size;

	public MyMap02() {
		this(16);
	}

	public MyMap02(int capacity) {
		arr = new LinkedList[16];
	}


	/**
	 * 添加一个键值映射对象
	 * @param key key对象
	 * @param value value对象
	 */
	public void put(Object key, Object value){
		Entry e = new Entry(key, value);
		//如果存在了相同的key,直接替换value属性对象
		int a = key.hashCode()%arr.length;
		if (arr[a] == null) {
			LinkedList<Entry> list = new LinkedList<>();
			list.add(e);
			arr[a] = list;
			size ++;
		} else {
			@SuppressWarnings("unchecked")
			LinkedList<Entry> list = arr[a];
			for(int i = 0; i < list.size(); i ++){
				Entry entry = list.get(i);
				if (entry.key.equals(key)) {
					entry.value = value;
					return ;
				}
			}
			list.add(e);
			size ++;
		}

	}


	/**
	 * 每次查找映射对象是都要遍历一次，效率低
	 */

	/**
	 * 通过key对象找到value对象
	 * @param key key对象
	 * @return value对象，如果存在；null，如果不存在该key对象
	 */
	public Object get(Object key){

		//hash可能是负数，控制一下
		int hash = key.hashCode();
		hash = (hash < 0) ? -hash : hash;
		int a = hash%arr.length;
		if (arr[a] == null) {
			return null;
		}
		LinkedList<Entry> list = arr[a];
		//遍历链表
		for(int i = 0; i < list.size(); i ++){
			if (list.get(i).key.equals(key)) {
				return list.get(i).value;
			}
		}
		return null;

	}


	/**
	 * 是否存在该key对象
	 * @param key key对象
	 * @return true,如果存在key对象，否则false
	 */
	public boolean containsKey(Object key){
		int a = key.hashCode()%arr.length;
		if (arr[a] != null) {
			LinkedList<Entry> list = arr[a];
			for(Entry e: list){
				if (e.key.equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 是否存在value对象
	 * @param value value对象
	 * @return true，如果存在，否则false
	 */
	public boolean containsValue(Object value){

		for(int i = 0; i < size; i ++){
			LinkedList<Entry> list = arr[i];
			for(Entry e: list){
				if (e.value.equals(value)) {
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * 删除键值的在map中的映射关系，返回相应的久值
	 * @param key 
	 * @return
	 */
	public Object remove(Object key){
		int hashCode = hashCode(key);
		int a = hashCode % arr.length;
		Object oldValue = null;
		if (arr[a] != null) {
			LinkedList<Entry> list = arr[a];
			for(Entry e: list){
				if(e.key.equals(key)){
					oldValue = e.value;
					list.remove(e);
				}
			}
		}
		return oldValue;
	}


	/**
	 * 
	 * @param key
	 * @return
	 */
	private int hashCode(Object key){
		int hash = key.hashCode();
		hash = (hash < 0) ? -hash : hash;
		return hash;
	}


	private class Entry{
		Object key;
		Object value;
		public Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

	}


	public static void main(String[] args) {

	}


}




