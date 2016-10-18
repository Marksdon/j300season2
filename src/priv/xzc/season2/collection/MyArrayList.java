package priv.xzc.season2.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 自定义实现ArrayList
 * @author randall
 *
 */
public class MyArrayList {

	List<Object> list = new ArrayList<>();
	
	/**
	 * The array buffer into which the elements of the ArrayList are stored.
	 * The capacity of the ArrayList is the length of this array buffer. Any
	 * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
	 * will be expanded to DEFAULT_CAPACITY when the first element is added.
	 */
	transient Object[] elementData;

	/**
	 * The size of the ArrayList (the number of elements it contains).
	 */
	private int size;


	public MyArrayList() {
		this(10);
	}

	/**
	 * 初始化这个ArrayList对象，默认长度为10
	 * @param capacity
	 */
	public MyArrayList(int capacity) {

		if (capacity < 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.elementData = new Object[capacity];

	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the number of elements in this list
	 */
	public int size(){
		return size;
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 *
	 * @return <tt>true</tt> if this list contains no elements
	 */
	public boolean isEmpty(){
		return size == 0;
	}


	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param e element to be appended to this list
	 * @return <tt>true</tt> (as specified by {@link Collection#add})
	 */
	public void add(Object obj){
		ensureCapacity(size);
		elementData[size ++] =  obj;
	}

	/**
	 * Inserts the specified element at the specified position in this
	 * list. Shifts the element currently at that position (if any) and
	 * any subsequent elements to the right (adds one to their indices).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 */
	public void add(int index, Object obj){
		rangeCheckForAdd(index);
		Object[] newElementData = new Object[size+1];
		System.arraycopy(elementData, index, newElementData, 
				index+1, size-index);
		elementData = newElementData;
		elementData[index] = obj; 
		size ++;
	}

	/**
	 * 
	 * Returns the element at the specified position in this list.
	 *
	 * @param  index index of the element to return
	 * @return the element at the specified position in this list
	 */
	public Object get(int index){
		rangeCheck(index);
		return elementData[index];
	}

	/**
	 * Replaces the element at the specified position in this list
	 * with the specified element
	 * @param index index of the element to replace
	 * @param obj element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws throw a exception if {@code index} is invalid in this list
	 */
	public Object set(int index, Object obj){
		rangeCheck(index);
		Object oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue;
	}


	/**
	 * Removes the element at the specified position in this list.
	 * Shifts any subsequent elements to the left (subtracts one from their
	 * indices).
	 *
	 * @param index the index of the element to be removed
	 * @return the element that was removed from the list
	 */
	public Object remove(int index){
		//删除指定位置的对象
		rangeCheck(index);
		/**
		 * 其实也是数组的拷贝
		 */
		Object oldValue = elementData[index];
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index+1, elementData, 
					index, numMoved);
		}
		//移出后，最后一个格子不要了
		elementData[--size] = null;// clear to let GC do its work
		return oldValue;
	}


	/**
	 * Removes the first occurrence of the specified element from this list,
     * if it is present. 
	 * @param obj element to be removed from this list, if present
	 * @return <tt>true</tt> if this list contained the specified element
	 */
	public boolean remove(Object obj){
		if (obj == null) {
			for(int i = 0; i < size; i ++){
				if (get(i) == null) {
					remove(i);
					return true;
				}
			}
		} else {
			for(int i = 0; i < size; i ++){
				if (get(i).equals(obj)) {
					remove(i);
					return true;
				}
			}
		}
		return false;

	}

	
	/**
	 * 
	 * @param index
	 */
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	private void ensureCapacity(int size){
		if (size == elementData.length) {
			/**
			 * 数组扩容,数组是定了的，扩容实际上就是弄个新的更大的篮子，
			 * 然后把原来的苹果放到新的篮子，在替换原来的篮子
			 */
			Object[] newElementData = new Object[size*2+1];
			//搬移水果
			System.arraycopy(elementData, 0,
					newElementData, 0, elementData.length);
			elementData = newElementData;//替换篮子
		}
	}


	/**
	 * A version of rangeCheck used by add and addAll.
	 */
	private void rangeCheckForAdd(int index){
		if (index < 0 || index > size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}




	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(2);
		list.add("aaa");
		list.add("bbb");

		System.out.println(list.size);
		list.remove(0);
		list.remove(0);
		System.out.println(list.size);

	}



}
