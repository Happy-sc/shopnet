package com.paixie.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("getTime")
public class GetTime {

	/**
	 * 获取当前日期
	 * @param format 时间格式
	 * @return 指定格式的当前时间
	 */
	public static String getTime(String format){
		SimpleDateFormat dFormat = new SimpleDateFormat(format);
		Date dates = new Date();
		return dFormat.format(dates);
	}

}
