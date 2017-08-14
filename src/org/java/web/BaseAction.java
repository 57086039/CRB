package org.java.web;

import java.io.UnsupportedEncodingException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.java.dao.service.serviceDao;
import org.java.entity.Assignmenttable;
import org.java.entity.Chancetable;
import org.java.entity.Clienttable;
import org.java.entity.Feedbacktable;
import org.java.entity.Filetable;
import org.java.entity.Servicehandletable;
import org.java.entity.Servicestatetable;
import org.java.entity.Servicetable;
import org.java.entity.Servicetypetable;
import org.java.entity.Systemusertable;
import org.java.util.serviceCondition;
import org.java.util.servicePage;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
    HttpServletRequest req;
    HttpServletResponse res;
    
    
    HttpSession ses;   
    protected serviceDao servicedao=new serviceDao();
    
    
    protected Servicetypetable Servicetype;
    
    protected Servicetable service;
    
    protected Servicestatetable Servicestate;
    
    protected Systemusertable Systemuser;
    
    protected Clienttable Client;
    
    
    protected Assignmenttable assignmen;
    
    
    protected servicePage servicepage;
    
    protected Servicehandletable servicehandle;
    
    
    protected Feedbacktable feedback;
    
    protected Filetable filetable;
    
    protected serviceCondition condition;
    
    
    
    
    public serviceCondition getCondition() {
		return condition;
	}
	public void setCondition(serviceCondition condition) {
		this.condition = condition;
	}
	public serviceDao getServicedao() {
		return servicedao;
	}
	public void setServicedao(serviceDao servicedao) {
		this.servicedao = servicedao;
	}
	public Servicetypetable getServicetype() {
		return Servicetype;
	}
	public void setServicetype(Servicetypetable servicetype) {
		Servicetype = servicetype;
	}
	public Servicetable getService() {
		return service;
	}
	public void setService(Servicetable service) {
		this.service = service;
	}
	public Servicestatetable getServicestate() {
		return Servicestate;
	}
	public void setServicestate(Servicestatetable servicestate) {
		Servicestate = servicestate;
	}
	public Systemusertable getSystemuser() {
		return Systemuser;
	}
	public void setSystemuser(Systemusertable systemuser) {
		Systemuser = systemuser;
	}
	public Clienttable getClient() {
		return Client;
	}
	public void setClient(Clienttable client) {
		Client = client;
	}
	public Assignmenttable getAssignmen() {
		return assignmen;
	}
	public void setAssignmen(Assignmenttable assignmen) {
		this.assignmen = assignmen;
	}
	public servicePage getServicepage() {
		return servicepage;
	}
	public void setServicepage(servicePage servicepage) {
		this.servicepage = servicepage;
	}
	public Servicehandletable getServicehandle() {
		return servicehandle;
	}
	public void setServicehandle(Servicehandletable servicehandle) {
		this.servicehandle = servicehandle;
	}
	public Feedbacktable getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedbacktable feedback) {
		this.feedback = feedback;
	}
	public Filetable getFiletable() {
		return filetable;
	}
	public void setFiletable(Filetable filetable) {
		this.filetable = filetable;
	}
	private String uname;
    private String upwd;
    private Chancetable ct;
    protected Integer index;
    protected Integer size;
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
		this.ses=req.getSession();
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void setServletResponse(HttpServletResponse res) {
		// TODO Auto-generated method stub
		this.res=res;
	}
	
	
	
      
}
