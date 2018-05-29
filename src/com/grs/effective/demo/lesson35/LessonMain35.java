package com.grs.effective.demo.lesson35;

import java.util.ArrayList;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月14日 下午10:04:15
 */
public class LessonMain35 {

	/**
	 * 测试一
	 * 
	 * @author gaoruishan
	 *
	 */
	public static class MyTestMain {

		public static void main(String[] args) {
			RunTests.ofTest(MyTestMain.class.getName());
		}

		@MyTest
		public static void m1() {
			System.out.println("this is  m1");
		}

		@MyTest
		public static void m2() {
			System.out.println("this is  m2");
			throw new RuntimeException();
		}

		@MyTest
		public void m3() {
			System.out.println("this is  m3");
		}

		public static void m5() {
			System.out.println("this is  m5");
		}
	}

	/**
	 * 测试二
	 * 
	 * @author gaoruishan
	 *
	 */
	public static class MyExceptionMain {

		public static void main(String[] args) {
			RunTests.ofExceptionTest(MyExceptionMain.class.getName());
		}

		// 算术异常
		@MyExceptionTest(ArithmeticException.class)
		public static void m1() {
			int i = 0;
			i = i / i;
		}

		@MyExceptionTest(value = ArithmeticException.class)
		public static void m2() {
			int[] a = new int[0];
			@SuppressWarnings("unused")
			int i = a[1];
		}

		@MyExceptionTest(ArithmeticException.class)
		public static void m3() {

		}
	}

	/**
	 * 测试三
	 * 
	 * @author gaoruishan
	 *
	 */
	public static class MyException2Main {

		public static void main(String[] args) {
			RunTests.ofExceptionTest2(MyException2Main.class.getName());
		}

		@MyExceptionTest2({ IndexOutOfBoundsException.class, NullPointerException.class })
		public static void m1() {
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.addAll(5, null);
		}

	}

}
