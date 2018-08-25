package com.wxx.dao;

import java.util.List;

import com.wxx.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{
	
	//根据数据字典的类型查询数据字典对象集合
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
