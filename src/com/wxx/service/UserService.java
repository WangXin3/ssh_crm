package com.wxx.service;

import com.wxx.domain.User;

public interface UserService {
	//登录
	User getUserByCodePassword(User u);
	
	//注册
	void saveUser(User u);
}
