package priv.xzc.season2.iter;

import java.util.Iterator;

/**
 * 目标：使用泛型，可以操纵多个类型
 * 	
 * @author randall
 *
 */
public class SxtArrayList<E> implements java.lang.Iterable<E>{

	//没有泛型数组，所用使用object
	private Object[] elem;

	private int size;


	private static final int DEFAULT_CAPACITY = 2;

	public SxtArrayList() {
		this(DEFAULT_CAPACITY);
	}

	public SxtArrayList(int capacity) {
		elem = new Object[capacity];
	}

	public int size(){
		return size;
	}

	private class MyIter<E> implements Iterator<E>{
		private int coursor = -1;
		public boolean hasNext(){
			return coursor+1 < size;
		}

		public E next(){
			return (E)elem[++coursor];
		}

		/**
		 * 数组的拷贝
		 */
		public void remove(){
			System.arraycopy(elem, coursor+1,
					elem, coursor, size-(coursor+1));
			size--;
			coursor--;
		}
	}


	/**
	 * 提供创建内部类MyIter对象的方法
	 * @return
	 */
//	public Iterator iterator(){
//		return new MyIter();
//	}


	public boolean add(E e){
		ensureCapacity();
		elem[size++] = e;
		return true;
	}

	/**
	 * 确保数组容量，如果容量不足就扩容
	 */
	private void ensureCapacity(){
		if (size == elem.length) {
			String[] newElem = new String[size*2+1];
			System.arraycopy(elem, 0, newElem, 0, size);
			elem = newElem;
		}
	}

	
	public Iterator<E> iterator(){
		return new Iterator<E>() {//创建Iterator接口迭代器的实现类的对象
			private int coursor = -1;
			public boolean hasNext(){
				return coursor+1 < size;
			}

			public E next(){
				return (E)elem[++coursor];
			}

			/**
			 * 数组的拷贝
			 */
			public void remove(){
				System.arraycopy(elem, coursor+1,
						elem, coursor, size-(coursor+1));
				size--;
				coursor--;
			}
			
		};
	}
	

	public static void main(String[] args) {
		SxtArrayList<Integer> list = new SxtArrayList<>();
		list.add(23);
		list.add(343);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		System.out.println("----------------------");
		SxtArrayList<String> list2 = new SxtArrayList<>();
		list2.add("马云");
		list2.add("马化腾");
		list2.add("马士兵");
		Iterator<String> it = list2.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	
	}

}

