package com.wxx.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wxx.dao.SaleVisitDao;
import com.wxx.domain.SaleVisit;
import com.wxx.service.SaleVisitService;
import com.wxx.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService {
	private SaleVisitDao svd;
	
	
	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		// 1.调用Dao查询总记录数
		Integer totalCount = svd.getTotalCount(detachedCriteria);
		// 2.创建PageBean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		// 3.调用Dao查询分页列表数据
		List<SaleVisit> list = svd.getPageList(detachedCriteria, pageBean.getStart(), pageBean.getPageSize());
		// 4.将列表数据放入PageBean中
		pageBean.setList(list);
		return pageBean;
	}
	
	@Override
	public void save(SaleVisit saleVisit) {
		svd.saveOrUpdate(saleVisit);
	}

	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}
}
