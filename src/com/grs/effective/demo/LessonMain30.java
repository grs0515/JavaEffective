package com.grs.effective.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 类说明: 用枚举代替int常量
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月9日 下午9:20:00
 */
public class LessonMain30 {

	public static void main(String[] args) {
		double x = 111.1;
		double y = 222.2;
		for (NewOperation op : NewOperation.values()) {
			LogUtil.i("x = " + x + ", y = " + y + ", op = " + op + ", result = " + op.apply(x, y));
		}
		double result = NewOperation.PLUS.apply(x, y);
		LogUtil.i("result = " + result);

		double apply = NewOperation.fromString("-").apply(x, y);
		LogUtil.i("apply = " + apply);
	}

	// 常量
	public static final int APPLE_PUJI = 0;
	public static final int APPLE_PIPPIN = 1;
	public static final int APPLE_GRANNY_SMITH = 2;

	// 枚举
	public enum Apple {
		PUJI, PIPPIN, GRANNY_SMITH;
	}

	// 一般枚举
	public enum Operation {
		PLUS, MINUS, TIMES, DIVIDE;

		double apply(double x, double y) {
			switch (this) {
			case PLUS:
				return x + y;
			case MINUS:
				return x - y;
			case TIMES:
				return x * y;
			case DIVIDE:
				return x / y;
			}
			throw new AssertionError("unknown op: " + this);
		}
	}

	// 改良后枚举
	public enum NewOperation {
		// 加(),对应的添加构造
		PLUS("+") {
			double apply(double x, double y) {
				return x + y;
			}
		},
		MINUS("-") {
			double apply(double x, double y) {
				return x - y;
			}
		},
		TIMES("*") {
			double apply(double x, double y) {
				return x * y;
			}
		},
		DIVIDE("/") {
			double apply(double x, double y) {
				return x / y;
			}
		};
		// 保存
		private static final Map<String, NewOperation> ops = new HashMap<>();
		static {
			for (NewOperation op : values()) {
				ops.put(op.toString(), op);
			}
		}

		/**
		 * 获取指定的NewOperation
		 * 
		 * @param symbol
		 * @return
		 */
		public static NewOperation fromString(String symbol) {
			return ops.get(symbol);
		}

		private final String symbol;

		// 必须有()
		NewOperation(String symbol) {
			this.symbol = symbol;
		}

		@Override
		public String toString() {
			return symbol;
		}

		// 枚举{}必须实现方法
		abstract double apply(double x, double y);
	}
}
