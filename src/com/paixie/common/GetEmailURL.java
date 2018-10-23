package com.paixie.common;

/**
 * ��ȡEmail�����ĵ�ַ
 */
public class GetEmailURL {
	
	/**
	 * ���������ַ��ȡ�����������ĵ�½��ַ
	 * �磺995812509@163.com ---->http://mail.163.com
	 *     995812509@sina.cn ---->http://mail.sina.cn
	 * @param email �����ַ
	 * @return email URL
	 */
	public static String getEmailURL(String email){
		String[] string = email.split("@");
		return "http://mail."+string[1];
	}
}
