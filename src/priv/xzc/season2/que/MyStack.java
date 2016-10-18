package priv.xzc.season2.que;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 自定义堆栈
 * 1.压栈
 * 2.弹栈
 * 3.获取头
 * @author Administrator
 *
 */
public class MyStack<E> {

	//容器
	private Deque<E> deque; 
	
	//容量
	private int capacity;
	//构造器
	public MyStack() {
		this(16);
		deque = new ArrayDeque<>();
	}
	public MyStack(int capacity) {
		this.capacity = capacity;
		deque = new ArrayDeque<>(capacity);
	}
	
	
	//进栈 
	public boolean push(E e){
		if (deque.size() + 1 > capacity) {
			return false;
		} else {
			return deque.offerLast(e);
		}
	}
	
	//出栈
	public E pop(){
		return deque.pollLast();
	}
	
	//获取头
	public E peek(){
		return deque.peekLast();
	}
	
	
	/**
	 * 元素大小
	 * @return
	 */
	public int size(){
		return capacity;
	}
	
	
	
	
}
