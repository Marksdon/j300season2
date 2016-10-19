package priv.xzc.season2.io;

import java.io.UnsupportedEncodingException;

/**
 * 编码问题：
 * 编码：字符--->编码字符集--->二进制
 * 解码：二进制--->解码字符集--->字符
 * 乱码问题：
 * 乱码的原因有2个：
 * 1.编码字符集和解码字符集不统一
 * 2.字节数缺少，长度不够
 * @author randall
 *
 */
public class EncodeDecode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/**
		 * 乱码测试
		 * 编码与解码的字符集不统一
		 */
		//解码byte--->char
		String str = "中国";
		//编码char----byte
		byte[] data = str.getBytes();//设置了默认为utf-8
		System.out.println(new String(data));
		data = str.getBytes("GBK");//编码字符集为GBK，默认的解码字符集为utf-8所以导致乱码
		System.out.println(new String(data));

		/**
		 * 乱码之 字节缺少，长度不够
		 */
		System.out.println(new String(data, 0, 3,"GBK"));


	}
}
