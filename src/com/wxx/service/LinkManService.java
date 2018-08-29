package com.wxx.service;

import org.hibernate.criterion.DetachedCriteria;

import com.wxx.domain.LinkMan;
import com.wxx.utils.PageBean;

public interface LinkManService {

	//保存联系人
	void save(LinkMan linkMan);
	
	//联系人列表
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	//根据id获取到对象
	LinkMan getById(Long cust_id);
}
