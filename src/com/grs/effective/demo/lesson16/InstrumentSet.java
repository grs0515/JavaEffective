package com.grs.effective.demo.lesson16;

import java.util.Collection;
import java.util.Set;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月5日 下午10:08:35
 */
public class InstrumentSet<E> extends CustomSet<E> {

	private int count = 0;

	// 重写父类
	public InstrumentSet(Set<E> s) {
		super(s);
	}

	public int getCount() {
		return count;
	}

	/**
	 * 添加方法
	 */
	@Override
	public boolean add(E e) {
		count++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		count += c.size();
		return super.addAll(c);
	}

}
