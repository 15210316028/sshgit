package com.ssh.zhu.controller;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.ssh.zhu.service.*;
import com.ssh.zhu.model.user;
@Controller
public class registAction {
	private user user;
	@Resource(name="userServiceImpl")
	private userService userService;
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public void setUserService(userService userService) {
		this.userService = userService;
	}
	public String regist() {	
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		userService us=(userService) app.getBean("userServiceImpl");
		us.add(user);
		 return "login";
	}
//	public static void main(String[] zhu)
//	{
//		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
//		userServiceImpl us=(userServiceImpl) app.getBean("userServiceImpl");
//		user u=new user();
//		u.setPhone("12345678901");
//		us.add(u);
//	}
}
