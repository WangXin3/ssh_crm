package com.wxx.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.wxx.dao.CustomerDao;
import com.wxx.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	
	@Override
	public List<Object[]> getIndustryCount() {
		//原声sql查询
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
			String sql = "SELECT bd.dict_item_name, COUNT(*) total FROM cst_customer cc, base_dict bd "
					+ "WHERE cc.cust_industry = bd.dict_id "
					+ "GROUP BY cc.cust_industry";
				
			
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				return query.list();
			}
		});
		return list;
	}
	
}
