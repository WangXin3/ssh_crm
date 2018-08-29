package com.wxx.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wxx.dao.LinkManDao;
import com.wxx.domain.Customer;
import com.wxx.domain.LinkMan;
import com.wxx.service.LinkManService;
import com.wxx.utils.PageBean;

public class LinkManServiceImpl implements LinkManService{
	private LinkManDao lmd;
	
	
	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		// 1.调用Dao查询总记录数
		Integer totalCount = lmd.getTotalCount(detachedCriteria);
		// 2.创建PageBean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		// 3.调用Dao查询分页列表数据
		List<LinkMan> list = lmd.getPageList(detachedCriteria, pageBean.getStart(), pageBean.getPageSize());
		// 4.将列表数据放入PageBean中
		pageBean.setList(list);
		return pageBean;
	}
	
	@Override
	public void save(LinkMan linkMan) {
		lmd.save(linkMan);
	}


	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}
	

}
