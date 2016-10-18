package priv.xzc.season2.referencemap;

import java.util.EnumMap;

/**
 * 	
 * @author Administrator
 *
 */
public class EnumMapDemo {
	public static void main(String[] args) {
		EnumMap<Season, String> map = new EnumMap<>(Season.class);
		
		map.put(Season.SPRING, "春困");
		map.put(Season.SUMMER, "夏无力");
		map.put(Season.AUTUMN, "秋乏");
		map.put(Season.WINTER, "冬眠");
		
		System.out.println(map.size());
	}
}


enum Season{
	SPRING,SUMMER,AUTUMN,WINTER 
}