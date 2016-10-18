package priv.xzc.season2.pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties输出到文件
 * @author Administrator
 *
 */
public class PropertyToFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("url", "localhost");
		pro.setProperty("username", "xiezhichun");
		pro.setProperty("password", "123456");
		
		//获取
		String url = pro.getProperty("url", "test");
		System.out.println(url);
		/**
		 * 写出到文件
		 */
		//使用绝对路径,win下要使用盘符s
		pro.store(new FileOutputStream(new File("e:/db.properties")), "db.配置文件");
		pro.storeToXML(new FileOutputStream(new File("e:/db.xml")), "db.配置文件");
		
		//使用相对路径
		pro.store(new FileOutputStream(new File("db.properties")), "db.配置文件");
		pro.storeToXML(new FileOutputStream(new File("src/db.xml")), "db.配置文件");
		
		
		
	}


}
