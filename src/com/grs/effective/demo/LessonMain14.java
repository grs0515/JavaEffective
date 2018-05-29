package com.grs.effective.demo;

/**
 * 类说明: 有时候编写一些退化类,只是用来集中实例域
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月5日 下午9:42:28
 */
public class LessonMain14 {
	/**
	 * 类使用final 和 成员使用public
	 * 
	 * @author gaoruishan
	 *
	 */
	public final class Time {

		private static final int HOURS_PER_DAY = 24;
		private static final int MINUTES_PER_HOUR = 60;

		public final int hour;
		public final int minute;

		public Time(int hour, int minute) {
			super();
			if (hour < 0 || hour >= HOURS_PER_DAY) {
				throw new IllegalArgumentException("hour is error");
			}
			if (minute < 0 || minute >= MINUTES_PER_HOUR) {
				throw new IllegalArgumentException("minute is error");
			}
			this.hour = hour;
			this.minute = minute;
		}

	}
}
