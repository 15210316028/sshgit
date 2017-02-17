package com.ssh.zhu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import com.ssh.zhu.model.*;
import com.ssh.zhu.service.*;

import net.sf.json.JSONObject;
@Controller
public class selectUser {
	private String registSelect;
	private String loginSelect;
	private user user;
	@Resource
	private userService userService;
	public void setUserService(userService userService) {
		this.userService = userService;
	}
	public String getRegistSelect() {
		return registSelect;
	}
	public void setRegistSelect(String registSelect) {
		this.registSelect = registSelect;
	}
	public String getLoginSelect() {
		return loginSelect;
	}
	public void setLoginSelect(String loginSelect) {
		this.loginSelect = loginSelect;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public String registSelect() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String phone=req.getParameter("registPhone");
		user u=userService.getUser(phone);
		req.getSession().setAttribute("user",u);
		JSONObject jj=JSONObject.fromObject(u);
		registSelect=jj.toString(); 	 
		 return "registSelect";
	}
	public String loginSelect() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String phone=req.getParameter("loginPhone");
		String password=req.getParameter("loginPassword");
		user u=userService.get(phone, password);
		req.getSession().setAttribute("user",u);
		JSONObject jj=JSONObject.fromObject(u);
		loginSelect=jj.toString(); 	 
		 return "loginSelect";
	}
}
