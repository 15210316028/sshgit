package com.ssh.zhu.model;

public class goods {
	private Integer id;//��ƷID
	private String name;//��Ʒ����
	private Double yield;//��Ʒ�����ʣ�%��
	private String time;//��ƷͶ������
	private Double money;//��ƷͶ���ܶ�
	private Double surplus;//��Ʒ��Ͷ��ʣ�ࣩ
	private String url;//·��
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
