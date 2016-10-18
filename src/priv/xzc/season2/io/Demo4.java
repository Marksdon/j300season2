package priv.xzc.season2.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 目录操作
 * 1.mkdir()------父目录不存在就创建失败
 * 2.mkdirs()--------会递归地创建目录
 * 
 * String[] src = file.list();//子文件、目录名字符串形式
 * file.listFiles();//子文件、目录的File对象
 * @author randall
 *
 */
public class Demo4 {

	public static void main(String[] args) {

		String path = "e:/javaio";
		File file = new File(path);
		if (file.isDirectory()) {
			//子文件、目录名字符串形式
			String[] src = file.list();
			for (String dir : src) {
				System.out.println(dir);
			}
			//子文件、目录的File对象
			File[] files = file.listFiles();
			for (File f : files) {
				System.out.println(f.getAbsolutePath());
			}


			//命令设计模式
			/**
			 * 加上过滤，把以.java的文件给找出来
			 */
			files = file.listFiles(new FilenameFilter(){
				@Override
				/**
				 * dir 目录就是file目录
				 */
				public boolean accept(File dir, String name) {
					System.out.println(dir.getAbsolutePath());
					//构建一下file,是文件并且文件名称是以.java结束
					return new File(dir, name).isFile() && name.endsWith(".java");
				}

			});
			for (File f : files) {
				System.out.println(f.getAbsolutePath());
			}

		}

	}



	/**
	 * 创建目录
	 */
	public static void test1(){
		String path = "e:/javaio/test/mkdir";
		File file = new File(path);
		System.out.println(file.mkdir()?"目录创建成功":"目录创建失败");//父目录不存在就创建失败
		System.out.println(file.mkdirs()?"目录创建成功":"目录创建失败");//会递归地创建目录
	}


}
