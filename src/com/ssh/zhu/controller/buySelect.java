package com.ssh.zhu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ssh.zhu.service.*;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import com.ssh.zhu.model.*;
@Controller
public class buySelect {
	@Resource
	private userGoodsService userGoodsService;
	public void setUserGoodsService(userGoodsService userGoodsService) {
		this.userGoodsService = userGoodsService;
	}
	private userGoods userGoods;
	private String buySelect;
	public userGoods getUserGoods() {
		return userGoods;
	}
	public void setUserGoods(userGoods userGoods) {
		this.userGoods = userGoods;
	}
	public String getBuySelect() {
		return buySelect;
	}
	public void setBuySelect(String buySelect) {
		this.buySelect = buySelect;
	}
	public String buySelects()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		goodsService goodsService=(goodsService)ac.getBean("goodsServiceImpl");
		HttpServletRequest req=ServletActionContext.getRequest();
		String phone=req.getParameter("phone");
		String name=req.getParameter("name");
		System.out.println(name);
		goods good=goodsService.get(name);
		userGoods userGoods=userGoodsService.get(phone, good);
		JSONObject jj=JSONObject.fromObject(userGoods);
		buySelect=jj.toString();
		return "buySelect";		
	}
}
