package com.paixie.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("getTime")
public class GetTime {

	/**
	 * ��ȡ��ǰ����
	 * @param format ʱ���ʽ
	 * @return ָ����ʽ�ĵ�ǰʱ��
	 */
	public static String getTime(String format){
		SimpleDateFormat dFormat = new SimpleDateFormat(format);
		Date dates = new Date();
		return dFormat.format(dates);
	}

}
