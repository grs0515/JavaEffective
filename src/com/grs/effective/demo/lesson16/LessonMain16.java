package com.grs.effective.demo.lesson16;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @param <E>
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月5日 下午10:01:34
 */
public class LessonMain16<E> {

	@SuppressWarnings("unused")
	public void testMain() {
		// 方式1
		Set<Date> s1 = new InstrumentSet<Date>(new TreeSet<>());
		// 方式2
		Set<E> s2 = new InstrumentSet<E>(new HashSet<E>(10));

	}

	static void getBean(Set<TestBean> beans) {
		@SuppressWarnings("unused")
		InstrumentSet<TestBean> instrumentSet = new InstrumentSet<TestBean>(beans);
		// ....
	}
}
