package com.wxx.dao;

import com.wxx.domain.User;

public interface UserDao extends BaseDao<User>{

	//查询用户
	User getByUserCode(String usercode);

}
