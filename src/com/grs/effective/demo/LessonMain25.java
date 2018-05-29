package com.grs.effective.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 类说明: 列表优于数组
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月7日 下午8:04:36
 */
public class LessonMain25 {

	private static List<String> list;
	private Object object = "~";
	private String object2 = "~";
	static {
		list = new ArrayList<String>();
		list.add(" i ");
		list.add(" love ");
		list.add(" you ");
	}

	@Test
	public void testMain() {

		Object reduce = reduce(list, new Func() {
			@Override
			public Object apply(Object arg1, Object arg2) {
				// 强转
				return (Object) (arg1.toString() + arg2.toString());
			}
		}, object);
		// 打印
		LogUtil.i(reduce);// ~ i love you

		String reduce2 = reduce2(list, new Func2<String>() {

			@Override
			public String apply(String arg1, String arg2) {
				return arg1 + arg2;
			}
		}, object2);
		LogUtil.i(reduce2);// ~ i love you
	}

	/**
	 * 1,没有泛型代码
	 */
	// 接口
	interface Func {
		Object apply(Object arg1, Object arg2);
	}

	// 方法
	static Object reduce(@SuppressWarnings("rawtypes") List list, Func f, Object initVal) {
		synchronized (list) {
			Object result = initVal;
			for (Object o : list) {
				result = f.apply(result, o);
			}
			return result;
		}
	}

	/**
	 * 2,有泛型的代码
	 */
	// 接口
	interface Func2<T> {
		T apply(T arg1, T arg2);
	}

	// 方法
	static <E> E reduce2(List<E> list, Func2<E> f, E arg) {
		synchronized (list) {
			E result = arg;
			for (E e : list) {
				result = f.apply(result, e);
			}
			return result;
		}
	}
}
