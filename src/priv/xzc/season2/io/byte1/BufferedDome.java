package priv.xzc.season2.io.byte1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理流---包在节点流上的管道，增强性能
 * 对字节流：--BufferedInputStream,BufferedOutputStream
 * 对字符流：--BufferedReader,BufferedWriter
 * @author randall
 *
 */
public class BufferedDome {

	public static void main(String[] args) {

	}

	public static void copyFile(String srcPath, String destPath) throws IOException {
		//1.建立联系源，存在且为文件

		File src = new File(srcPath);
		File dest = new File(destPath);

		if (src.isFile()) {
			throw new IOException(src.getAbsolutePath() + "不是文件");
		}

		//只需要包上一层处理流即可
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));

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




	/**
	 * 套上处理流
	 */
	public static void copyFile(File src, File dest) throws IOException {
		//1.建立联系源，存在且为文件
		if (!src.isFile()) {
			throw new IOException(src.getAbsolutePath() + "不是文件");
		}

		//2.选择流
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));

		//3.文件的拷贝：读取+写出+循环
		byte[] flush = new byte[1024];
		int len = 0;


		while ((len=bis.read(flush)) != -1) {
			//写出
			System.out.println(len);
			bos.write(flush, 0, len);//推荐这个，读了多少就写出多少
		}

		bos.flush();//强制刷出管道
		//4.关闭流，原则：先打开后不关闭
		bos.close();
		bis.close();
	}





}
