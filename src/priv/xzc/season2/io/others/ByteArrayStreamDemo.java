package priv.xzc.season2.io.others;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 节点流
 * 字节数组
 * ByteArrayInputStream
 * 
 * 文件不用太大
 * 1.文件--->程序---->字节数组
 * 2.字节数组--->程序--->文件
 * 
 * @author randall
 *
 */
public class ByteArrayStreamDemo {

	public static void main(String[] args) {
		try {
			read(writer());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


	/**
	 * 输出流，有不一样
	 * 1.没有文件关联
	 * toByteArray（）方法
	 * @throws IOException
	 */
	public static byte[] writer() throws IOException{
		
		//1.目的地
		byte[] dest;
		//2.选择流,有不同，与文件操作不同，不关联
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//写
		String msg = "操作与文件输入流一致";
		byte[] src = msg.getBytes();
		bos.write(src, 0, src.length);//分不清楚，就要有管道概念，以程序为中心
		/**
		 * 有大不同
		 */
		dest = bos.toByteArray();
		//4.关闭资源
		bos.close();
		return dest;
		
	}
	
	
	
	/**
	 * 输入流，操作与文件的操作一样
	 * 读取字节数组
	 */
	public static void read(byte[] src){
		//1.源
		//选择流
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(src)
				);//无抛出异常,因为没有与外界交流

		try {
			//读操作
			int len = 0;
			byte[] flush = new byte[1024];
			while ((len = is.read(flush)) != -1) {//read到哪里去，读到flush缓冲中
				System.out.println(new String(flush, 0, len));//有多少就打印多少
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//关闭资源
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
