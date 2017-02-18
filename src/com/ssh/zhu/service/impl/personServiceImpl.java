package com.ssh.zhu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.ssh.zhu.dao.*;
import com.ssh.zhu.model.person;
import com.ssh.zhu.service.personService;
@Service
public class personServiceImpl implements personService {
	@Resource
	private personDao personDao;
	public personDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(personDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void add(person person) {
		personDao.insert(person);
	}

	@Override
	public person getPerson(String idCard) {
		return personDao.getPerson(idCard);
	}

	@Override
	public person get(String phone) {
		return personDao.get(phone);
	}

}
