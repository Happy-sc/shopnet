package com.paixie.common;


/*
 * 该类用于参数编号
 */
public class ProduceId {

	/**
	 *编号由当前时间YYYYMMDDhhmmss+8位随机数
	 */
	public static String getId(){
		String id =  GetTime.getTime("yyyyMMddHHmmss")+getRandom();
		return id;
	}
	
	/**
	 * 产生12位随机数
	 */
	public static String getRandom(){
		StringBuffer buffer = new StringBuffer();
		for(int i = 0;i<8;i++){
			buffer.append((int)(Math.random()*10));
		}
		return buffer.toString();
	}

}
