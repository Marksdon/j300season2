package priv.xzc.season2.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流(字节-->字符)
 * 输入流：InputStreamReader(解码)
 * 输出流：OutputStreamWriter(编码)
 * @author randall
 *
 */
public class ConvertStreamDome {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("e:/mysql_comment.txt")), "UTF-8")
				);
		
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(new File("e:/xxx.txt")));
		
		String line = null;
		while ((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine();
			System.out.println(line);
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
}
