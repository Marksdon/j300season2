package priv.xzc.season2.io;

import java.io.File;
import java.io.IOException;

/*
 * File对象可以说是一种Java程序与磁盘的联系，它既可以表示文件也可以表示文件夹
 * File常用方法
 * 1.文件名
 * getName();
 * getPaht();
 * file.getAbsolutePath()
 * file.getAbsoluteFile()
 * file.getParent()
 * 
 * file.canWrite()
 * file.canRead()
 * file.isAbsolute()
 * 
 * 文件的创建:
 * file.createNewFile()---不存在就创建，存在就不创建并返回false
 * 文件的删除:
 * file.delete()
 * 
 * @author randall
 *
 */
public class Demo3 {

	public static void main(String[] args) throws IOException {
		//		test1();	
		//		test2();
		test3();
	}




	/**
	 * 3.创建、删除文件
	 * @throws IOException 
	 */
	public static void test3() throws IOException{
		//创建文件
		String pathName = "e:/javaio/iotest1.txt";
		//		String pathName = "e:/javaio/con/iotest1.txt";//con是系统关键字，不能是文件夹名，创建不成功
		File file = new File(pathName);
		if (!file.exists()) {
			boolean flag = file.createNewFile();
			System.out.println(flag?"创建成功":"创建失败");
		}

		//删除文件
		boolean flag = file.delete();
		System.out.println(flag?"删除成功":"删除失败");

		File temp = File.createTempFile("tes", ".temp", new File("e:/javaio"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		temp.deleteOnExit();//退出即删除

	}


	/**
	 * 2.判断信息
	 */
	public static void test2(){
		String pathName = "e:/javaio/iotest.txt";
		File file = new File(pathName);
		System.out.println(file.exists());//判断是否存在 
		//可读可写
		System.out.println(file.canWrite());//可写
		System.out.println(file.canRead());//可读

		//是文件还是文件夹
		if (file.isFile()) {
			System.out.println("是文件");
		} else if (file.isDirectory()) {
			//如果不是文件就会默认认为是文件夹
			System.out.println("是文件夹");
		} else {
			System.out.println("文件不存在");
		}
		System.out.println("是否为绝对路径：" + file.isAbsolute());//是否为绝对路径
		System.out.println("长度：" + file.length());//长度，单位为字节,只有文件才有，文件夹是没有的

	}


	/**
	 * 1.文件名
	 */
	public static void test1(){

		//建立了联系而已，具体有没有不知道
		File file = new File("e:/javaio/iotest.txt");
		System.out.println(file.getName());//返回名称
		System.out.println(file.getPath());//如果是绝对路径，就返回绝对路径；如果是相对路径，就返回相对路径
		System.out.println(file.getAbsolutePath());//返回相对路径
		System.out.println(file.getParent());//返回上一级目录，如果没有 上一级,是相对路径，就返回为null
		System.out.println(file.getAbsoluteFile());
	}
}
