package com.grs.effective.demo.lesson02;

/**
 * 类说明: 请求参数
 * 
 * @author 作者:gaoruishan
 * @email 邮箱:grs0515@163.com
 * @time 创建时间：2018年3月1日 下午9:12:44
 */
public class Param {
	private final int currentPage;
	private final int pageSize;
	private final String token;
	private final String userId;

	public Param(Builder builder) {
		this.currentPage = builder.currentPage;
		this.pageSize = builder.pageSize;
		this.token = builder.token;
		this.userId = builder.userId;
	}

	public static class Builder {
		private int currentPage = 0;
		private int pageSize = 10;
		// 必传
		private String token;
		private String userId;

		public Builder(String token, String userId) {
			this.token = token;
			this.userId = userId;
		}

		public Builder currentPage(int currentPage) {
			this.currentPage = currentPage;
			return this;
		}

		public Builder pageSize(int pageSize) {
			this.pageSize = pageSize;
			return this;
		}

		public Param build() {
			return new Param(this);
		}
	}

	@Override
	public String toString() {
		return "Param [currentPage=" + currentPage + ", pageSize=" + pageSize + ", token=" + token + ", userId="
				+ userId + "]";
	}

}
