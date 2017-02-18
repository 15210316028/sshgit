package com.ssh.zhu.dao;

import com.ssh.zhu.model.person;
public interface personDao {
	void insert(person person);
	person getPerson(String idCard);
	person get(String phone);
}
