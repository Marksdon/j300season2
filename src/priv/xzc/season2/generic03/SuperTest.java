package priv.xzc.season2.generic03;

import java.util.ArrayList;
import java.util.List;

/**
 * super :泛型的上限 >= 即父类或自身
 * 1.一般用于下限操作
 * 2.能添加数据上面，不能添加父类对象
 * 
 * @author randall
 *
 */
public class SuperTest {
	public static void main(String[] args) {
		
		// >= 大于等于，是其本身或者父类
		List<Apple> list = new ArrayList<>();
		test(list);
		List<Fruit> list2 = new ArrayList<>();
		test(list2);
		List<Object> list3 = new ArrayList<>();
		test(list3);
		
		//? super 
		List<? super Apple> list4 = new ArrayList<>();
		test(list4);
		List<? super Fruit> list5 = new ArrayList<>();
		test(list5);
		List<? super Object> list6 = new ArrayList<>();
		test(list6);
		List<?> list7 = new ArrayList<>();
		/*test(list7);*/  //?等同于 ? extends Object
		
	}
	
	
	public static void test(List<? super Apple> list){
		//不能添加父类对象
		list.add(new Apple());
		list.add(new FujiApple());
		/*list.add(new Fruit());*/  //不能添加父类对象
	}
}


