package priv.xzc.season2.generic02;

/**
 * 泛型的继承
 * 1.保留----泛型父类，子类为富二代------好好体会这句话
 * 2.不保留
 * @author randall
 *
 */
public abstract class Father1 <T1,T2> {

	T1 age;
	public abstract void test(T2 t2);

}

//保留
//1)全部保留,可以有自己的定义泛型，父类泛型必须要全部继承在泛型定义中，子类用谁的定义的泛型，就随谁的类型
class C01<T1,T2,A,B> extends Father1<T1, T2>{

	@Override
	public void test(T2 t2) {

	}

};

//2)部分保留,保留的父类泛型，子类必须在泛型中定义父类的泛型，可以有自己的定义的泛型
class C02<T2> extends Father1<Integer, T2>{

	@Override
	public void test(T2 t2) {

	}
};

//不保留
//1)具体类型
class C03<A,B> extends Father1<Integer, String>{

	@Override
	public void test(String t2) {
		// TODO Auto-generated method stub

	}

}

//1)无类型  类似于object
class C04 extends Father1{

	@Override
	public void test(Object t2) {

	}
};







