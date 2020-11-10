package top.cla.util;

/**
 * 判断字符串工具类
 * @author victor
 */
public class StringUtil {
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return boolean
	 */
	public static boolean strIsEmpty(String str) {
		if(str == null || "".equals(str)) {
			//字符串为空
			return true;
		}else {
			return false;
		}
	}
}
