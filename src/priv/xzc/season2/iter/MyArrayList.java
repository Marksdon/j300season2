package priv.xzc.season2.iter;

import java.util.Iterator;

/**
 * 深入练习iterator
 * @author randall
 *
 */
public class MyArrayList<E> implements Iterable<E> {

	
	private Object[] element;
	
	private int size;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	
	public MyArrayList(int capacitye){
		element = new Object[capacitye];
	}
	
	public int size(){
		return size;
	}
	
	
	/**
	 * 往这个表里添加一个元素
	 * @param e 元素
	 * @return 是否添加成功
	 */
	public boolean add(E e){
		ensureCapacity();
		element[size++] = e;
		return true;
	}
	
	
	/**
	 * 确保存储数组的容量可用，如果容量不够了，就扩容
	 */
	private void ensureCapacity(){
		if (size == element.length) {
			Object[] newElement = new Object[size*2 + 1];
			System.arraycopy(element, 0, newElement, 0, size);
			element = newElement;
		}
	}
	
	/**
	 * 匿名内部类
	 */
	@Override
	public Iterator<E> iterator() {//创建Iterator接口迭代器的实现类的对象
		return new Iterator<E>(){
			private int coursor = -1;
			
			public boolean hasNext(){
				return coursor+1 < size;
			}

			@SuppressWarnings("unchecked")
			public E next(){
				return (E)element[++coursor];
			}
			
			/**
			 * 实际上就是数组的移动
			 */
			public void remove(){
				System.arraycopy(element, 
					coursor+1, element, coursor, size-(coursor+1));
				size --;
				coursor --;
			}
		};
	}	
	
	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>();
		list.add("asdfsd");
		list.add("sdfsd");
		System.out.println(list.size());
		
		for (String string : list) {
			System.out.println(string);
		}
		
	}
	
	
}	
