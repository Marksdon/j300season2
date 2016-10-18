package priv.xzc.season2.iter;

/**
 * 目标：理解迭代器的原理
 * 迭代器： 遍历使用
 * 迭代器就三个方法：
 * hasNext()
 * next()
 * remove()
 * 
 * 迭代器只能使用一次，一个对象属性只有一份，就只能使用一次
 * @author randall
 *
 */
public class SimpleList {
	//数组存储
	private String[] elem = {"a","b","c"};

	//大小
	private int size = elem.length;


	private int coursor = -1;

	public int size(){
		return size;
	}
	
	public boolean hasNext(){
		return coursor+1<size;
	}

	
	public String next(){
		coursor ++;
		return elem[coursor];
	}

	
	/**
	 * 实际上就是数组的拷贝
	 */
	public void remove(){
		System.arraycopy(elem, coursor+1, 
				elem, coursor, size-(coursor+1));
		size --;
		coursor--;//游标回退一个
	}


	public static void main(String[] args) {
		SimpleList list = new SimpleList();
		while(list.hasNext()){
			System.out.println(list.next());
		}
	}
}

