package com.wxx.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wxx.dao.CustomerDao;
import com.wxx.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public Integer getTotalCount(DetachedCriteria detachedCriteria) {
		//设置查询的聚合函数，总记录数
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
		
		//清空之前设置的聚合函数 detachedCriteria对象复用
		detachedCriteria.setProjection(null);
		
		if (list != null && list.size() > 0) {
			Long count = list.get(0);
			return count.intValue();
		}else {
			return null;
		}
	}

	@Override
	public List<Customer> getPageList(DetachedCriteria detachedCriteria, int start, Integer pageSize) {
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
		return list;
	}

}
