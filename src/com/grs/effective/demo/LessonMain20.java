package com.grs.effective.demo;

/**
 * 类说明:类层次优于标签类
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月6日 下午9:58:58
 */
public class LessonMain20 {
	// 图形
	abstract class Figure {
		abstract double area();
	}

	// 圆形
	class Circle extends Figure {

		final double radius;

		public Circle(double radius) {
			this.radius = radius;
		}

		@Override
		double area() {
			return Math.PI * (radius * radius);
		}
	}

	// 长方形
	class Rectangle extends Figure {
		final double length;
		final double width;

		public Rectangle(double length, double width) {
			this.length = length;
			this.width = width;
		}

		@Override
		double area() {
			return length * width;
		}
	}

	// 正方形
	class Square extends Rectangle {

		public Square(double length, double width) {
			super(length, width);
		}
	}
}
