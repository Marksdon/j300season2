package priv.xzc.season2.io.byte1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件的写出
 * 1.建立联系，File对象
 * 2.选择流
 * 3.操作  write() + flush()
 * 4.释放资源
 * @author randall
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		//1.建立联系，File对象
		String pathName = "e:/javaio/test/writed.txt";
		File file = new File(pathName);
		//2.选择流
		OutputStream os = null;//提升作用域
		try {
			os = new FileOutputStream(file,true);//后边参数true表示文件的追加，false表示覆盖
			//3.操作
			String str = "I'm very good";
			//字符串转字节数组
			byte[] data = str.getBytes();
			os.write(data, 0, data.length);
			os.flush();//强制刷出管道
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件写出失败");
		}finally {
			//4.释放资源
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("输出流关闭失败");
				}finally {
					os = null;
				}
			}
		}


	}
}
