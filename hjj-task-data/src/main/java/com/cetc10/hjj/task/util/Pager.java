package com.cetc10.hjj.task.util;

import java.util.List;

/**分页工具类 * */
public class Pager<T> {
	private int currentPage;// 当前页
	private int totalPage;// 总页数
	private int pageSize;// 每页的记录数
	private int totalSize;// 总的记录数
	private List<T> list;// 集合

	public Pager() {
		super();
	}

	public Pager(int currentPage, int totalPage, int pageSize, int totalSize, List<T> list) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
