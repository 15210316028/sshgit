package com.ssh.zhu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.ssh.zhu.model.user;
import com.ssh.zhu.service.*;
import com.ssh.zhu.dao.*;
@Service
public class userServiceImpl implements userService {
	@Resource
	private userDao userDao;	
	public userDao getUserDao() {
		return userDao;
	}

	public void setUserDao(userDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(user user) {
		userDao.insert(user);
	}

	@Override
	public user getUser(String phone) {
		return userDao.getUser(phone);
	}

	@Override
	public user get(String phone, String password) {
		return userDao.get(phone, password);
	}
}
