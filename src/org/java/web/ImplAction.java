package org.java.web;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;

import org.java.dao.ImplDao;
import org.java.dao.marketingManagementDao;
import org.java.entity.Chancetable;
import org.java.entity.Menutable;
import org.java.entity.Menutwo;
import org.java.entity.Systemusertable;
import org.java.util.HibernateSessionFactory;

public class ImplAction extends BaseAction{
     ImplDao dao=new ImplDao();

	public String login(){  //登录
		up();
		 Systemusertable users=dao.users(getUname(), getUpwd());
		   System.out.println(getUname()+" "+getUpwd());
		if(users!=null){
			 req.getSession().setAttribute("users",users);
			req.getSession().setAttribute("munus", users.getRestricttable().getMenus());
			req.getSession().setAttribute("munus2", users.getRestricttable().getMenus2());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			for(Menutable m:users.getRestricttable().getMenus()){
				System.out.println(m.getMaction());
			}
			 return "login";
		}else{
			req.setAttribute("提示", "请先登录");
			return "index";
		}
		 
		
	}
	
	public void up() {
		   req.getSession().removeAttribute("users");
		   System.out.println("111ss");		
		    
	}
	
	
	/**
	 * 
	 * 寰楀埌閿�敭鏈轰細琛�
	 * ***/
	public String  markplan() throws Exception{  
		marketingManagementDao mdao=new marketingManagementDao();
		  List<Chancetable> list1=mdao.resources(1,3);
		  List<Chancetable> list=new  ArrayList<Chancetable>();
		  for (Chancetable chancetable : list1) {
			   // chancetable.setCreatedate(new SimpleDateFormat("yyyy-MM-dd").format(chancetable.getCreatedate().));
		      Date d=chancetable.getCreatedate();
		      SimpleDateFormat st=new SimpleDateFormat("yyyy-MM-dd");
		      String aa= st.format(d);
		      //chancetable.setTime(aa);
		      list.add(chancetable);
		  }
		   req.setAttribute("list", list);
		   System.out.println(list.size());
		 //  req.setAttribute("count", arg1);
		 //  req.getRequestDispatcher("../html/~sale/list.jsp").forward(req, res);
		   return "jihui";
	}
	/**
	 *分页
	 * 
	 * ****/
	public void paging(){
		
	}
	
	
	/**
	 * 鍔犺浇鎵�湁瀹㈡埛缁忕悊
	 * */
    public String add(){
    	marketingManagementDao  mdao= new marketingManagementDao();
   	 
   	 List<Object[]> managers=mdao.manager();
   	 req.setAttribute("managers", managers);
   	 return "add";
    }	
    /*
     * 娣诲姞閿�敭鏈轰細琛�
     * **/
	public String insert() throws Exception{
		marketingManagementDao  mdao= new marketingManagementDao();
	    Date d=new Date();
	     String id=String.valueOf(d.getTime());
	     
		  id=   id.substring(id.length()-4, id.length());
	      getCt().setCid(id);
	      System.out.println(getCt().getSystemusertable().getSuid()+"4");
	      if(getCt().getSystemusertable().getSuid()!=null)
	     getCt().setSystemusertable(mdao.user(getCt().getSystemusertable().getSuid()));
	     //System.out.println(getCt().getSystemusertable().getSuid());
	      mdao.addChance(getCt());
	   
	    return markplan();
	}
}
