package com.paixie.common;

import org.springframework.stereotype.Component;

/*
 * �������ڴ����ַ���
 */
@Component("dealString")
public class DealString {

	/**
	 * �����ַ��������ҽ�\��Ϊ/
	 * @param string ��Ҫ������ַ���
	 * @return �Ѿ���ɺõ��ַ���
	 */
	public static String subAndReplaceString(String string){
		String[] strings = string.split("\\\\");
		String string2 = "/";
		for (int i = strings.length-4; i < strings.length; i++) {
			if(i==strings.length-1){
				string2 = string2+strings[i];
			}
			else {
				string2 = string2+strings[i]+"/";
			}
				
		}
		return string2;
	}

}
