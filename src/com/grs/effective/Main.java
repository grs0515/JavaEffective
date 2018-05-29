package com.grs.effective;

import com.grs.effective.demo.LessonMain14;
import com.grs.effective.demo.LessonMain18;
import com.grs.effective.demo.LessonMain20;
import com.grs.effective.demo.LessonMain21;
import com.grs.effective.demo.LessonMain23;
import com.grs.effective.demo.LessonMain25;
import com.grs.effective.demo.LessonMain26;
import com.grs.effective.demo.LessonMain27;
import com.grs.effective.demo.LessonMain29;
import com.grs.effective.demo.LessonMain30;
import com.grs.effective.demo.LessonMain32;
import com.grs.effective.demo.lesson01.LessonMain01;
import com.grs.effective.demo.lesson02.LessonMain02;
import com.grs.effective.demo.lesson16.LessonMain16;
import com.grs.effective.demo.lesson35.LessonMain35;

/**
 * 类说明:Java 78条原则
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年2月28日 下午7:16:48
 */
public class Main {
	// 所有目录
	Object[] classes = {
			/**
			 * 创建和销毁对象
			 */
			// 1,考虑用静态工长方法代替构造器
			LessonMain01.class,
			// 2,遇到多个构造器参数时要考虑用构造器
			LessonMain02.class,
			// 3,用私有构造器或者枚举强化Singleton属性

			// 4,通过私有构造器强化不可实例化的能力

			// 5,避免创建不必要的对象-->使用static静态初始化

			// 6,消除过期的对象引用

			// 7,避免使用终结方法-->不要用finalize

			/**
			 * 对于所有对象都用的方法
			 */
			// 8,覆盖equals时请遵守通用约定

			// 9,覆盖equals时总要覆盖hashCode

			// 10,始终要覆盖toString-->便于查看数据格式

			// 11,谨慎地覆盖clone

			// 12,考虑实现Comparable接口

			/**
			 * 类和接口
			 */
			// 13,使类和成员的可访问性最小化-->封装

			// 14,在公有类中使用访问方法而非公有域-->退化类
			LessonMain14.class,
			// 15,使可变性最小化

			// 16,复合优于继承
			LessonMain16.class,
			// 17,要么为继承而设计,并提供文档说明,要么就禁止继承

			// 18,接口优于抽象类
			LessonMain18.class,
			// 19,接口只用于定义类型

			// 20,类层次优于标签类
			LessonMain20.class,
			// 21,有函数对象表示策略
			LessonMain21.class,
			// 22,优先考虑静态成员类

			/**
			 * 泛型
			 */
			// 23,请不要在新代码中使用原生态类型
			LessonMain23.class,
			// 24,消除非受检警告

			// 25,列表优于数组
			LessonMain25.class,
			// 26,优先考虑泛型
			LessonMain26.class,
			// 27,优先考虑泛型方法
			LessonMain27.class,
			// 28,利用有限制通配符来提升API的灵活性

			// 29,优先考虑类型安全的异构容器
			LessonMain29.class,
			/**
			 * 枚举和注解
			 */
			// 30,用enum代替int常量
			LessonMain30.class,
			// 31,用实例域代替序数

			// 32,用EnumSet代替位域
			LessonMain32.class,
			// 33,用EnumMap代替序数索引

			// 34,用接口模拟可伸缩的枚举

			// 35,注解优于命名模式
			LessonMain35.class
			// 36,坚持使用Override注解

			// 37,用标记接口定义类型

			/**
			 * 方法
			 */
			// 38,检查参数的有效性

			// 39,必要时进行保护性拷贝

			// 40,谨慎设计方法签名

			// 41,慎用重载

			// 42,慎用可变参数

			// 43,返回零长度的数组或者集合,而不是null

			// 44,为所有导出API元素编写文档注释

			/**
			 * 通用程序设计
			 */
			// 45,将局部变量的作用域最小化

			// 46,for-each循环优于传统的for循环

			// 47,了解和使用类库

			// 48,如果需要精确的答案,请避免使用float和double

			// 49,基本类型优于装箱基本类型

			// 50,如果其他类型更适合,则尽量避免使用字符串

			// 51,当心字符串连接的性能

			// 52,通过接口引用对象

			// 53,接口优先于反射机制

			// 54,谨慎地使用本地方法

			// 55,谨慎地进行优化

			// 56,遵守普遍接受的命名惯例

			/**
			 * 异常
			 */
			// 57,只针对异常的情况才使用异常

			// 58,对可恢复的情况使用受检异常,对编程错误使用运行时异常

			// 59,避免不必要地使用受检的异常

			// 60,优先使用标准的异常

			// 61,抛出与抽象相对应的异常

			// 62,每个方法抛出的异常都要有文档

			// 63,在细节消息中包含能捕获失败的信息

			// 64,努力使失败保持原子性

			// 65,不要忽略异常

			/**
			 * 并发
			 */
			// 66,同步访问共享的可变数据

			// 67,避免过度同步

			// 68,executor和task优先于线程

			// 69,并发工具优先于wait和notify

			// 70,线程安全性的文档化

			// 71,慎用延迟初始化

			// 72,不要依赖线程调度器

			// 73,避免使用线程组

			/**
			 * 序列化
			 */
			// 74,谨慎地实现Serializable接口

			// 75,考虑使用自定义的序列化形式

			// 76,保护性地编写readObject方法

			// 77,对于实例控制,枚举类型优于readResolve

			// 78,考虑用序列化代理代替序列化实例

	};
}
