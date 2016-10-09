package priv.xzc.season2.collection;

public class MyLinkedList {
	
	
	private Node first;// 首节点
	private Node last; // 尾节点
	private int size; //链表元素数

	
	public MyLinkedList() {
		first = last;
	}
	
	/**
	 *  Returns the number of elements in this list.
	 * @return the number of elements in this list
	 */
	public int size(){
		return size;
	}
	
	
	/**
	 * Returns if this list is empty
	 * @return true if list is empty,otherwise false
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	
	
	/**
	 * Appends the specified element to the end of this list.
	 * @param obj
	 */
	public void add(Object obj){
		Node newNode = new Node();
		if (last == null) {
			newNode.prev = null;
			newNode.next = newNode;
			first = newNode;
			last = newNode;
		} else {
			newNode.prev = last;
			newNode.next = null;
			last.next = newNode;
			last = newNode;
		}
		size ++;
	}
	
	
	/**
	 * Inserts the specified element at the beginning of this list.
	 * @param obj 
	 */
	public void addFirst(Object obj){
		Node newNode = new Node();
		if (last == null) {
			newNode.prev = null;
			newNode.next = newNode;
			first = newNode;
			last = newNode;
		} else {
			newNode.prev = null;
			newNode.next = first;
			first.prev = newNode;
			first = newNode;
		}
		size ++;
	}
	
	
	
	/**
	 * =============================
	 */
	
	/**
	 * never implement
	 * @param index 
	 * @param obj
	 */
	public void add(int index , Object obj){
		
		rangeCheck(index);
		
		Node temp = null;
		
		if ( index < (size >> 1)) {
			temp = first;
			for(int i = 0; i < index; i ++){
				temp = temp.next;
			}
		} else {
			temp = last;
			for(int i = 0; i < index; i ++){
				temp = temp.prev;
			}
		}
		
		
		Node nextNode = temp.next; 
		Node newNode = new Node();
		newNode.item = obj;
		newNode.prev = temp;
		temp.next = newNode;
		
		newNode.next = nextNode;
		nextNode.prev = newNode;
		
		if (temp.next == null) {// last node
			last = newNode;
		}
		
	}
	
	
	/**
	 * Checks out if the index is valid in this list
	 * @param index the position in this list
	 */
	private void rangeCheck(int index){
		
		if (index > size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	private static class Node{
		Object item;
		Node prev;
		Node next;
		
		public Node() {
		}
		
		public Node(Object item, Node prev, Node next) {
			super();
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	
		
	}
	
}
