package priv.xzc.season2.io.chars;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 处理流---包在节点流上的管道，增强性能
 * 对字节流：--BufferedInputStream,BufferedOutputStream
 * 对字符流：--BufferedReader,BufferedWriter
 * @author randall
 *
 */
public class BufferDemo {

	public static void main(String[] args) {

		//1.建立联系
		File src = new File("e:/writeTest.txt");
		File dest = new File("D:/writeTest.txt");
		//2.选择流
		/*Reader reader = null;
		Writer writer = null;*/
		BufferedReader reader = null;//要使用新方法，就不能有多态
		BufferedWriter writer = null;
		try {
			//只需要包到节点流的外边管道
			reader = new BufferedReader(new FileReader(src));
			writer = new BufferedWriter(new FileWriter(dest));
			//3.拷贝操作，就是循环+读写操作
			/*char[] flush = new char[1024];
			int len = 0;
			while ((len = reader.read(flush)) != -1) {
				writer.write(flush, 0, len);
			}*/
			
			/**
			 * 新方法
			 */
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
//				writer.append("\r\n");//也是换行符
				writer.newLine();//换行符,这是新的方法
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4.关闭资源---先开的后关闭
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
