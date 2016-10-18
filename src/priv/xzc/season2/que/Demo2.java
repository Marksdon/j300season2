package priv.xzc.season2.que;

/**
 * 应用自定义堆栈
 * @author Administrator
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		
		MyStack<String> backHistory = new MyStack<>(3);
		backHistory.push("www.baidu.com");
		backHistory.push("www.sina.cn");
		backHistory.push("www.google.com");
		
		//大小
		System.out.println("大小: " + backHistory.size());
		String item = null;
		while ((item = backHistory.pop()) != null) {
			System.out.println(item);
		}
		
		
		
		
	}
}
