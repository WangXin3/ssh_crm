package com.wxx.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//增
	void save(T t);
	
	//删(对象)
	void delete(T t);
	
	//删(对象ID)
	void delete(Serializable id);
	
	//改
	void update(T t);
	
	//查(id)
	T getById(Serializable id);
	
	//查符合条件的总记录数
	Integer getTotalCount(DetachedCriteria detachedCriteria);
	
	//查分页列表数据
	List<T> getPageList(DetachedCriteria detachedCriteria, Integer start, Integer pageSize);
}
