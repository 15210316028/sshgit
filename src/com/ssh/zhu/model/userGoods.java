package com.ssh.zhu.model;

public class userGoods {
	private Integer id;//记录ID
	private String phone;//账号
	private String name;//产品名称
	private Double yield;//产品收益率（%）
	private Integer time;//产品投资期限
	private Double inserv;//投资金额
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getYield() {
		return yield;
	}
	public void setYield(Double yield) {
		this.yield = yield;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Double getInserv() {
		return inserv;
	}
	public void setInserv(Double inserv) {
		this.inserv = inserv;
	}
	
}
