package com.wxx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wxx.domain.Customer;
import com.wxx.utils.PageBean;

public interface CustomerService {

	//分页业务方法
	PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

	//保存客户
	void save(Customer customer);

	//根据id查询客户
	Customer getById(Long cust_id);
	
	//获得按行业统计客户数量
	List<Object[]> getIndustryCount();
	

}
