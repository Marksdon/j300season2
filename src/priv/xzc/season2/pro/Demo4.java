package priv.xzc.season2.pro;

import java.io.IOException;
import java.util.Properties;

/**
 * 类的相对路径读取资源配置文件
 * 
 * @author Administrator
 *
 */
public class Demo4 {
	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		
		//类的相对路径 /根目录，就是bin
//		pro.load(Demo4.class.getResourceAsStream("db.xml"));
//		pro.loadFromXML(Demo4.class.getResourceAsStream("/db.xml"));
		
		//当前类的加载器 ""就表示bin
		pro.loadFromXML(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.xml"));
		System.out.println(pro.getProperty("username","test"));
		
	}
}
