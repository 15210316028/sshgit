package com.ssh.zhu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import com.ssh.zhu.model.user;
import com.ssh.zhu.service.userService;
import com.ssh.zhu.service.impl.userServiceImpl;

@Controller
public class vipAction {
	
	
	@Resource(name="userServiceImpl")
	private userService userService;

	public userService getUserService() {
		return userService;
	}
	public void setUserService(userService userService) {
		this.userService = userService;
	}

	private user user;
	
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}	

//	public String vipRegist()
//	{
//		HttpServletRequest req=ServletActionContext.getRequest();
//		Double money = user.getMoney();
//		user=(user) req.getSession().getAttribute("user");	
//		user.setMoney(user.getMoney()+money);
//		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
//		userServiceImpl us=(userServiceImpl) app.getBean("userServiceImpl");
//		us.exid(user);
//		System.out.println();
//		return "show";		
//	}
}
