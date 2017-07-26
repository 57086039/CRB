package org.java.web;

import java.io.IOException;

import javax.servlet.ServletException;

import org.java.dao.ImplDao;
import org.java.entity.Systemusertable;

public class ImplAction extends BaseAction{
     ImplDao dao=new ImplDao();
	public String login(){  //登陆
		up();
		 Systemusertable users=dao.users(getUname(), getUpwd());
		
		if(users!=null){
			 req.getSession().setAttribute("users",users);
			 return "login";
		}else{
			req.setAttribute("tishi", "用户名或者密码！");
			return "index";
		}
		 
		
	}
	
	public void up() {
		   req.getSession().removeAttribute("users");
		   System.out.println("111ss");		
		    
	}
	
}
