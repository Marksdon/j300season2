package priv.xzc.season2.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件--->程序--->字节数组
 * 用到的流：文件按输入流，字节数组输出流
 * 字节数组--->程序--->文件
 * 用到的流：字节数组输入流，文件输出流
 * @author randall
 *
 */
public class ByteAarryStreamDemo {

	public static void main(String[] args) throws IOException {
		byte[] date = getByteFromFile("e:/headUrl.txt");	
		System.out.println(new String(date));


		toFileFromByte(date, "e:/healUrl_copy.txt");

	}

	/**
	 * 字节数组--->程序--->文件
	 * @param src 源数据，字节数组对象
	 * @throws IOException 
	 */
	public static void toFileFromByte(byte[] src, String destPath) throws IOException{

		//1.源文件
		//目的地
		File dest = new File(destPath);
		//2.选择流
		//字节数组--->程序,选择ByteArrayInputStream,一般为了提高性能，都一层处理流管道
		BufferedInputStream bis = new BufferedInputStream(
				new ByteArrayInputStream(src));
		//程序--->文件,选择
		BufferedOutputStream bs = new BufferedOutputStream(
				new FileOutputStream(dest)
				);
		//3.读写操作
		byte[] flush = new byte[1024];
		int len = 0;
		while ((len = bis.read(flush)) != -1) {
			bs.write(flush, 0, len);
		}
		bs.flush();
		//4.关闭资源 
		bs.close();
		bis.close();

	}



	/**
	 * 文件--->程序--->字节数组
	 * @param srcPath 源文件路径
	 * @return 字节数组对象
	 * @throws IOException 
	 */
	public static byte[] getByteFromFile(String srcPath) throws IOException {
		//创建源
		File src = new File(srcPath);
		//目的地
		byte[] dest = null;
		//选择流
		//文件--->程序，选择BufferedInputStream
		BufferedInputStream bs = new BufferedInputStream(
				new FileInputStream(src)
				);
		//程序--->字节数组
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//读取
		byte[] flush = new byte[1024];//读取缓冲字节数组
		int len = 0;
		while ((len = bs.read(flush)) != -1) {
			bos.write(flush, 0, len);//写到管道bos
		}
		bos.flush();
		dest = bos.toByteArray();
		//关闭资源
		bos.close();
		bs.close();
		return dest;
	}





}
