package com.wxx.service;

import org.hibernate.criterion.DetachedCriteria;

import com.wxx.domain.SaleVisit;
import com.wxx.utils.PageBean;

public interface SaleVisitService {

	//保存客户拜访记录
	void save(SaleVisit saleVisit);

	//客户拜访记录的分页列表
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);
}
