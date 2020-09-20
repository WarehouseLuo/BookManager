package top.cla.util;

/**
 * ÅÐ¶Ï×Ö·û´®¹¤¾ßÀà
 * @author victor
 */
public class StringUtil {
	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ
	 * @param str
	 * @return boolean
	 */
	public static boolean strIsEmpty(String str) {
		if(str == null || "".equals(str)) {
			//×Ö·û´®Îª¿Õ
			return true;
		}else {
			return false;
		}
	}
}
