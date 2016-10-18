package priv.xzc.season2.io.byte1;

import java.io.File;
import java.io.IOException;

/**
 * 文件夹拷贝
 * 
 * @author Administrator
 *
 */
public class DirCopyDemo {

	public static void main(String[] args) {
		
		System.out.println(11);
//		String srcPath = "E:/javaio/test/cp.jpg";
//		String destPath = "E:/javaio";
//		copyDir(srcPath, destPath);

	}



	/**
	 * 文件夹拷贝
	 * @param srcPath 源文件路径
	 * @param destPath 目标文件路径
	 */
	public static void copyDir(String srcPath, String destPath){
		File src = new File(srcPath);
		File dest = null;
		if (src.isDirectory()) {
			dest = new File(destPath, src.getName());
		}
		copyDirDetail(src,dest);
	}


	/**
	 * 文件夹拷贝
	 * @param src 源文件File对象
	 * @param dest 目的文件File对象
	 */
	public static void copyDir(File src, File dest){
		if (src.isDirectory()) {
			dest = new File(dest, src.getName());
		}
		copyDirDetail(src,dest);
	}


	/**
	 * 拷贝文件夹细节
	 * @param src 源文件File对象
	 * @param dest 目标文件File对象
	 */
	private static void copyDirDetail(File src, File dest) {
		if (src.isFile()) {
			try {
				FileUtil.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (src.isDirectory()) {
			//确保目标文件夹存在
			for(File f: src.listFiles()){
				copyDirDetail(src, new File(dest, f.getName()));
			}
		}
	}

}
