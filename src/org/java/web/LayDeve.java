package org.java.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.java.dao.LayDeveDao;
import org.java.dao.marketingManagementDao;
import org.java.entity.Plantable;

public class LayDeve extends BaseAction {
	
	public static String cid=null;
	      LayDeveDao dao=new LayDeveDao();
        public String develop(){
        	
        List<Map<String, Object>> list=dao.LayDeve(index,size,clientelename,coutline,cointactsname);	
        	req.setAttribute("list", list);
        	
        	 count=dao.Count(clientelename,coutline,cointactsname);
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
        	return "deve";
       
        }
        
        
        
        public String chushi(){
        	index=1;
        	size=3;
            clientelename="";
            coutline="";
            cointactsname="";
        	return develop();
        }
        /*
    	 * 分页筛选
    	 * 
    	 * ****/
    	public String paging() throws Exception{
    		if(req.getParameter("index")!=null&&req.getParameter("index")!="")
    			index=Integer.parseInt(req.getParameter("index")) ;
    		return develop();
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
    		return develop();
    		
    	}
    	/**
    	 * 筛选
    	 * */
    	public String shaixuan() throws Exception{
    		  clientelename=req.getParameter("mingcheng");
    	      System.out.println(clientelename);
    		  coutline=req.getParameter("gaiyao");
    		  cointactsname=req.getParameter("lianxiren");
    	  return develop();
    	}
    	
    	/**
    	 * 制定计划根据cid查询正在开发的机会表
    	 * **/
    	public String zhiding(){
    		if(req.getParameter("cid")!=null&&req.getParameter("cid")!=""){
    		  cid=req.getParameter("cid");
    		}
    		List<Plantable> lp=dao.plan(cid);
    		req.setAttribute("zd", dao.zhiding(cid));
    		req.setAttribute("lp", lp);
    		return "zd";
    	}
    	/**
    	 * 根据pid删除开发记录表
    	 * **/
    	public String del(){
    		Integer pid=Integer.parseInt(req.getParameter("pid"));
    		
    		  dao.del(pid);
    		return zhiding();
    	}
    	public String baocun(){
    	//	System.out.println(getP().getPlanitem()+"\t"+getP().getPlandate()+"\t"+getP().getChancetable());
    	   
    	    dao.baocun(getP());
    		return zhiding();
    	}
    	/**
    	 * 执行
    	 * **/
    	public String zhixing(){
    		if(req.getParameter("cid")!=null&&req.getParameter("cid")!=""){
    			cid=req.getParameter("cid");
    		}
    	req.setAttribute("zd", dao.zhiding(cid));
    	List<Plantable> lp=dao.plan(cid);	
    	req.setAttribute("lp", lp);
    	return "zx";
    	}	
    	/*
    	 * 保存执行结果
    	 * **/
    	public String jieguo(){
    		Integer pid=Integer.parseInt(req.getParameter("pid"));
    		String jieguo=req.getParameter("jieguo");
    		dao.jieguo(pid, jieguo);
    		
    	 return	zhixing();
    	}
    	/***
    	 * 编写客户信息
    	 * **/
    	public String succeed(){
    		req.setAttribute("zd", dao.zhiding(cid)); 
    		req.setAttribute("dq", dao.diqu());
    		marketingManagementDao mdao=new marketingManagementDao();
    		 req.setAttribute("system",mdao.manager());
    		return "succ";
    	}
    	public String bckh(){
    		String cid=req.getParameter("cid");
    		 Date d=new Date();
    	     String id=String.valueOf(d.getTime());
    	     
    		  id=   id.substring(id.length()-3, id.length());
    	     id="KH"+id;
    	     getClienttable().setClientid(id);
    		dao.tianjia(getClienttable());
    		dao.update(cid);
    		//System.out.println(cid+"\t"+getClienttable().getEnterprisegrade().getEgid()	);
    		//System.out.println(getClienttable().getSystemusertable().getSuid());
    	return	chushi();
    	}
    	public String zhongzhi(){
    		 String cid=req.getParameter("cid");
    		 dao.guidang(cid);
    		return chushi();
    	}
    	public String chakan(){
    		String ccid= req.getParameter("cid");
    		req.setAttribute("zd", dao.zhiding(ccid));
    		List<Plantable> lp=dao.plan(ccid);	
        	req.setAttribute("lp", lp);
    		return "chakan";
    	}
}
