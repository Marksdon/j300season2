package priv.xzc.season2.referencemap;

import java.lang.ref.WeakReference;

/**
 * 应用分类（面试）
 * 1.强与弱
 * @author randall
 *
 */
public class RefDemo1 {
	public static void main(String[] args) {
		//字符串常量池,属于强引用
		String str = new String("www.baidu.com");
		//弱应用管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		
		/**
		 * 所以，看的出来就是用这几种引用管理这些对象
		 * 强引用
		 * 软引用
		 * 弱引用
		 * 虚引用 
		 */
		System.out.println("gc运行前：" + wr.get());
		//断开引用
		str = null;
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后"+ wr.get());
		/**
		 * 运行后发现，对象不能被回收
		 */
	}
	
	
	public static void testStrongReference(){
		//字符串常量池(共享),属于强引用
		String str = "www.baidu.com";
		//弱应用管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		
		/**
		 * 所以，看的出来就是用这几种引用管理这些对象
		 * 强引用
		 * 软引用
		 * 弱引用
		 * 虚引用 
		 */
		System.out.println("gc运行前：" + wr.get());
		//断开引用
		str = null;
		//通知GC回收
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后"+ wr.get());
		/**
		 * 运行后发现，对象不能被回收
		 */
	}
	
	
	
}
