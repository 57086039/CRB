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
import org.java.entity.Systemusertable;
import org.java.util.HibernateSessionFactory;

public class ImplAction extends BaseAction{
     ImplDao dao=new ImplDao();

	public String login(){  //登陆
		up();
		 Systemusertable users=dao.users(getUname(), getUpwd());
		   System.out.println(getUname()+" "+getUpwd());
		   marketingManagementDao  mdao= new marketingManagementDao();
		   	 
		   	 List<Object[]> managers=mdao.manager();
		   	 req.getSession().setAttribute("managers", managers); //储存所有客户经理
		   	 
		   	
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
		  
	}
	
	
	/**
	 * 
	 * 得到销售机会表
	 * ***/
	public String  markplan() throws Exception{  
		  
		
		
		marketingManagementDao mdao=new marketingManagementDao();
		  List<Chancetable> list1=mdao.resources(index,size,clientelename,coutline,cointactsname);
		System.out.println(list1.size()+"55555");
		  List<Chancetable> list=new  ArrayList<Chancetable>();
		  for (Chancetable chancetable : list1) {
			   // chancetable.setCreatedate(new SimpleDateFormat("yyyy-MM-dd").format(chancetable.getCreatedate().));
		      Date d=chancetable.getCreatedate();
		      SimpleDateFormat st=new SimpleDateFormat("yyyy年-MM月-dd日");
		        String aa= st.format(d);
		        chancetable.setTime(aa);
		      list.add(chancetable);
		  }
		   req.setAttribute("list", list);
		  
		   count=mdao.Count(clientelename,coutline,cointactsname);
		      if(count<3){
		    	  size=count;
		    	  System.out.println(size);
		      }
		     req.setAttribute("index", index);
			 req.setAttribute("size", size);			
		     req.setAttribute("count", count);
		     req.setAttribute("MaxPage",getMaxPage());
		     req.setAttribute("clientelename", clientelename);
		     req.setAttribute("coutline", coutline);
		     req.setAttribute("cointactsname",cointactsname);
		 //  req.getRequestDispatcher("../html/~sale/list.jsp").forward(req, res);
		   return "jihui";
	}
	/**
	 * 分页筛选
	 * 
	 * ****/
	public String paging() throws Exception{
		if(req.getParameter("index")!=null&&req.getParameter("index")!="")
			index=Integer.parseInt(req.getParameter("index")) ;
		return markplan();
	}
	/**
	 * 筛选
	 * */
	public String shaixuan() throws Exception{
		 //if(req.getParameter("mingcheng")!=null&&req.getParameter("mingcheng")!=""){
		  clientelename=req.getParameter("mingcheng");
	      System.out.println(clientelename);
	  //}
	  //if(req.getParameter("gaiyao")!=null&&req.getParameter("gaiyao")!="")
		  coutline=req.getParameter("gaiyao");
	  //if(req.getParameter("lianxiren")!=null&&req.getParameter("lianxiren")!="")
		  cointactsname=req.getParameter("lianxiren");
	  return markplan();
	}
	/**
	 * ajax刷新
	 * ****/
	public String shuaxin() throws Exception{
		 // size=3;
		if(req.getParameter("index")!=null&&req.getParameter("index")!="")
		index=Integer.parseInt(req.getParameter("index")) ;
		
		if(req.getParameter("size")!=null&&req.getParameter("size")!="")
		   size=Integer.parseInt(req.getParameter("size"));
			System.out.println(size+"size");
		return markplan();
		/*req.setAttribute("index", index);
		req.setAttribute("size", size);
		marketingManagementDao mdao=new marketingManagementDao();
		  List<Chancetable> list1=mdao.resources(index,size);
		  List<Chancetable> list=new  ArrayList<Chancetable>();
		  for (Chancetable chancetable : list1) {
			   // chancetable.setCreatedate(new SimpleDateFormat("yyyy-MM-dd").format(chancetable.getCreatedate().));
		      Date d=chancetable.getCreatedate();
		      SimpleDateFormat st=new SimpleDateFormat("yyyy年-MM月-dd日");
		        String aa= st.format(d);
		        chancetable.setTime(aa);
		      list.add(chancetable);
		  }
		   req.setAttribute("list", list);
		   System.out.println(list.size());
		   count=mdao.Count();
		      
		     req.setAttribute("count", count);
		     req.setAttribute("MaxPage",getMaxPage());*/
		
	}
     /*
      * 指派
      * **/
    public String zhipai(){
    	Integer   id=Integer.parseInt(req.getParameter("id")) ;
    	marketingManagementDao mdao=new marketingManagementDao();
    	   Chancetable cb=mdao.resource(id);
    	   req.setAttribute("cb", cb);
    	return "zp";
    }
    public String zhipai1() throws Exception{
    	marketingManagementDao md=new marketingManagementDao();
    	 String cid=req.getParameter("cid");
    	 String suid=req.getParameter("sele");
    	 String date=req.getParameter("date");
    	     System.out.println(cid+"rerrt"+suid+"\t"+date);
    	  md.zhipai(suid, cid, date);
    	  
    	return markplan();
    }
    /*
     * 添加销售机会表
     * **/
	public String insert() throws Exception{
		marketingManagementDao  mdao= new marketingManagementDao();
	    Date d=new Date();
	     String id=String.valueOf(d.getTime());
	     
		  id=   id.substring(id.length()-4, id.length());
	      getCt().setCid(id);
	     // System.out.println(getCt().getSystemusertable().getSuid());
	      //if(getCt().getSystemusertable().getSuid()!=null)
	      Systemusertable suser=(Systemusertable) req.getSession().getAttribute("users");
	    getCt().setSystemusertable(suser);
	     //System.out.println(getCt().getSystemusertable().getSuid());
	    if(getCt().getSystemusertable().getSuid()!=null){
	    	mdao.zhipai(getCt().getSystemusertable().getSuid(), id,getCt().getTime());
	    }
	      mdao.addChance(getCt());
	   
	    return markplan();
	}
	public String bianji(){
		  Integer cid=Integer.parseInt(req.getParameter("cid")) ;
		  marketingManagementDao dao=new marketingManagementDao();
		     Chancetable c=dao.resource(cid);
		     req.setAttribute("c", c);
		return "bianji";
	}
	/*
	 *删除销售机会表
	 * **/
	public String del() throws Exception{
		String cid=req.getParameter("cid") ;
		System.out.println(cid+"wodeid");
		 marketingManagementDao dao=new marketingManagementDao();
		 dao.del(cid);
		return markplan();
	}
	/**
	 * 修改销售机会表
	 * **/
	public String xiugai() throws Exception{
		marketingManagementDao  mdao= new marketingManagementDao();
		Systemusertable s=mdao.user(req.getParameter("uid"));
		if(getCt().getSystemusertable().getSuid()==null||getCt().getSystemusertable().getSuid()=="-1")
		getCt().setSystemusertable(s);
		if(getCt().getSystemusertable().getSuid()!=null){
	    	mdao.zhipai(getCt().getSystemusertable().getSuid(), getCt().getCid(),getCt().getTime());
	    }
		mdao.xiugai(getCt());
		return markplan();
	}
	/*
	 * 初始化
	 * **/
	 public String chushi() throws Exception{
     	index=1;
     	size=3;
         clientelename="";
         coutline="";
         cointactsname="";
     	return markplan();
     }
}
