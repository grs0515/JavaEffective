package com.grs.effective.demo;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 类说明:用函数对象表示策略
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月6日 下午10:24:25
 */
public class LessonMain21 {

	// 函数对象
	private static class StrLenCmp implements Comparator<String>, Serializable {

		private static final long serialVersionUID = 1L;

		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}

	}

	// 导出一个不区分大小的字符串比较器
	public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();
}
