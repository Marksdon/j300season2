package priv.xzc.season2.generic02;

/**
 * 泛型接口的继承和实现
 * 和泛型类的继承和实现是相同的，只不过接口的局限性是只能在抽象方法中
 * 
 * @author randall
 *
 * @param <T>
 */
public interface Comparator<T>{
	public abstract void test(T t);
}

//保留
class InterC1<T> implements Comparator<T>{

	@Override
	public void test(T t) {
		
	}};

//不保留
class InterC2 implements Comparator<Integer>{

	@Override
	public void test(Integer t) {
		
	}};
	
class InterC3 implements Comparator{

	@Override
	public void test(Object t) {
	}};

