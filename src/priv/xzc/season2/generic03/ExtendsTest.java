package priv.xzc.season2.generic03;

import java.util.ArrayList;
import java.util.List;

/**
 * extends 这里时表示泛型的上限 <=  即本身或者子类
 * 1.一般用于限制某个操作
 * 2.不能使用在添加数据上面，一般读取操作
 * 3.规则
 * 	? extends Fruit 的可以加入，List<? extends Frusit>
 * 
 * @author randall
 *
 */
public class ExtendsTest {
	
	public static void main(String[] args) {
		//extends 为上限
		List<?> list = new ArrayList<>();
		
		List<? extends Fruit> list1 = new ArrayList<>();
		test(list1);
		List<Fruit> list2 = new ArrayList<>();
		test(list2);
		List<Apple> list3 = new ArrayList<>();
		test(list3);
		
		//? extends Fruit
		List<? extends Apple> list4 = new ArrayList<Apple>();
		test(list4);
		List<? extends Fruit> list5 = new ArrayList<>();
		test(list5);
		List<?> list6 = new ArrayList<>();
		/*test(list6);*/  //？ 相当与 ? extends Object,不一定时Fruit本身或者其
		
		
		
		
	}

	//? extends Fruit
	public static void test(List<? extends Fruit> list){
		/**
		 * list不能加东西
		 */
		/*list.add(new Apple());*/ //不能加东西
		/*list.add(new FujiApple());*/
		
		/**
		 * 为什么不能加东西呢？
		 * 假设一下，可以加入Apple对象，但是传进来的是Apple的父类就发生问题了
		 * 为了保证向下的兼容性，所以
		 */
	}
	
	
	//泛型类
	class Test<T extends Fruit>{
		
	}
}
