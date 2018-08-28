package com.wxx.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wxx.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;
	
	public BaseDaoImpl() {
		//获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得允许期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
		
	}
	
	@Override
	public void save(T t) {
		
		try {
			getHibernateTemplate().save(t);
		} catch (DataAccessException e) {
			System.out.println("出异常了");
			
			e.printStackTrace();
		}
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void delete(Serializable id) {
		T t = this.getById(id);//先取 再删
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria detachedCriteria) {
		//设置查询的聚合函数，总记录数
		detachedCriteria.setProjection(Projections.rowCount());
		
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
		
		//清空之前设置的聚合函数
		detachedCriteria.setProjection(null);
		
		if (list != null && list.size() > 0) {
			Long count = list.get(0);
			return count.intValue();
		}else {
			return null;
		}
	}

	@Override
	public List<T> getPageList(DetachedCriteria detachedCriteria, Integer start, Integer pageSize) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria, start, pageSize);
		return list;
	}

	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}
	
}
