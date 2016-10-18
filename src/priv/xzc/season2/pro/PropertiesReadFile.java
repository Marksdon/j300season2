package priv.xzc.season2.pro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties读取文件
 * 读取资源配置文件
 * 
 * @author Administrator
 *
 */
public class PropertiesReadFile {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		
		//读取绝对路径
		pro.load(new FileReader("e:/db.properties"));
		
	}
}
