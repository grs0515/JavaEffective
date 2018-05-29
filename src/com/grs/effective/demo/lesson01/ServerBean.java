package com.grs.effective.demo.lesson01;

/**
 * 测试类
 */
public class ServerBean implements Server {
	private String name;

	public ServerBean() {
	}

	public ServerBean(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}