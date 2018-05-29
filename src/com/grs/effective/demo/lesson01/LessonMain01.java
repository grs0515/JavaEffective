package com.grs.effective.demo.lesson01;

import org.junit.Test;

import com.grs.effective.demo.LogUtil;

/**
 * 类说明:考虑用静态工厂方法 替换构造器
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年1月29日 下午8:49:35
 * 
 */
public class LessonMain01 {

	/**
	 * 测试
	 */
	@Test
	public void addMethod01() {
		// 添加
		Provider provider = new Provider() {

			@Override
			public Server newInstance() {
				ServerBean s = new ServerBean("test-01");
				return s;
			}
		};
		ServerFactory.registerDefaultProvider(provider);
	}

	/**
	 * 测试
	 */
	@Test
	public void getMethod01() {
		addMethod01();
		// 获取
		Server server = ServerFactory.newInstance();
		if (server instanceof ServerBean) {
			String name = ((ServerBean) server).getName();
			LogUtil.i(name);
		}

	}

}
