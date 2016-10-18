package priv.xzc.season2.generic01;

/**
 * 没有泛型的类，存储数据
 * @author randall
 *
 */
public class StuApp {
	public static void main(String[] args) {
		//int --->Integer--Object(自动装箱，多态)
		Student stu = new Student(80);
		
		Object javase = stu.getJavase();
		
		if (javase instanceof Integer) {//手动判断
			Integer score = (Integer)javase;
		}
	}
}
