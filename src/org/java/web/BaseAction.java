package org.java.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.java.entity.Chancetable;
import org.java.entity.Plantable;
import org.java.entity.Systemusertable;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
    HttpServletRequest req;
    HttpServletResponse res;
    private String uname;
    private String upwd;
    private Chancetable ct;
    protected static Integer index=1;
    protected static Integer size=3;
    protected Integer count;
    protected static String clientelename="";
    protected static String coutline="";
    protected static String cointactsname="";
    private Plantable p;
	public Plantable getP() {
		return p;
	}
	public void setP(Plantable p) {
		this.p = p;
	}
	public Integer getMaxPage() {
		if(size==0){
			return 0;
		}
		return count % size == 0 ? count / size : count / size + 1;
	}
	public Chancetable getCt() {
		return ct;
	}
	public void setCt(Chancetable ct) {
		this.ct = ct;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public HttpServletRequest getReq() {
		return req;
	}
	public void setReq(HttpServletRequest req) {
		this.req = req;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.req=req;
		
		}
	@Override
	public void setServletResponse(HttpServletResponse res) {
		// TODO Auto-generated method stub
		this.res=res;
	}
	
	
	
      
}
