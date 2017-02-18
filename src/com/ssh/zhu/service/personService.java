package com.ssh.zhu.service;

import com.ssh.zhu.model.person;

public interface personService {
	void add(person person);
	person getPerson(String idCard);
	person get(String phone);
}
