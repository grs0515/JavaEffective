package com.grs.effective.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 类说明:log 输出日志
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月1日 下午8:50:35
 */
public class LogUtil {

	private static Logger logger = Logger.getLogger("log");

	/**
	 * 所有的类型
	 * 
	 * @param object
	 */
	public static void i(Object object) {
		String str = "";
		if (object instanceof Integer || object instanceof Boolean || object instanceof Long || object instanceof Double
				|| object instanceof String) {
			str += object;
		} else {
			str += object.toString();
		}
		logger.log(Level.INFO, str);
	}

	public static void i(String s) {
		logger.log(Level.INFO, s);
	}

	public static void w(Object object) {
		logger.log(Level.WARNING, object + "");
	}
}
