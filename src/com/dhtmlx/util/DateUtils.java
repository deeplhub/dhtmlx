package com.dhtmlx.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	
	/**
	 * 时间转换
	 * 
	 * 说明：主要是对提前提醒时间做一些操作，把结束时间和提前提醒（天/小时/分）换算成毫秒，再返回处理后的时间，
	 * 
	 */
	public static Date time2millisecond(Date date, String str, String timeFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		Calendar calendar = Calendar.getInstance();
		String[] arr = str.split(",");
		try {
			if (arr.length == 3) {
				long endTime = sdf.parse(sdf.format(date)).getTime();
				long day = 1000 * 60 * 60 * 24 * Integer.valueOf(arr[0]);
				long hour = 1000 * 60 * 60 * Integer.valueOf(arr[1]);
				long minute = 1000 * 60 * Integer.valueOf(arr[2]);

				calendar.setTimeInMillis(endTime - (day + hour + minute));

				System.out.println(sdf.parse(sdf.format(calendar.getTime())));
				return sdf.parse(sdf.format(calendar.getTime()));
			} else {
				System.out.println("类型不符合");
				return null;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	public static void main(String[] args) {
		String str = "1,0,0";
		String timeFormat = "yyyy-MM-dd HH:mm:ss";
		Object obj = time2millisecond(new Date(), str, timeFormat);
		if (obj instanceof Date) {
			System.out.println(obj);
		} else {
			System.out.println("1");
		}
	}
}
