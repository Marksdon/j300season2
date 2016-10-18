package priv.xzc.season2.enumeration;

import java.util.StringTokenizer;

/**
 * Enumeration的子类StringTokenizer
 * 相当于string 的split()方法，分割字符串，但是不支持正则表达式
 * @author Administrator
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		
		String str = "www.baidu.com;www.sina.cn;www.xzc.com";
		
		StringTokenizer tokenizer = new StringTokenizer(str, ";");
		
		while (tokenizer.hasMoreElements()) {
			System.out.println(tokenizer.nextElement());
		}
		
		
	}
}
