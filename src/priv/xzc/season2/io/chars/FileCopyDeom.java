package priv.xzc.season2.io.chars;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 纯文本拷贝
 * 字符流只能处理文本,所以也是不能拷贝文件夹的
 * 不像字节流，字节流可以处理所以的，包括二进制，音频，视频
 * @author randall
 *
 */
public class FileCopyDeom {

	public static void main(String[] args) {
		
		//1.建立联系
		File src = new File("e:/writeTest.txt");
		File dest = new File("D:/writeTest.txt");
		//2.选择流
		Reader reader = null;
		Writer writer = null;
		
		try {
			reader = new FileReader(src);
			writer = new FileWriter(dest);
			
			//3.拷贝操作，就是循环+读写操作
			char[] flush = new char[1024];
			int len = 0;
			while ((len = reader.read(flush)) != -1) {
				writer.write(flush, 0, len);
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
