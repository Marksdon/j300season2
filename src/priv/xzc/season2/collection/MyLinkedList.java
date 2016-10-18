package priv.xzc.season2.collection;

import java.util.LinkedList;

public class MyLinkedList {
	private Node first;
	private Node last;

	private int size;

	public void add(Object obj){
		Node n = new Node();//生成节点对象
		if (first == null) {
			n.setPrevious(null);//设置节点属性
			n.setObj(obj);
			n.setNext(null);	
			first = n;//设置链表指针
			last = n;
		} else {
			//直接往last节点增加新的节点
			n.setPrevious(last);//设置节点属性
			n.setObj(obj);
			n.setNext(null);
			last.setNext(n);
			last = n;
		}
		size ++;
	}


	public void add(int index, Object obj){
		rangeCheck(index);
		Node temp = node(index);//获取index位置的节点对象
		Node newNode = new Node();//生产新节点对象
		newNode.setObj(obj);//设置节点数据属性
		if (temp != null) {
			Node up = temp.previous;//获取前节点对象
			//重新设定指针
			newNode.setPrevious(up);
			up.next = newNode;

			newNode.next = temp;
			temp.previous = newNode;

			size ++;
		}
	}



	public int size(){
		return size;
	}


	public Object get(int index){
		Node temp = node(index);
		return temp.obj;//返回的不是节点，而是节点内的元素

	}


	/**
	 * 
	 * @param index
	 * @param obj
	 * @return
	 */
	public Object set(int index, Object obj){
		rangeCheck(index);
		Node oldValue = node(index);
		node(index).obj = obj;
		return oldValue;
	}

	public void remove(int index){
		Node temp = node(index);
		if (temp != null) {
			Node up = temp.previous;
			Node down = temp.next;
			up.next = down;
			down.previous = up;
			size --;
			temp = null;

		}
	}


	/**
	 * Gets element of the specified position
	 * @param index
	 * @return
	 */
	private Node node(int index){
		rangeCheck(index);
		Node temp = null;
		if (first != null) {
			temp = first;
			for(int i = 0; i < index; i ++){
				temp = temp.next;
			}
		}
		return temp;
	}

	/**
	 * 改进版本的获取index位置的节点对象，遍历的算法
	 * @param index
	 * @return (0,1,2,3,4,5)
	 */
	private Node node1(int index){
		rangeCheck(index);
		Node temp = null;
		if (index < (size >> 1)) {
			temp = first;
			for(int i = 0; i < index; i ++){
				temp = temp.next;
			}
		} else {
			temp = last;
			for(int i = size-1; i > index; i --){
				temp = temp.previous;
			}
		}
		return temp;
	}




	/**
	 * Checks if out of bound of the list
	 * @param index
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


	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		LinkedList<Object> list2 = new LinkedList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");

		list.add(1,"kkk");
		System.out.println(list.get(1));
		System.out.println(list.size);

	}
}
