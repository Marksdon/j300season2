package priv.xzc.season2.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

/**
 * list基本用法
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList<>();
		//ArrayList：底层实现是数组，所以查询快。修改，插入，删除慢。
		//LinkedList:底层失效是链表，线程不安全效率高。所以查询慢，修改删除慢
		//Vector：线程安全，效率低。
		
		list.add("aaa");
		list.add(new Date());
		list.add(123);//自动装箱，拆箱
		
		List lis2 = new ArrayList<>();
		lis2.add("bbb");
		lis2.add("ccc");
		
		list.add(lis2);
		System.out.println(list.size());
	}
	
	
	@Test
	public void testMapping(){
		List<Dog> list = new ArrayList<>();
		Dog dog = new Dog();
		dog.name = "v";
		dog.eye = "red";
		
		list.add(dog);
		
		Dog dog2 = list.get(0);
		dog2.name = "k";
		
		System.out.println(dog.name);
		System.out.println(list.get(0).name);
		
		
	}
	
	private class Dog{
		private String name;
		private String eye;
	}
	
	@Test
	public void testPrintArr(){
		int[] arr = {9,0,7,2,23};
		System.out.println(Arrays.toString(arr));
	}
	
}
