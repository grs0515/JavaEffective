package com.grs.effective.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月7日 下午8:26:03
 */
public class LessonMain23 {
	@Test
	public void TestList() {
		// 无限制
		TClass1<String> tClass = new TClass1<>();
		tClass.getList(list);
		TClass1<Integer> tClass1 = new TClass1<>();
		tClass1.getList(list2);
		// 有限制
		TClass2<Integer> tClass2 = new TClass2<>();
		tClass2.getList(list2);
		TClass2<Double> tClass3 = new TClass2<>();
		tClass3.getList(list3);
	}

	/**
	 * 泛型的术语
	 */
	// 1,参数化的类型
	List<String> list = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
	List<Double> list3 = new ArrayList<>();

	// 2,实际类型参数
	String string;

	// 3,泛型
	class TClass1<E> {
		List<E> li = new ArrayList<>();

		// 4,形式类型参数
		E getList(List<E> list) {
			if (list == null || list.size() == 0) {
				return null;
			}
			return list.get(0);
		}

		// 5,无限制通配符类型
		void addList(List<?> list) {
			if (list instanceof Collection) {
				@SuppressWarnings("unchecked")
				Collection<E> new_name = ((Collection<E>) list);
				li.addAll(new_name);
			}
		}
	}

	// 6,有限制类型参数
	class TClass2<E extends Number> {
		List<E> li = new ArrayList<>();

		E getList(List<E> list) {
			if (list == null || list.size() == 0) {
				return null;
			}
			return list.get(0);
		}

		// 5,有限制通配符类型
		void addList(List<? extends E> list) {
			li.addAll(list);
		}
	}

}
