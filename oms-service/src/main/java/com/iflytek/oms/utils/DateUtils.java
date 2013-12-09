
package com.iflytek.oms.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author wangyan9110
 * 
 */
public final class DateUtils {

	/**
	 * 默认时间格式
	 */
	private static final String FORMAT = "yyyy-MM-dd hh:mm:ss";

	/**
	 * 私有对象
	 */
	private DateUtils() {

	}

	/**
	 * 获取现在时间
	 * 
	 * @return 现在时间
	 */
	public static Date getDateTimeNow() {
		Calendar calender = Calendar.getInstance();
		return calender.getTime();
	}

	/**
	 * 获取格式化的字符串
	 * 
	 * @param format
	 *            格式化样式；默认为yyyy-MM-dd hh:mm:ss
	 * @param date
	 *            时间
	 * @return 格式化后的字符串
	 */
	public static String getFormatStr(Date date, String format) {

		if (date == null) {
			throw new IllegalArgumentException("format和date不能为空");
		}

		SimpleDateFormat dateFormat;

		if (format == null || format.isEmpty()) {
			dateFormat = new SimpleDateFormat(FORMAT);
		}
		else{
			dateFormat = new SimpleDateFormat(format);
		}
		return dateFormat.format(date);
	}

	/**
	 * 字符串转化为日期对象
	 * 
	 * @param format
	 *            格式化样式，默认为yyyy-MM-dd hh:mm:ss
	 * @param dateStr
	 *            时间字符串
	 * @return 日期对象
	 */
	public static Date convertToDate(String dateStr, String format) {

		if (dateStr == null) {
			throw new IllegalArgumentException("dateStr不能为空");
		}

		SimpleDateFormat dateFormat;

		try {
			if (format == null || format.isEmpty()) {
				dateFormat = new SimpleDateFormat(FORMAT);
			} else {
				dateFormat = new SimpleDateFormat(format);
			}
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException("来自DateUtils.convertToDate", e);
		}
	}

	/**
	 * timestamp类型转换为date类型
	 * @param time 时间戳
	 * @return 日期
	 */
	public static Date convertToDate(Timestamp time) {
		return new Date(time.getTime());
	}
}
