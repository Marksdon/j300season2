package priv.xzc.season2.io.chars;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 读取字符文件
 * 字符流的操作
 * reader
 * writer
 * bufferreader
 * bufferwriter
 * 
 * @author randall
 *
 */
public class ReadCharStreamDemo1 {

	public static void main(String[] args) {

		//1.建立联系
		File file = new File("e:/mysql_comment.txt");
		Reader reader = null;
		try {
			//2.选择流
			reader = new FileReader(file);//节点流
			char[] cbuf = new char[1014];
			int len = 0;
			//3.读字符
			while ((len = reader.read(cbuf)) != -1) {
				//字符数组转成字符串
				String str = new String(cbuf, 0, len);
				System.out.print(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读取失败");
		} finally {
			//4.关闭资源
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}




	}
	
	
	
	
	
	
	public static void readCharD(){
		
		//1.建立源
		File file = new File("/home/randal/char_Do.sh");
		//2.选择流
		try {
			//3.读取
			Reader reader = new FileReader(file);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		//4.关闭资源
		
	}
	
	
	
	
	
	
}
