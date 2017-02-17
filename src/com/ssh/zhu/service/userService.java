package com.ssh.zhu.service;

import com.ssh.zhu.model.user;

public interface userService {
	void add(user user);	
	user getUser(String phone);
	user get(String phone,String password);
}
