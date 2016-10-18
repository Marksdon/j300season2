package priv.xzc.season2.generic01;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的入门
 * 1.泛型：标签，泛化类型
 * 2.作用：安全,省心
 * @author randall
 *
 */
public class Simple {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
 
		//安全，放进去很安全，指定了类型，其它类型都放不进去
		list.add("aaa");//类型检查
		//省心，不需要手动强制类型转换，自动就做好了类型转换
		String str = list.get(0);
		
		/**
		 * jdk1.4以前
		 * 如果没有指定泛型，就要先判断类型然后在转换。instance of 
		 */
		List list2 = new ArrayList<>();
		list2.add("sd");
		if (list2.get(0) instanceof String) {//没有指定泛型就要先判断实例
			str = (String) list2.get(0);
		}
		
		
		
	}
}
