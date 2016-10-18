package priv.xzc.season2.io;

import java.io.File;

/**
 * 相对路径与绝对路径构建File对象
 * @author randall
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		String parentPath = "e:/javaio";
		String name = "iotest.txt";
		//相对路径
		File file = new File(parentPath,name);
		File file2 = new File(new File(parentPath), name);//第二种构造方法
		//输出
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getPath());
		
		//绝对路径
		File file3 = new File("e:/javaio/iotest.txt");
		System.out.println(file3.getAbsolutePath());
		
		//假设没有盘符，就会以user.dir目录来构建路径
		File file4 = new File("test.txt");
		System.out.println(file4.getName());
		System.out.println(file4.getPath());//如果是已绝对路径构建就返回绝对路径，如果是相对路径就返回相对路径了
		System.out.println(file4.getAbsolutePath());//获取绝对路径
		
		File file5 = new File(".");
		System.out.println(file5.getName());
		System.out.println(file5.getPath());
		System.out.println(file5.getAbsolutePath());
		
		File file6 = new File("e:kaoakao");
		System.out.println(file6.exists());
		System.out.println(file6.getPath());
		System.out.println(file6.getAbsolutePath());
		
	}
	
}
