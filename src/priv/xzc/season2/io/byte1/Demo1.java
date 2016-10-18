package priv.xzc.season2.io.byte1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件的读取
 * @author randall
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		//1.建立练习、File对象
		String pathName = "e:/javaio/test/stream.txt";
		File file = new File(pathName);
		//选择流
		InputStream is = null;//提升作用域
		try {
			is = new FileInputStream(file);
			//操作，不断地读取,缓冲数组
			byte[] car = new byte[10];
			int len = 0;//接受实际读取的大小
			while((len=is.read(car)) != -1){
				//输出 字节数组转成字符串
				String str = new String(car, 0, len);
				System.out.println(str);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读取失败");
		} finally {
			//释放资源
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					is = null;
				}
			}
		}
	} 
}

