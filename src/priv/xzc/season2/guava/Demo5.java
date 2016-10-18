package priv.xzc.season2.guava;

import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * 统计单词:分拣存储+面向对象--之前
 * 现在使用guava的
 * 
 * HashMultiset ---无序可重复
 * 
 * 
 * 
 * @author randall
 *
 */
public class Demo5 {

	public static void main(String[] args) {
		//数据
		String str = "this is a cat and that is a mice where is the food";
		//分割字符串
		//一种方式
		/*StringTokenizer tokenizer = new StringTokenizer(str);
		while(tokenizer.hasMoreTokens()){
			System.out.println(tokenizer.nextToken());
		}*/
		String[] strArr = str.split(" ");
		
		//存储到Mult
		Multiset<String> multiset = HashMultiset.create();
		for (String string : strArr) {
			multiset.add(string);
		}
		
		//获取所有单词
		Set<String> set = multiset.elementSet();
		for (String string : set) {
			System.out.println(string + "---->" + multiset.count(string));
		}
	}
}
