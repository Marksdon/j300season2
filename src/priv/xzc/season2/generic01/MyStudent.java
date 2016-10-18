package priv.xzc.season2.generic01;

/**
 * 自定义泛型类
 * 类名 <字母> ----是单个大写字母，尽可能见名知义
 * T--type
 * E--element
 * K V --key,value
 * 
 * 注意：	
 * 1.泛型不能使用在静态属性上
 * 2.指定的类型不能是基本类型，只能是应用类型
 * 
 * 
 * 
 * @author randall
 *
 */
public class MyStudent <T> {
	private T javase;

	//泛型不能使用在静态属性上s
	/*private static T test;*/
	
	public MyStudent() {
	}

	public MyStudent(T javase) {
		this.javase = javase;
	}

	public T getJavase() {
		return javase;
	}

	public void setJavase(T javase) {
		this.javase = javase;
	}
}
