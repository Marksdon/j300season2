package priv.xzc.season2.generic01;

/**
 * 泛型不能使用在全局常量上面
 * 就只能用在公共的抽象方法上了
 * @author randall
 *
 * @param <T>
 */
public interface Comparator<T> {
	//全局常量
	public static final int MAX_VALUE = 1024;
	//公共的抽象方法
	void compara(T t);
}
