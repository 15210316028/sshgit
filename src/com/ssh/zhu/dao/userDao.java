package com.ssh.zhu.dao;

import com.ssh.zhu.model.*;
public interface userDao {
	void insert(user user);	
	user getUser(String phone);
	user get(String phone,String password);
}
