package priv.xzc.season2.generic03;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.泛型没有多态
 * 2.泛型没有数组
 * 3.jdk1.7泛型的简化
 * @author randall
 *
 */
public class Others {

	public static void main(String[] args) {
		Fruit fruit = new Apple();
		
		//泛型没有多态
		/*List<Fruit> list = new ArrayList<Apple>();*/
		
		//泛型没有数组
		/*Fruit<String>[] arr = new Fruit<String>[10];*/
		
		//jdk1.7泛型的简化，这是1.6以及之前编译器不能通过的
		List<Object> list = new ArrayList<>();//后边泛型不用在写
		
		
	}
}
