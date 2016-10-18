package priv.xzc.season2.io.chars;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 写出字符文件
 * 4步法
 * 1.建立联系
 * 2.选择流
 * 3.写出文件
 * 4.关闭资源
 * @author randall
 *
 */
public class WriteCharStreamDemo2 {

	public static void main(String[] args) {
		//1.建立联系
		File file = new File("e:/writeTest.txt");
		//2.选择流
		Writer writer = null;
		try {
			//3.写出文件
//			writer = new FileWriter(file);
			writer = new FileWriter(file, true);//追加,false为覆盖
			String data = "锄禾日当午\r\n码农真辛苦\r\n";
			writer.write(data);
			writer.append("夜来风雨声");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4.关闭资源
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}



	}
}
