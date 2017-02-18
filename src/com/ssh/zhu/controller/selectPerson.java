package com.ssh.zhu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import com.ssh.zhu.model.*;
import com.ssh.zhu.service.*;

import net.sf.json.JSONObject;
@Controller
public class selectPerson {
	private String selectPerson;
	private String vipSelect;
	private person person;
	@Resource
	private personService personService;
	public void setPersonService(personService personService) {
		this.personService = personService;
	}
	public String getSelectPerson() {
		return selectPerson;
	}
	public void setSelectPerson(String selectPerson) {
		this.selectPerson = selectPerson;
	}
	public String getVipSelect() {
		return vipSelect;
	}
	public void setVipSelect(String vipSelect) {
		this.vipSelect = vipSelect;
	}
	public person getPerson() {
		return person;
	}
	public void setPerson(person person) {
		this.person = person;
	}
	public String personSelect() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String idCard=req.getParameter("idCard");
		person p=personService.getPerson(idCard);
		JSONObject jj=JSONObject.fromObject(p);
		selectPerson=jj.toString(); 	 
		 return "selectPerson";
	}
	public String vipSelect()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		String phone=req.getParameter("phone");
		person p=personService.get(phone);
		JSONObject jj=JSONObject.fromObject(p);
		vipSelect=jj.toString(); 	 
		 return "vipSelect";
	}
}
