package com.ssh.zhu.controller;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
@Controller
public class phoneCode {
	public void getPhoneCode()
	{
		String code="";
		for(int i=0;i<6;i++)
		{
			int num=(int)(Math.random()*10);
			code=code+num;			
		}
		try
		{
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			ServletActionContext.getResponse().getWriter().println(code);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
