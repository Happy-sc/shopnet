package com.paixie.common;


/*
 * �������ڲ������
 */
public class ProduceId {

	/**
	 *����ɵ�ǰʱ��YYYYMMDDhhmmss+8λ�����
	 */
	public static String getId(){
		String id =  GetTime.getTime("yyyyMMddHHmmss")+getRandom();
		return id;
	}
	
	/**
	 * ����12λ�����
	 */
	public static String getRandom(){
		StringBuffer buffer = new StringBuffer();
		for(int i = 0;i<8;i++){
			buffer.append((int)(Math.random()*10));
		}
		return buffer.toString();
	}

}
