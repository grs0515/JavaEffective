package com.grs.effective.demo.lesson01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.grs.effective.demo.LogUtil;

/**
 * 3,存/取中心类
 */
public class ServerFactory {

	// map存储
	private static final Map<String, Provider> mProvider = new ConcurrentHashMap<>();
	private static final String DEFAULT_PROVIDER = "default";

	/**
	 * 注册
	 * 
	 * @param name
	 * @param p
	 */
	public static void registerProvider(String name, Provider p) {
		LogUtil.i(name);
		mProvider.put(name, p);
	}

	public static void registerDefaultProvider(Provider p) {
		registerProvider(DEFAULT_PROVIDER, p);
	}

	/**
	 * 获取
	 * 
	 * @param name
	 * @return
	 */
	public static Server newInstance(String name) {
		Provider provider = mProvider.get(name);
		if (provider == null) {
			new NullPointerException("provider is not register");
		}
		return provider.newInstance();
	}

	public static Server newInstance() {
		return newInstance(DEFAULT_PROVIDER);
	}
}
