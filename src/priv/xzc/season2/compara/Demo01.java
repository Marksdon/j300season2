package priv.xzc.season2.compara;

/**
 * 内置累应用类型比较
 * 
 * 
 * 1.整数，小数Integer Float Double比较基本数据类型
 * 2.字符：根据Unicode编码顺序
 * 3.字符串：
 * 1）如果其中一个是额外一个起始开始的子串，返回长度只差
 * 2）否则返回第一个 不想等的Unicode只差
 * 
 * java.util.Date //根据日期的长整型来比较
 * @author randall
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Integer integer;
		Character character;
		
		
		String str0 = "abc";
		String str1 = "abcd";
		String str2 = "dddd";
		System.out.println(str0.compareTo(str2));

	}
	
}
