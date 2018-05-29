package com.grs.effective.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 类说明:
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月9日 下午8:36:42
 */
public class LessonMain29 {

	@Test
	public void testMain29() {
		Favorites f = new Favorites();
		f.putFavorite(String.class, "java");
		f.putFavorite(Integer.class, 123);
		f.putFavorite(Class.class, Favorites.class);

		String fs = f.getFavorite(String.class);
		int fi = f.getFavorite(Integer.class);
		Class<?> fc = f.getFavorite(Class.class);
		LogUtil.i(fs + fi + fc.getName());

	}

	public class Favorites {

		private Map<Class<?>, Object> favorite = new HashMap<Class<?>, Object>();

		/**
		 * 存放元素
		 * 
		 * @param type
		 * @param instance
		 */
		public <T> void putFavorite(Class<T> type, T instance) {
			if (type == null) {
				throw new NullPointerException("type is null");
			}
			favorite.put(type, instance);
		}

		/**
		 * 取元素
		 * 
		 * @param type
		 * @return
		 */
		public <T> T getFavorite(Class<T> type) {
			return type.cast(favorite.get(type));
		}

	}
}
