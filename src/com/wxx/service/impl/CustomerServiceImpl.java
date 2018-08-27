package com.wxx.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wxx.dao.CustomerDao;
import com.wxx.domain.Customer;
import com.wxx.service.CustomerService;
import com.wxx.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
		// 1.调用Dao查询总记录数
		Integer totalCount = customerDao.getTotalCount(detachedCriteria);
		// 2.创建PageBean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		// 3.调用Dao查询分页列表数据
		List<Customer> list = customerDao.getPageList(detachedCriteria, pageBean.getStart(), pageBean.getPageSize());
		// 4.将列表数据放入PageBean中
		pageBean.setList(list);
		return pageBean;
	}

	
	@Override
	public void save(Customer customer) {
		//1.维护Customer与数据字典对象的关系
		//调用Dao取出数据字典对象，将数据字典对象设置到Customer对象的对应属性中
		//2.调用Dao保存客户
		customerDao.save(customer);
	}

}
