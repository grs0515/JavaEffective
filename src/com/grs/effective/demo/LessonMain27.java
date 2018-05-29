package com.grs.effective.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月8日 下午9:37:30
 */
public class LessonMain27 {

	@Test
	public void testMain() {
		// 测试
		Set<String> hashSet1 = new HashSet<String>(Arrays.asList("Tom"));
		Set<String> hashSet2 = new HashSet<String>(Arrays.asList("Larry"));
		union(hashSet1, hashSet2);

		// 测试
		@SuppressWarnings("unused")
		Map<String, List<String>> map = newHashMap();

		// 测试
		String[] strings = { "java", "php", "c++" };
		UnaryFunction<String> unaryFunction = identityFunction();
		for (String s : strings) {
			LogUtil.i(unaryFunction.apply(s));
		}

	}

	/**
	 * 合并两个集合
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<>(s1);
		result.addAll(s2);
		return result;
	}

	public static <E> Set<E> union2(Set<? extends E> s1, Set<? extends E> s2) {
		Set<E> result = new HashSet<>(s1);
		result.addAll(s2);
		return result;
	}

	/**
	 * 泛型静态工厂
	 * 
	 * @return
	 */
	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<K, V>();
	}

	/**
	 * 定义一个接受和返回T类型的接口
	 * 
	 * @param <T>
	 */
	public interface UnaryFunction<T> {
		T apply(T arg);
	}

	private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {

		@Override
		public Object apply(Object arg) {
			// 处理其他-打印或拦截
			return arg;
		}
	};

	/**
	 * 提供一个恒等函数,非受检
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}
}
