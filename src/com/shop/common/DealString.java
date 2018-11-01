package com.shop.common;

import org.springframework.stereotype.Component;

/*
 * 该类用于处理字符串
 */
@Component("dealString")
public class DealString {

	/**
	 * 剪切字符串，并且将\改为/
	 * @param string 需要处理的字符串
	 * @return 已经完成好的字符串
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
