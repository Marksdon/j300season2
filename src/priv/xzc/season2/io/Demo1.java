package priv.xzc.season2.io;

import java.io.File;

/**
 * File的两个常量
 * 1.路径分割符：pathSeparator
 * 2.名称分隔符：separator
 * @author Administrator
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		//路径的表示
		//仅限win
		String path0 = "e:\\javaio";
		//跨平台，适合动态生成，固定的路径就不推荐
		String path1 = "e:"+File.separator+"javaio";
		//通常推荐这样写，win/linux通杀
		String path2 = "e:/javaio";
		
		
		
	}
}
