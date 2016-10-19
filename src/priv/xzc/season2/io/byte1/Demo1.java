package priv.xzc.season2.io.byte1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件的读取
 * 1.FileInputStream()
 * 
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
			byte[] car = new byte[1024];
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



	/**
	 * 读取文件
	 */
	public static void readByteFile() {

		String srcPath = "";
		String destPath = "";
		//1.建立联系
		File file = new File(srcPath);
		//2.选择流 
		InputStream is = null;//提升作用域
		try {

			is = new FileInputStream(file);//InputStream未抽象类
			//3.读取操作

			byte[] bs = new byte[1024];//读取的单位
			int len = 0;
			while((len = is.read(bs)) != -1){
				String str = new String(bs, 0, len);//字节数组构建字符串
				System.out.println(str);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4.关闭资源
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					is = null;
				}
			}
		}
	}


	public static void writeFile(){
		//1.建立联系
		String destPath = "";
		File dest = new File(destPath);
		OutputStream os = null;
		try {
			//2.选择流
			os = new FileOutputStream(dest, true);//true文件被追加，false覆盖
			//3.写出文件
			String src = "xxx";
			byte[] b = src.getBytes("utf-8");
			os.write(b, 0, b.length);//直接写出到管道
			os.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			//4.关闭资源
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}


}

