package com.grs.effective.demo;

import java.util.AbstractList;
import java.util.List;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月6日 下午9:48:01
 */
public class LessonMain18 {

	static List<Integer> intArrayAsList(final int[] a) {
		if (a == null) {
			throw new NullPointerException();
		}
		return new AbstractList<Integer>() {

			@Override
			public Integer get(int index) {
				return a[index];
			}

			@Override
			public Integer set(int index, Integer element) {
				int oldElement = a[index];
				a[index] = element;
				return oldElement;
			}

			@Override
			public int size() {
				return a.length;
			}
		};
	}
}
