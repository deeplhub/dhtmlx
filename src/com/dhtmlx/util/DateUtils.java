package com.dhtmlx.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	
	/**
	 * ʱ��ת��
	 * 
	 * ˵������Ҫ�Ƕ���ǰ����ʱ����һЩ�������ѽ���ʱ�����ǰ���ѣ���/Сʱ/�֣�����ɺ��룬�ٷ��ش�����ʱ�䣬
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
				System.out.println("���Ͳ�����");
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
