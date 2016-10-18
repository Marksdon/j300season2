package priv.xzc.season2.enumeration;

import java.util.Enumeration;
import java.util.Vector;

import javax.print.attribute.standard.MediaName;

/**
 * 古老的类
 * JDK1.5前
 * 里边有两个方法
 * hasMoreElements()
 * nextElement()
 * 
 * @author Administrator
 *
 */
public class Demo1 {
	
	public static void main(String[] args) {
		
		Vector<String> v = new Vector<>();
		v.add("www");
		v.add("aaa");
		v.add("ccc");
		
		System.out.println(v.size());
		
		Enumeration<String> e = v.elements();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		
		
		
		
		
	}
}
