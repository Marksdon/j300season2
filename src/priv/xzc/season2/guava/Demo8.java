package priv.xzc.season2.guava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

/**
 * 双键的map Table
 * 
 * rowKey columnKey value
 * 
 * 1.方法
 * 所有的行数据:cellSet()
 * 所有的学生：rowKeySet()
 * 所有的课程：columnKeySet()
 * 所有的成绩：valuse()
 * 
 * @author randall
 *
 */
public class Demo8 {

	public static void main(String[] args) {
		Table<String, String, Integer> table = HashBasedTable.create();
		//测试数据
		table.put("a", "javase", 90);
		table.put("b", "javase", 80);
		table.put("a", "oracle", 100);
		table.put("c", "javase", 95);
		
		//查看所有行数据
		Set<Cell<String, String, Integer>> cells = table.cellSet();
		for (Cell<String, String, Integer> cell : cells) {
			System.out.println(cell.getRowKey()+"-"+cell.getColumnKey()+"--->"+cell.getValue());
		}
		
		System.out.println("==================================");
		System.out.print("学生\t");
		//所有的课程
		Set<String> course = table.columnKeySet();
		for (String cour : course) {
			System.out.print(cour + "\t");
		}
		System.out.println();
		//所有的学生
		Set<String> stus = table.rowKeySet();
		for (String stu : stus) {
			System.out.print(stu + "\t");
			Map<String, Integer> scroce = table.row(stu);
			for (String c : course) {
				System.out.print(scroce.get(c)+"\t");
			}
			System.out.println();
		}
		
		
		
		
		
	}
}
