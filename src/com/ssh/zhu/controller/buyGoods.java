package com.ssh.zhu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ssh.zhu.dao.impl.userGoodsDaoImpl;
import com.ssh.zhu.model.goods;
import com.ssh.zhu.model.userGoods;
import com.ssh.zhu.service.*;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class buyGoods {
	@Resource
	private userGoodsService userGoodsService;

	public void setUserGoodsService(userGoodsService userGoodsService) {
		this.userGoodsService = userGoodsService;
	}

	public void buyGood(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		goodsService goodsService=(goodsService)ac.getBean("goodsServiceImpl");
		HttpServletRequest req=ServletActionContext.getRequest();
		String phone=req.getParameter("phone");
		String name=req.getParameter("name");
		String text=req.getParameter("inserv");
		String texts=req.getParameter("id");
		Integer id=Integer.valueOf(texts);
		System.out.println(text);
		Double inserv=Double.valueOf(text);
		goods good=goodsService.get(name);
		userGoodsDaoImpl userGoodsDaoImpl=(userGoodsDaoImpl) ac.getBean("userGoodsDaoImpl");
		System.out.println(userGoodsDaoImpl.getId());
		userGoods userGoods=(userGoods) ac.getBean("userGoods");
		userGoods.setId(userGoodsDaoImpl.getId()+1);
		System.out.println(userGoods.getId());
		userGoods.setPhone(phone);
		userGoods.setName(name);
		userGoods.setYield(good.getYield());
		userGoods.setTime(good.getTime());
		userGoods.setInserv(inserv);
		userGoodsService.buy(userGoods);
		goods goods=(goods)ac.getBean("goods");
		goods.setSurplus(good.getSurplus()-inserv);
		goods.setId(id);
		goods.setMoney(good.getMoney());
		goods.setName(name);
		goods.setTime(good.getTime());
		goods.setUrl(good.getUrl());
		goods.setYield(good.getYield());
		goodsService.exid(goods);
		try
		{
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			ServletActionContext.getResponse().getWriter().println("¹ºÂò³É¹¦");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
}
