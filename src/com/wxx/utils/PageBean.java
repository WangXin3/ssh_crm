package com.wxx.utils;

import java.util.List;

import org.junit.Test;

public class PageBean {
	private Integer currentPage;//当前页数
	private Integer totalCount;//总记录数
	private Integer pageSize;//每页显示条数
	private Integer totalPage;//总页数
	private List list;//列表数据

	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.totalCount = totalCount;

		this.currentPage = currentPage;
		if (this.currentPage == null) {
			//如页面没有指定显示那一页 显示第一页
			this.currentPage = 1;
		}
		
		this.pageSize = pageSize;
		if (pageSize == null) {
			//如果为空 默认设置每页显示3条
			this.pageSize = 3;
		}
		
		//计算总页数
		this.totalPage = (int) Math.ceil((this.totalCount * 1.0) / this.pageSize);
		
		//判断当点页数是否超出范围
		//不能小于1 如果小于 则显示第一页
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		//不能大于最大页数 如果大于 则显示最后一页
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
	}
	
	//计算起始索引
	public int getStart() {
		return (this.currentPage - 1) * this.pageSize;
	}
	

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
