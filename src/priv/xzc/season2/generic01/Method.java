package priv.xzc.season2.generic01;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * 可以在非泛型类中定义泛型方法
 * 定义：在返回类型前面<字母>
 * @author randall
 *
 */
public class Method {
	public static <T> void test(T t) {
		System.out.println(t);

	}

	//让泛型局限某个类型下，T只能是List或者其子类
	public static <T extends List<Object>> void test() {

	}

	/**
	 * 释放资源，三个点表示可变参数，跟使用数组是基本相似的，替换成为[]也是一样的
	 * Closeable接口就只有一个close方法	
	 */
	public static <T extends Closeable> void test(T...a){
		for(T temp: a){
			try {
				if (temp != null) {
					temp.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}



	public static void main(String[] args) throws FileNotFoundException {
		test("I'm good");
		test(new FileInputStream("a.txt"));//自动释放
	}
}
