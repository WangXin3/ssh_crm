package com.wxx.dao;

import java.util.List;

import com.wxx.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{
	
	//按照行业统计客户数量
	List<Object[]> getIndustryCount();
}
