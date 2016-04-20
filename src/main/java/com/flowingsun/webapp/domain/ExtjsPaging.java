package com.flowingsun.webapp.domain;

import java.io.Serializable;

public class ExtjsPaging implements Serializable {
	private int page;
	private int start;
	private int pageSize;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
