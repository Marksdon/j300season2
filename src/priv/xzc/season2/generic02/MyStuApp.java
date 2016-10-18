package priv.xzc.season2.generic02;

/**
 * 泛型的擦除：继承|实现|使用时没有指定类型 
 * 类似于Object，但是不等同于Object，编译时时没有类型检查的:
 * 指定了类型就会类型检查，如果没有指定类型就不会类型检查
 * @author randall
 *
 */
public class MyStuApp {
	public static void main(String[] args) {
		//指定类型
		MyStudent<Integer> stu = new MyStudent<>();
		//自动类型检查
		stu.setJavase(2343);
		
		/**
		 * 泛型擦除时注意：
		 * 类似于Object，但是不等同于Object，编译时时没有类型检查的:
		 * 指定了类型就会类型检查，		如果没有指定类型就不会类型检查
		 */
		//没有指定类型
		MyStudent stu2 = new MyStudent<>();
		stu2.setJavase("sss");//编译时是不会类型检查的
		
		//指定object类型
		MyStudent<Object> stu3 = new MyStudent<>();
		stu3.setJavase("ddd");//编译时会类型检查
		
	}
}
