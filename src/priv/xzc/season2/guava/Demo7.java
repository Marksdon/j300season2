package priv.xzc.season2.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * 
 * 通过邮箱找到用户
 * 
 * HashMap 键唯一，值可以重复
 * BiMap双向 Map(Bidirectional map),键值都不能重复
 * 可以通过值找到键，双向
 * @author randall
 *
 */
public class Demo7 {

	public static void main(String[] args) {
		BiMap<String, String> biMap =  HashBiMap.create();
		biMap.put("bjsxt", "bjsxt@sina.cn");
		biMap.put("good", "good@qq.com");
		//通过邮箱找用户
		String user = biMap.inverse().get("good@qq.com");
		System.out.println(user);
		System.out.println(biMap.inverse().inverse() == biMap);
	}
}
