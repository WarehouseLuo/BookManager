package top.cla.util;

/**
 * �ж��ַ���������
 * @author victor
 */
public class StringUtil {
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * @param str
	 * @return boolean
	 */
	public static boolean strIsEmpty(String str) {
		if(str == null || "".equals(str)) {
			//�ַ���Ϊ��
			return true;
		}else {
			return false;
		}
	}
}
