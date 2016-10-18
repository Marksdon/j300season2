package priv.xzc.season2.generic03;

import java.util.ArrayList;
import java.util.List;

/**
 * ? --->通配符，类型不确定，用于声明变量|形参上
 * 不能用在：
 * 创建对象
 * 创建泛型类、方法、接口
 * @author randall
 *
 */
public class WildcardsTest {
	public static void main(String[] args) {
		//声明,可以接受多种类型
		List<?> list = new ArrayList<Integer>();
		list = new ArrayList<String>();
		list = new ArrayList<Object>();
		test(list);
		
	}
	
	public static void test(List<?> list){
		
	}
	
	
	//不能够用到泛型方法上
	/*public <?> void test(){
		
	}*/
	
	//不能用在创建泛型类上
	/*class C <?>{
		
	}*/
	
}
