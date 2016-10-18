package priv.xzc.season2.iter;

import java.util.ArrayList;
import java.util.Iterator;

import javax.sql.rowset.JdbcRowSet;

/**
 * 目标：深入迭代器原理
 * 容器可以创建多个迭代器对象
 * 
 * 只用一次可以改为匿名内部类
 * 
 * 
 * 途径：使用内部类|匿名内部类
 * 
 * foreach使用
 * 
 * 
 * 深入：
 * 1.适应内部类
 * 2.使用Iterable，实现foreach迭代
 * 3.末尾添加元素的方法
 * 
 * @author randall
 *
 */
public class DeepList implements java.lang.Iterable{

	private String[] elem;

	private int size;


	private static final int DEFAULT_CAPACITY = 2;

	public DeepList() {
		this(DEFAULT_CAPACITY);
	}

	public DeepList(int capacity) {
		elem = new String[capacity];
	}

	public int size(){
		return size;
	}

	private class MyIter implements Iterator{
		private int coursor = -1;
		public boolean hasNext(){
			return coursor+1 < size;
		}

		public String next(){
			return elem[++coursor];
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

	
	/**
	 * 匿名内部类
	 * @return
	 */
	public Iterator iterator2(){
		class MyIter implements Iterator{
			private int coursor = -1;
			public boolean hasNext(){
				return coursor+1 < size;
			}

			public String next(){
				return elem[++coursor];
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
		return new MyIter();
	}

	public void add(String e){
		ensureCapacity();
		elem[size++] = e;
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

	
	public Iterator iterator(){
		return new Iterator() {//创建Iterator接口迭代器的实现类的对象
			private int coursor = -1;
			public boolean hasNext(){
				return coursor+1 < size;
			}

			public String next(){
				return elem[++coursor];
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
		DeepList list = new DeepList();
		list.add("sdfd");
		list.add("dfadf");
		Iterator it = list.iterator();//面向接口变成，使用了内部类
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		ArrayList list2 = new ArrayList<>();
		list2.add("asdd");
		list2.add("adf");
		for (Object object : list2) {
			System.out.println(object);
		}
		
		
	}

}

