package priv.xzc.season2.generic01;
/**
 * 自定义泛型的使用
 * 在声明时指定具体类型，不能是基本类型，只能是应用类型
 * @author Administrator
 *
 */
public class MyStuApp {
	public static void main(String[] args) {
		MyStudent<Integer> stu = new MyStudent<>();
		//自动类型检查
		stu.setJavase(2343);
	}
}
