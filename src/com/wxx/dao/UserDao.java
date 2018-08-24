package com.wxx.dao;

import com.wxx.domain.User;

public interface UserDao {

	//查询用户
	User getByUserCode(String usercode);
	
	//保存用户
	void save(User u);
}
