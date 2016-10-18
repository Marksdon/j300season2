package priv.xzc.season2.generic02;

/**
 * 泛型的继承和实现
 * 泛型父类，子类为富二代------好好体会这句话
 * 1.保留父类泛型--->子类为泛型
 * 2.不保留父类泛型--->子类按需实现
 * 
 * 属性 及 方法 类型 ---随位置而定
 * 子类的类型随位置而定，父类定义的类型，子类随重写的方法随父类而定
 * @author randall
 *
 */
public abstract class Father <T1, T2> {
	T1 age;
	public abstract void test(T2 t);
}


//保留------泛型子类
//1）全部保留,子类的位置是可以调 的
class C1<T1,T2,A,B> extends Father<T1, T2>{

	@Override
	public void test(T2 t) {
		// TODO Auto-generated method stub

	}
};
//2)部分保留
class C2<T2,AB> extends Father<Integer, T2>{

	@Override
	public void test(T2 t) {
		// TODO Auto-generated method stub

	}
};
//不保留
//1.)具体类型
class C3<A,B> extends Father<Integer, String>{

	@Override
	public void test(String t) {
		// TODO Auto-generated method stub

	}
};
//2.)没有类型 擦除 Object
class C4<A,B> extends Father{

	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub

	}
	
	
	
	
};
