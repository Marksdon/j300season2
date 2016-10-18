package priv.xzc.season2.collection;

/**
 * 表示一个节点
 * @author randall
 *
 */
public class Node {
	Node previous;//节点类型	
	Object obj;
	Node next;//节点类型

	public Node() {
	}

	public Node(Node previous, Object obj, Node next) {
		super();
		this.previous = previous;
		this.obj = obj;
		this.next = next;
	}



	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}




}
