package com.wxx.service;

import org.hibernate.criterion.DetachedCriteria;

import com.wxx.domain.Customer;
import com.wxx.utils.PageBean;

public interface CustomerService {

	//分页业务方法
	PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	//保存客户
	void save(Customer customer);

}
