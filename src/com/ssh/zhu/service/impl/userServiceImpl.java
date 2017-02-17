package com.ssh.zhu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.ssh.zhu.model.user;
import com.ssh.zhu.service.*;
import com.ssh.zhu.dao.impl.*;
@Service
public class userServiceImpl implements userService {
	@Resource
	private userDaoImpl userDaoImpl;	
	public userDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}
	public void setUserDaoImpl(userDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	@Override
	public void add(user user) {
		userDaoImpl.insert(user);
	}

	@Override
	public user getUser(String phone) {
		return userDaoImpl.getUser(phone);
	}

	@Override
	public user get(String phone, String password) {
		return userDaoImpl.get(phone, password);
	}

	@Override
	public void exid(user user) {
		userDaoImpl.update(user);
	}

}
