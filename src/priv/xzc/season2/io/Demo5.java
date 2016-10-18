package priv.xzc.season2.io;

import java.io.File;
import java.util.Arrays;

/**
 * 递归遍历文件夹
 * listFiles()---列出子目录所有的file对象
 * File.listRoots();---根目录，盘符
 * @author randall
 *
 */
public class Demo5 {

	public static void main(String[] args) {
		String path = "e:/javaio";
		File file = new File(path);
		printName(file);
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));//所有的盘符
		
		for (File f : roots) {
			printName(f);//输出所有东西
		}
		
	}

	/**
	 * 递归遍历文件目录
	 * 
	 * 加上过滤就可以做一个文件检索的功能
	 * 
	 * @param file File对象
	 */
	public static void printName(File file) {
		if (file == null || !file.exists()) {
			return;
		}
		System.out.println(file.getAbsolutePath());
		if (file.isDirectory()) {
			for (File src : file.listFiles())
				printName(src);

		}
		

	}
}
