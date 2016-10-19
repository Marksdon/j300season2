package priv.xzc.season2.io.byte1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.sound.midi.Instrument;

/**
 * 文件的拷贝
 * @author Administrator
 *
 */
public class FileCopyDemo {

	public static void main(String[] args) throws IOException {
		String srcName = "e:javaio/test/IDCAR.jpg";
		String destName = "e:javaio/test/cp.jpg"; 
		copyFile(srcName, destName);
	}


	/**
	 * 拷贝文件
	 * @param srcPath 源文件路径
	 * @param destPath 目的文件路径
	 * @throws IOException
	 */
	public static void copyFile(String srcPath, String destPath) throws IOException {
		//1.建立联系源，存在且为文件

		File src = new File(srcPath);
		File dest = new File(destPath);

		if (src.isFile()) {
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




	public void copyFile(){

		//1.建立源
		File src = new File("/home/randall/src.sh");
		File dest = new File("/home/randall/dest.sh");
		InputStream is = null;
		OutputStream os = null;
		try {
			//2.选择流
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);

			byte[] flush = new byte[1024];
			int len = 0;

			//3.读写+循环
			while((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);//读到到管道dest中
			}
			os.flush();//强制刷出管道
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4.关闭流,关闭规则,后开的先关闭
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}



	}
}
