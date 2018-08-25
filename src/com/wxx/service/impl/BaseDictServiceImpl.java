package com.wxx.service.impl;

import java.util.List;

import com.wxx.dao.BaseDictDao;
import com.wxx.domain.BaseDict;
import com.wxx.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao baseDictDao;
	

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return baseDictDao.getListByTypeCode(dict_type_code);
	}

}
