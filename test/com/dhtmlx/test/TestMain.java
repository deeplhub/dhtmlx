package com.dhtmlx.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestMain {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse("2016-08-31"));
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)-1);
		String impMonthEnd = sdf.format(calendar.getTime());
		System.out.println(impMonthEnd);
	}
	
	/**
	 * 取得当前日期所在周的第一天和最后一天
	 * 
	 */
	public static void getMonth(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE)); // Monday
		String impMonthBegin = sdf.format(calendar.getTime());
		System.out.println(impMonthBegin);
		
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		String impMonthEnd = sdf.format(calendar.getTime());
		System.out.println(impMonthEnd);
	}

	/**
	 * 取得当前日期所在周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE)); // Monday
		return calendar.getTime();
	}

	/**
	 * 取得当前日期所在月的最后一天
	 * 
	 */
	public static Date getLastMonth(Date date) {
		// 获取Calendar
		Calendar calendar = Calendar.getInstance();
		// 设置时间,当前时间不用设置
		calendar.setTime(date);
		// 设置日期为本月最大日期
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

		return calendar.getTime();
	}

	/**
	 * 取得当前日期所在周的第一天和最后一天
	 * 
	 */
	private static void convertWeekByDate(Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		System.out.println(dayWeek);
		if (1 == dayWeek) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
		}
		System.out.println("要计算日期为:" + sdf.format(calendar.getTime())); // 输出要计算日期
		calendar.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		int day = calendar.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		String imptimeBegin = sdf.format(calendar.getTime());
		System.out.println("所在周星期一的日期：" + imptimeBegin);
		calendar.add(Calendar.DATE, 6);
		String imptimeEnd = sdf.format(calendar.getTime());
		System.out.println("所在周星期日的日期：" + imptimeEnd);

	}

	/**
	 * 取得当前日期所在周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek() {
		Calendar calendar = new GregorianCalendar();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); // Monday
		return calendar.getTime();
	}

	/**
	 * 取得当前日期所在周的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek() {
		Calendar calendar = new GregorianCalendar();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); // Sunday
		return calendar.getTime();
	}

}
