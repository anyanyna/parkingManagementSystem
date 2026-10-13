package com.gemcoder.system.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
	public static Date addMonth(Date date, int month) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, month);
		return c.getTime();
	}

	public static Date addDay(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}

	/**
	 * 月底
	 * 
	 * @return
	 */
	public static Date monthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, lastDayOfMonth);

		// 设置时间部分为当天的午夜（可选）
		Date result = calendar.getTime();
		result.setHours(23);
		result.setMinutes(59);
		result.setSeconds(59);
		return result;
	}

	/**
	 * 是否在时间范围之内，包括等于
	 * 
	 * @param var
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean inRange(Date var, Date begin, Date end) {
		if (var == null || begin == null || end == null) {
			return false;
		}
		long v1 = var.getTime();
		long v2 = var.getTime();
		long v3 = var.getTime();
		return v1 >= v2 && v1 <= v3;
	}
}
