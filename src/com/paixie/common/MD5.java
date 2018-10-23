package com.paixie.common;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class MD5 {
	
	/**
	 * »ñÈ¡×Ö·ûµÄMD5±àÂë
	 * @param source
	 * @return
	 */
	public static String getMD5(String source){
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] b = messageDigest.digest(source.getBytes("utf-8"));
			BASE64Encoder base64en = new BASE64Encoder();
			return base64en.encode(b);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
}