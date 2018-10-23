package com.paixie.common;

/**
 * 获取Email主机的地址
 */
public class GetEmailURL {
	
	/**
	 * 根据邮箱地址获取该邮箱主机的登陆地址
	 * 如：995812509@163.com ---->http://mail.163.com
	 *     995812509@sina.cn ---->http://mail.sina.cn
	 * @param email 邮箱地址
	 * @return email URL
	 */
	public static String getEmailURL(String email){
		String[] string = email.split("@");
		return "http://mail."+string[1];
	}
}
