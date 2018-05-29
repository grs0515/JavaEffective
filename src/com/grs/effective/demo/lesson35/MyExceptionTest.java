package com.grs.effective.demo.lesson35;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类说明:某个拓展Exception 的类的Class对象
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月14日 下午10:29:50
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyExceptionTest {
	Class<? extends Exception> value();
}
