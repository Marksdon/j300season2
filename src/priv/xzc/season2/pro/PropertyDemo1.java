package priv.xzc.season2.pro;

import java.util.Properties;

/**
 * Properties类
 * @author Administrator
 *
 */
public class PropertyDemo1 {

	public static void main(String[] args) {
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("url", "localhost");
		pro.setProperty("username", "xiezhichun");
		pro.setProperty("password", "123456");
		
		//获取
		String url = pro.getProperty("url", "test");
		System.out.println(url);
	}
}
