package priv.xzc.season2.compara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections中的sort
 *1.指定比较器comparator
 *  public static <T> void sort(List<T> list, Comparator<? super T> c) {
        list.sort(c);
    }
    
  2.comparable
   public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
    }
 * 
 * @author randall
 *
 */
public class Demo4 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("f");
		list.add("abc");
		list.add("dd");
		list.add("sdf");
		Collections.sort(list, new StringComp());//指定比较器
		System.out.println(list);
		
		
		list.clear();
		list.add("f");
		list.add("abc");
		list.add("dd");
		list.add("sdf");
		Collections.sort(list);
		System.out.println(list);//comparable接口，字符串的比较方式
		
		
		
		
		
	}
}
