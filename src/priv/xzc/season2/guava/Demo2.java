package priv.xzc.season2.guava;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 函数式编程
 * 好处：解耦
 * 1.Predicate
 * 	
 * 2.Function
 * 
 * 工具：
 * Collections2.filter(list, Predicate)看成个过滤器
 * Collections2.transform(list, f);//转换
 * Functions.compose(f1, f2);//组合式函数编程
 * @author Administrator
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		//组合式函数编程
		//确保容器中的字符串元素长度不超过5，超过截取，全部大写
		List<String> list = Lists.newArrayList("bjsxt","good","happiness");

		//确保容器中的字符串长度不超过5，超过截取
		Function<String, String> f1 = new Function<String, String>() {
			@Override
			public String apply(String input) {
				return input.length() > 5 ? input.substring(0,5) : input;
			}
		};

		//转成大写
		Function<String, String> f2 = new Function<String, String>() {

			@Override
			public String apply(String input) {
				return input.toUpperCase();
			}
		};

		//		String = f2(f1(String))

		Function<String, String> f = Functions.compose(f1, f2);
		Collection<String> resultList = Collections2.transform(list, f);

		for (String string : resultList) {
			System.out.println(string);
		}
	}


	/**
	 * 类型转换
	 */
	public static void test2(){

		//类型转换
		Set<Long> timeSet = Sets.newHashSet();
		timeSet.add(99999999L);
		timeSet.add(34343L);
		timeSet.add(987987987798L);

		Collection<String> timeStrCol = Collections2.transform(timeSet, new Function<Long, String>() {

			/**
			 * 重写的时候不能降低权限
			 */
			@Override
			public String apply(Long arg0) {
				return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(arg0);
			}
		});

		for (String string : timeStrCol) {
			System.out.println(string);
		}
	}


	/**
	 * 过滤器
	 */
	public static void test1(){
		//创建List，静态初始化
		List<String> list = Lists.newArrayList("moon","son","dad","bjsxt","refer");

		//找出回文  顺着读和倒着读都是一样的 back words ,mirror words
		/**
		 * 使用匿名内部类
		 * 类和对象只使用一次
		 */
		Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				//业务逻辑
				return new StringBuilder(input)
						.reverse().toString().equals(input);
			}
		});  
		//遍历
		for (String temp : palindromeList) {
			System.out.println(temp);
		}
	}

	
	public static void testFilter(){
		//创建Set,静态初始化
		Set<String> set = Sets.newHashSet("aaa","bdfs","cdfsdfv");

		//找出回文  顺着读和倒着读都是一样的 back words ,mirror words
		/**
		 * 往collection灌入数据
		 * 使用匿名内部类
		 */
		Collection<String> collection = Collections2.filter(set, new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return new StringBuffer(input).reverse().toString().equals(input);
			}
		});

		//遍历collection
		for (String temp : collection) {
			System.out.println(temp);
		}

	}

}
