
package org.kymjs.chat.util;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期格式化工具类
 * 
 */
public class DateUtil {
	public static SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd",
			Locale.CHINA);
	public static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss", Locale.CHINA);
	public static SimpleDateFormat sdf_week = new SimpleDateFormat(
			"yyyy-MM-dd EE", Locale.CHINA);
	public static SimpleDateFormat sd_china = new SimpleDateFormat(
			"yyyy年MM月dd日", Locale.CHINA);
	public static SimpleDateFormat sdf_china = new SimpleDateFormat(
			"yyyy年MM月dd日 HH时mm分ss秒", Locale.CHINA);
	public static SimpleDateFormat time_format = new SimpleDateFormat(
			"yyyy年MM月dd日 HH:mm", Locale.CHINA);
	public static SimpleDateFormat time_format_hour = new SimpleDateFormat(
			"yyyy年MM月dd日HH时", Locale.CHINA);

	/*把yyyy-MM-dd HH:mm:ss格式的时间转为yyyy年MM月dd日 HH:mm格式的时间
	 */
	public static String transTime(String time){
		try {
			if (!TextUtils.isEmpty(time)) {
				Date date = sdf.parse(time);
				time = time_format.format(date);
			}
		} catch (Exception e) {
			LogUtil.e(DateUtil.class, "transTime", e);
		}
		return time;
	}

	/*把当前时间转为yyyy-MM-dd HH:mm:ss格式的时间
	 */
	public static String transNowTime(){
		String time = "";
		try {
			time = sdf.format(new Date());
		} catch (Exception e) {
			LogUtil.e(DateUtil.class, "transNowTime", e);
		}
		return time;
	}
}