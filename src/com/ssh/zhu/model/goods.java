package com.ssh.zhu.model;

public class goods {
	private Integer id;//产品ID
	private String name;//产品名称
	private Double yield;//产品收益率（%）
	private String time;//产品投资期限
	private Double money;//产品投资总额
	private Double surplus;//产品可投金额（剩余）
	private String url;//路径
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Double getSurplus() {
		return surplus;
	}
	public void setSurplus(Double surplus) {
		this.surplus = surplus;
	}	
}
