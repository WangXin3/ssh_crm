package com.wxx.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wxx.domain.Customer;

public interface CustomerDao {
	
	//获得总记录数
	Integer getTotalCount(DetachedCriteria detachedCriteria);
	
	//获得查询列表
	List<Customer> getPageList(DetachedCriteria detachedCriteria, int start, Integer pageSize);

}
