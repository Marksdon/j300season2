package priv.xzc.season2.collection;

/**
 * 自己定义ArrayList
 * @author randall
 *
 */
public class MyArrayList<E> {

	private static final int DEFAULT_CAPACITY = 10;

	/**
	 * The array buffer into which the elements of the ArrayList are stored.
	 * The capacity of the ArrayList is the length of this array buffer. Any
	 * empty ArrayList with elementData == EMPTY_ELEMENTDATA will be expanded to
	 * DEFAULT_CAPACITY when the first element is added.
	 */
	private Object[] elementDate;

	/**
	 * The size of the ArrayList (the number of elements it contains).
	 *
	 */
	private int size;

	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructs an empty list with the specified initial capacity.
	 *
	 * @param  capacity  the initial capacity of the list
	 */
	public MyArrayList(int capacity) {
		elementDate = new Object[capacity];
	}


	/**
	 * the number of element in this list
	 * @return the number of element in this list
	 */
	public int size(){
		return size;
	}


	/**
	 * Checks out if ths list is empty
	 * @return true if this list is with no element, otherwise false
	 */
	public boolean isEmpty(){
		return size == 0;
	}


	public void add(E element){
		//扩容
		ensureCapacity();
		elementDate[size++] = element;
	}


	/**
	 * Inserts the specified element at the specified position in this
	 * list. Shifts the element currently at that position (if any) and
	 * any subsequent elements to the right (adds one to their indices).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param obj element to be inserted
	 */
	public void add(int index, E element){
		rangeCheckForAdd(index);
		ensureCapacity();
		System.arraycopy(elementDate,
				index, elementDate, index+1, size-index);
		elementDate[index] = element;
		size ++;
	}


	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param  index index of the element to return
	 * @return the element at the specified position in this list
	 */
	@SuppressWarnings("unchecked")
	public E get(int index){
		rangeCheck(index);
		return (E)elementDate[index];
	}

	/**
	 * Checks if the given index is in range.  If not, throws an appropriate
	 * runtime exception.  This method does *not* check if the index is
	 * negative: It is always used immediately prior to an array access,
	 * which throws an ArrayIndexOutOfBoundsException if index is negative.
	 */
	private void rangeCheck(int index){
		if (index < 0 || index >= size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * Checks out the {@code index} if is valid in this list
	 * @param index the specified position in the list
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



	/**
	 * Replaces the element at the specified position in this list with
	 * the specified element.
	 *
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 */
	@SuppressWarnings("unchecked")
	public E set(int index, E element){
		rangeCheck(index);
		Object oldValue = elementDate[index];
		elementDate[index] = element;
		return (E)oldValue;

	}


	/**
	 * Removes the element at the specified position in this list.
	 * Shifts any subsequent elements to the left (subtracts one from their
	 * indices).
	 *
	 * @param index the index of the element to be removed
	 * @return the element that was removed from the list
	 */
	@SuppressWarnings("unchecked")
	public E remove(int index){
		rangeCheck(index);
		Object oldValue = elementDate[index];

		int numMoved = size - index - 1;
		if (numMoved > 0){
			System.arraycopy(elementDate, index+1,
					elementDate, index, numMoved);
		}
		size --;
		return (E)oldValue;		
	}


	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 * More formally, returns the lowest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
	 * or -1 if there is no such index.
	 */
	public int indexOf(Object obj){
		if (obj == null) {
			for(int i = 0; i < size; i ++){
				if (null == elementDate[i]) {
					return i;
				}
			}
		} else {
			for(int i = 0; i < size; i ++){
				if (obj.equals(elementDate[i])) {
					return i;
				}
			}
		}
		return -1;

	}



	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * More formally, returns <tt>true</tt> if and only if this list contains
	 * at least one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 *
	 * @param o element whose presence in this list is to be tested
	 * @return <tt>true</tt> if this list contains the specified element
	 */
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	/**
	 * Removes all of the elements from this list.  The list will
	 * be empty after this call returns.
	 */
	public void clear(){
		for(int i = 0; i < size; i ++){
			elementDate[i] = null; //GC do its work
		}
		size = 0;
	}


	/**
	 * ensure the capacity of the list is enough to contain the element
	 */
	private void ensureCapacity(){
		if (size == elementDate.length) {
			Object[] newElemData = new Object[size*2+1];
			System.arraycopy(elementDate, 0, newElemData, 0, size);
			elementDate = newElemData;
		}
	}



}
