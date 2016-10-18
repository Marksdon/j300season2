package priv.xzc.season2.io.byte1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件的操作
 * 1.拷贝
 * @author randall
 *
 */
public class FileUtil {

	/**
	 * 不允许实例化
	 */
	private FileUtil() {
	}
	
	/**
	 * 拷贝文件
	 * @param srcPath 源文件路径
	 * @param destPath 目的文件路径
	 * @throws IOException
	 */
	public static void copyFile(String srcPath, String destPath) throws IOException {
		/**
		 * 这里的写代码的技巧：
		 * new File(srcPath)只用了一次，就使用匿名方式
		 * copyFile()的重载其实很多代码是相同的，就删除一部分代码，直接调用另一个
		 * 源码的构造器很对都是这样子内部调用的，下面就是这样：
		 */
		copyFile(new File(srcPath), new File(destPath));
	}
	
	
	/**
	 * 拷贝文件
	 * @param src 源文件File对象
	 * @param dest 目的文件File对象
	 * @throws IOException
	 */
	public static void copyFile(File src, File dest) throws IOException {
		//1.建立联系源，存在且为文件
		if (!src.isFile()) {
			throw new IOException(src.getAbsolutePath() + "不是文件");
		}
		
		//2.选择流
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		
		//3.文件的拷贝：读取+写出+循环
		byte[] flush = new byte[1024];
		int len = 0;
		while ((len=is.read()) != -1) {
			//写出
			System.out.println(len);
			os.write(flush, 0, len);//推荐这个，读了多少就写出多少
		}
		
		os.flush();//强制刷出管道
		//4.关闭流，原则：先打开后不关闭
		os.close();
		is.close();
	}
	
	
}
