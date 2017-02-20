package com.ssh.zhu.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import com.ssh.zhu.service.*;

import net.sf.json.JSONArray;

import com.ssh.zhu.model.goods;

@Controller
public class selectGood {
	private goods goods;
	private String showGood;
	@Resource
	private goodsService goodsService;
	public goods getGood() {
		return goods;
	}
	public void setGood(goods goods) {
		this.goods = goods;
	}
	public String getShowGood() {
		return showGood;
	}
	public void setShowGood(String showGood) {
		this.showGood = showGood;
	}
	public void setGoodsService(goodsService goodsService) {
		this.goodsService = goodsService;
	}
	public String showGood() {
		List<goods> l= goodsService.queryAll();
		JSONArray ja=JSONArray.fromObject(l);
		showGood=ja.toString();
		return "showGood";
	}
}
