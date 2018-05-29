package com.grs.effective.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月7日 下午9:24:04
 */
public class LessonMain26 {

	public void testMain26() {
		/**
		 * PECS: producer-extends, consumer-super 如果参数化类型,表示一个T生产者,就使用<? extend
		 * T>; 表示一个T消费者,就使用<? super T>
		 */
		Stack<Number> stack = new Stack<Number>();
		// 只能是Number 或者子类
		Iterable<Integer> iterable = null;
		stack.pushAll(iterable);
		// 只能是Number 或者Object
		Collection<Number> objects = null;
		stack.popAll(objects);
	}

	public class Stack<E> {

		private E[] elements;
		private int size = 0;
		private static final int DEFAULT_INIT_CAPACITY = 16;

		/**
		 * 创建Object数组,消除非受检警告
		 */
		@SuppressWarnings("unchecked")
		public Stack() {
			elements = (E[]) new Object[DEFAULT_INIT_CAPACITY];
		}

		/**
		 * 存放元素
		 * 
		 * @param e
		 */
		public void push(E e) {
			ensureCapacity();
			elements[size++] = e;
		}

		/**
		 * 添加所有元素到集合-->Stack<E> 是用来添加使用的
		 * 
		 * @param c
		 */
		public void pushAll(Iterable<? extends E> c) {
			for (E e : c) {
				push(e);
			}
		}

		/**
		 * 取出元素
		 * 
		 * @return
		 */
		public E pop() {
			if (size == 0) {
				throw new EmptyStackException();
			}
			E e = elements[--size];
			elements[size] = null;// 置空
			return e;
		}

		/**
		 * 弹出每个元素,添加到Collection集合中-->Stack<E> 是被Collection用来消费的
		 * 
		 * @param c
		 */
		public void popAll(Collection<? super E> c) {
			while (!isEmpty()) {
				c.add(pop());
			}
		}

		private boolean isEmpty() {
			return elements == null || elements.length == 0;
		}

		/**
		 * 判断数组元素是否增长
		 */
		private void ensureCapacity() {
			if (elements.length == size) {
				elements = Arrays.copyOf(elements, 2 * size + 1);
			}
		}
	}
}
