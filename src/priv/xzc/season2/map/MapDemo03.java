package priv.xzc.season2.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 面向对象+分拣存储
 * 1.创建数据
 * 2.计算
 * 3.查看
 * @author Administrator
 *
 */
public class MapDemo03 {
	public static void main(String[] args) {
		
		
		List<Student> list = exam();
		Map<String, ClassRoom> map = count(list);
		view(map);
		
	}
	
	
	/**
	 * 查看封装好的数据
	 */
	public static void view(Map<String, ClassRoom> map){
		/**
		 * 方法一
		 */
		for(Map.Entry<String, ClassRoom> entry: map.entrySet()){
			ClassRoom room = entry.getValue();
			double total = room.getTotal();
			double avg = total/room.getStuList().size();
			System.out.println("total: " + total +"||" +"avg: " + avg);
		}
		
		System.out.println("==============================");
		/**
		 * 方法二
		 */
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String no = it.next();
			ClassRoom room = map.get(no);
			double total = room.getTotal();
			double avg = total/room.getStuList().size();
			System.out.println("total: " + total +"||" +"avg: " + avg);
		}
	}
	
	/**
	 * 分拣存储核心代码
	 */
	
	/**
	 * 面向对象，分拣存储
	 * @param list 学生对象list
	 * @return 封装好了的map对象
	 */
	public static Map<String, ClassRoom> count(List<Student> list){
		Map<String, ClassRoom> map = new HashMap<>();
		
		for (Student stu : list) {
			String no = stu.getNo();
			double score = stu.getScore();
			if (!map.containsKey(no)) {
				map.put(no, new ClassRoom(no));
			}
			//hashMap按key遍历的代价是最低的，几乎是直接存取
			ClassRoom room = map.get(no);
			room.getStuList().add(stu);
			room.setTotal(room.getTotal() + score);
			
		}
		return map;
	}
	
	
	

	/**
	 * 创建数据对象
	 */
	public static List<Student> exam(){
		List<Student> list = new ArrayList<>();
		list.add(new Student("谢志春","a",90));
		list.add(new Student("欧冠","a",80));
		list.add(new Student("白","a",30));
		return list;
	}
}
