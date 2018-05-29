package com.grs.effective.demo.lesson02;

import org.junit.Test;

import com.grs.effective.demo.LogUtil;

/**
 * 类说明:遇到多个构造器参数时要考虑用构建器
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年1月29日 下午8:48:38
 */
public class LessonMain02 {

	@Test
	public void getParam() {
		Param param = new Param.Builder("ETINDLDLK", "234874").currentPage(0).pageSize(20).build();
		LogUtil.i(param.toString());
	}

}
