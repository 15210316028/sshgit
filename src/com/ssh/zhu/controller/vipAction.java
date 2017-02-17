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
	public String vipRegist()
	{
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		userServiceImpl us=(userServiceImpl) app.getBean("userServiceImpl");
		HttpServletRequest req=ServletActionContext.getRequest();
		Double money =user.getMoney();
		user u1=(user) req.getSession().getAttribute("user");	
		Double moneys = u1.getMoney()+money;
		if(0<moneys/1000&&moneys/1000<10)
			user.setKind("vip1");
		else if(0<moneys/10000&&moneys/10000<10)
			user.setKind("vip2");
		else if(0<moneys/100000&&moneys/100000<10)
			user.setKind("vip3");
		else
			user.setKind("vip4");
		user.setMoney(moneys);
		
		us.exid(user);
		System.out.println();
		return "show";		
	}
}
