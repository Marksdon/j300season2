package priv.xzc.season2.collection;
/**
 * 自定义实现类似的map的功能
 * @author randall
 *
 */
public class MyMap01 {

	Entry[] arr;

	int size;

	public MyMap01() {
		this(16);
	}

	public MyMap01(int capacity) {
		arr = new Entry[16];
	}


	/**
	 * 添加一个键值映射对象
	 * @param key key对象
	 * @param value value对象
	 */
	public void put(Object key, Object value){
		Entry e = new Entry(key, value);
		//如果存在了相同的key,直接替换value属性对象
		for(int i = 0; i < size; i ++){
			if (arr[i].key.equals(key)) {
				arr[i].value = value;
				return;
			}
			
		}
		arr[size++] = e;
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
		for(int i = 0; i < size; i ++){
			if (arr[i].key.equals(key)) {
				return arr[i].value;
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
		for(int i = 0; i < size; i ++){
			if (arr[i].key.equals(key)) {
				return true;
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
			if (arr[i].value.equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	private class Entry{
		Object key;
		Object value;
		public Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

	}
	

	
}
