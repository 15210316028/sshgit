package com.ssh.zhu.controller;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import com.ssh.zhu.model.person;
import com.ssh.zhu.service.personService;
@Controller
public class vipAction {
	@Resource(name="personServiceImpl")
	private personService personService;
	public personService getPersonService() {
		return personService;
	}
	public void setPersonService(personService personService) {
		this.personService = personService;
	}

	private person person;
	public person getPerson() {
		return person;
	}
	public void setPerson(person person) {
		this.person = person;
	}
	public String vipRegist()
	{
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		personService ps=(personService)app.getBean("personServiceImpl");
		ps.add(person);
		return "show";		
	}
}
