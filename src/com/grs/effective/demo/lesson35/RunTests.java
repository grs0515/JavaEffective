package com.grs.effective.demo.lesson35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 类说明:简单运行测试类
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月14日 下午10:08:07
 */
public class RunTests {

	/**
	 * 测试方法一
	 * 
	 * @param args
	 */
	public static void ofTest(String args) {
		int tests = 0;
		int passed = 0;
		for (Method m : forName(args)) {
			if (m.isAnnotationPresent(MyTest.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException e) {
					Throwable cause = e.getCause();
					System.out.println(m + " failed: " + cause);
				} catch (Exception e) {
					System.out.println("INVALID @MyTest : " + m);
				}

			}
		}
		System.out.printf("Passed: %d, Failed: %d", passed, tests - passed);
	}

	/**
	 * 测试方法二
	 * 
	 * @param args
	 */
	public static void ofExceptionTest(String args) {
		int tests = 0;
		int passed = 0;
		for (Method m : forName(args)) {
			if (m.isAnnotationPresent(MyExceptionTest.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("MyExceptionTest %s failed: no exception %n", m);
				} catch (InvocationTargetException e) {
					Throwable cause = e.getCause();
					Class<? extends Exception> value = m.getAnnotation(MyExceptionTest.class).value();
					if (value.isInstance(cause)) {// 是否一个类型
						passed++;
						System.out.println(m + " failed: " + cause);
					} else {
						System.out.printf("MyExceptionTest %s failed: expected %s, got %s%n ", m, value.getName(),
								cause);
					}
				} catch (Exception e) {
					System.out.println("INVALID @MyExceptionTest : " + m);
				}

			}
		}
		System.out.printf("Passed: %d, Failed: %d", passed, tests - passed);
	}

	/**
	 * 测试方法三
	 * 
	 * @param args
	 */
	public static void ofExceptionTest2(String args) {
		@SuppressWarnings("unused")
		int tests = 0;
		int passed = 0;
		for (Method m : forName(args)) {
			if (m.isAnnotationPresent(MyExceptionTest2.class)) {
				tests++;
				try {
					m.invoke(null);
				} catch (Throwable e) {
					Throwable cause = e.getCause();
					Class<? extends Exception>[] values = m.getAnnotation(MyExceptionTest2.class).value();
					int oldPassed = passed;
					for (Class<? extends Exception> class1 : values) {
						if (class1.isInstance(cause)) {
							passed++;
							System.out.println("ExceptionTest2 passed : " + passed);
							break;
						}
					}
					if (passed == oldPassed) {
						System.out.printf("Test %s failed : %s %n", m, cause);
					}
				}
			}

		}
	}

	/**
	 * 获取声明方法
	 * 
	 * @param args
	 * @return
	 */
	private static Method[] forName(String args) {
		Class<?> testClass = null;
		try {
			testClass = Class.forName(args);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if (testClass == null) {
			return null;
		}
		return testClass.getDeclaredMethods();
	}

}
