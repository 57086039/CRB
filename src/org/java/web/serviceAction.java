package org.java.web;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.java.entity.Assignmenttable;
import org.java.entity.Servicetable;
import org.java.entity.Servicetypetable;
import org.java.entity.Systemusertable;
import org.java.util.serviceCondition;
import org.java.util.servicePage;

public class serviceAction extends BaseAction {

	/**
	 * 加载所有服务类型
	 * @return
	 */
	public String findtype(){
		//System.out.println("dal;kda");
		List<Servicetypetable> typelist=servicedao.servicetype();
		req.setAttribute("typelist", typelist);
		return "add";
	}
	
	/*public String addService(){
		System.out.println("dal;kda");
		System.out.println("service");
		//servicedao.addService(service);
		return "add";
	}*/
	
	
	/**
	 * 根据编号删除服务
	 * @return
	 */
	public String delService(){
		Long serid=Long.parseLong(req.getParameter("serid"));
		System.out.println(serid);
		servicedao.delService(serid);
		servicepage=(servicePage) ses.getAttribute("servicepage");
		
		condition=(serviceCondition) ses.getAttribute("condition");
		return find(2l, servicepage,condition);
	}
	
	/**
	 * 处理服务
	 */
	public void handle(){
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(servicehandle.getHandlecontect());
		//System.out.println(sdf.format(servicehandle.getHadletime()));
		//System.out.println(servicehandle.getSystemusertable().getSuid());
		//System.out.println(servicehandle.getServicetable().getSerid());
		servicedao.addServiceHandle(servicehandle);
	}
	
	public void feedback(){
		System.out.println(feedback.getFeedcontent());
		System.out.println(feedback.getServicetable());
		System.out.println(feedback.getFeedgrade());
		servicedao.addFeedBack(feedback);
		
	}
	
	
	
	/**
	 * 创建新的服务信息
	 */
	public void test(){
		Long stid=Long.parseLong(req.getParameter("stid"));
		String summary=req.getParameter("summary");
		String clientid=req.getParameter("clientid");
		Long state=Long.parseLong(req.getParameter("state"));
		String srequest=req.getParameter("srequest");
		String suid=req.getParameter("suid");
		String createdate=req.getParameter("createdate");
		service=new Servicetable();
		Servicetype=servicedao.findByTypeid(stid);
		Servicestate =servicedao.findByStateid(state);
		Systemuser =(Systemusertable) ses.getAttribute("users");
		Client =servicedao.findByClientid(clientid);
		//Date date=Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(Date.valueOf(createdate)));
		service.setSerid(7L);
		service.setServicetypetable(Servicetype);
		service.setSummary(summary);
		service.setClienttable(Client);
		service.setServicestatetable(Servicestate);
		service.setSrequest(srequest);
		service.setSystemusertable(Systemuser);
		service.setCreatedate(new Date());
		
		System.out.println(service);
		System.out.println(srequest);
		System.out.println(stid+summary+clientid+state+srequest+suid+createdate);
		
		servicedao.addService(service);
	}
	
	
	/**
	 * 根据服务状态查询服务信息
	 * @param ssid
	 * @param page
	 * @return
	 */
	public String find(Long ssid,servicePage page,serviceCondition con){
		List<Servicetypetable> typelist=servicedao.servicetype();
		req.setAttribute("typelist", typelist);
		
		List<Systemusertable> userlist=servicedao.findSystemuser();
		req.setAttribute("userlist", userlist);
		
		List<Servicetable> servicelist=servicedao.findServicetabel(ssid,page,con);
		req.setAttribute("servicelist", servicelist);
		
		/*for(Servicetable s: servicelist){
			System.out.println(s.getSummary());
		}*/
		
		List<Assignmenttable> assignmentlist=servicedao.findAssignmenttables();
		
		req.setAttribute("assignmentlist", assignmentlist);
		System.out.println(">>>>>>>>>>>>>>>>>>"+page.getPagesize());
		ses.setAttribute("servicepage", page);
		ses.setAttribute("ssid", ssid);
		ses.setAttribute("condition", con);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.."+ssid);
		if(ssid==2l){
			return "service";
		}else if(ssid==3l){
			return "ServiceHandle";
		}else if(ssid==4l){
			return "feedBack";
		}else{
			return "File";
		}
	}
	
	
	/**
	 * 多条件查询
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String search() throws UnsupportedEncodingException{
		Long id=Long.parseLong(req.getParameter("id"));
		String clinetname=java.net.URLDecoder.decode(req.getParameter("clientname"),"UTF-8");
		String summary=java.net.URLDecoder.decode(req.getParameter("summary"),"UTF-8");
		//System.out.println(clinetname+"       "+summary);
		condition.setClientname(clinetname);
		condition.setSummary(summary);
		System.out.println(condition);
		Long ssid=condition.getSsid();
		servicepage=(servicePage) ses.getAttribute("servicepage");
		servicepage.setCount(servicedao.count(ssid,condition));
		
		/*ses.setAttribute("condition",condition);
		ses.setAttribute("servicepage",servicepage);*/
		find(ssid, servicepage, condition);
		if(id==2l){
			return "service";
		}else if(id==3l){
			return "ServiceHandle";
		}else if(id==4l){
			return "feedBack";
		}else{
			return "File";
		}
	}
	
	/**
	 * 加载服务信息
	 * @return
	 */
	public String findService(){
		Long ssid=Long.parseLong(req.getParameter("ssid"));
		System.out.println(ssid);
		
		condition=new serviceCondition();
		
		servicepage=new servicePage();
		
		int count=servicedao.count(ssid,condition);
		servicepage.setCount(count);
		
		System.out.println(servicedao);
		
		
		
		return find(ssid,servicepage,condition);
		
	}
	
	
	/**
	 * 点击上一页下一页后查询的服务信息
	 * @return
	 */
	public String Change(){
		Integer index=Integer.parseInt(req.getParameter("index"));
		servicepage=(servicePage) ses.getAttribute("servicepage");
		
		servicepage.setIndex(index);
		Long ssid=(Long) ses.getAttribute("ssid");
		
		condition=(serviceCondition) ses.getAttribute("condition");
		
		return find(ssid,servicepage,condition);
	}
	
	
	/**
	 * 分页查询
	 * @return
	 */
	public String pageGo(){
		Integer index=Integer.parseInt(req.getParameter("index"));
		Integer pagesize=Integer.parseInt(req.getParameter("count"));
		servicepage=(servicePage) ses.getAttribute("servicepage");
		
		servicepage.setIndex(index);
		servicepage.setPagesize(pagesize);
		Long ssid=(Long) ses.getAttribute("ssid");
		
		condition=(serviceCondition) ses.getAttribute("condition");
		
		return find(ssid,servicepage,condition);
	}
	
	
	/**
	 * 分配服务信息
	 */
	public void addAssignment(){
		Long serid=Long.parseLong(req.getParameter("serid"));
		String suids=req.getParameter("suids");
		System.out.println(serid+"       "+suids);
		assignmen=new Assignmenttable();
		//assignmen.getServicetable().setSerid(serid);
		assignmen.setServicetable(servicedao.findBySerid(serid));
		//System.out.println(servicedao.findBySuid(suids));
		assignmen.setSystemusertableBySuids(servicedao.findBySuid(suids));
		Systemuser=(Systemusertable) ses.getAttribute("users");
		assignmen.setSystemusertableBySuid(Systemuser);
		assignmen.setAllocationtime(new Date());
		System.out.println(assignmen);
		servicedao.addAssignment(assignmen);
	}
	
	
	/**
	 * 根据服务编号查询服务信息
	 * @return
	 */
	public String findAssignmentBySerid(){
		Long serid=Long.parseLong(req.getParameter("serid"));
		System.out.println(serid);
		assignmen=servicedao.findAssignmentBySerid(serid);
		req.setAttribute("assignment", assignmen);
		return "deal_detail";
	}
	
	
	/**
	 * 根据服务编号查询处理信息
	 * @return
	 */
	public String findHandleBySerid(){
		Long serid=Long.parseLong(req.getParameter("serid"));
		System.out.println(serid);
		assignmen=servicedao.findAssignmentBySerid(serid);
		servicehandle=servicedao.findHandleBySerid(serid);
		req.setAttribute("assignment", assignmen);
		req.setAttribute("handle", servicehandle);
		return "feedback_detail";
	}
	
	
	/**
	 * 根据服务编号查询反馈信息
	 * @return
	 */
	public String findFileBySerid(){
		Long serid=Long.parseLong(req.getParameter("serid"));
		System.out.println(serid);
		service=servicedao.findBySerid(serid);
		assignmen=servicedao.findAssignmentBySerid(serid);
		servicehandle=servicedao.findHandleBySerid(serid);
		feedback=servicedao.findFeedbackBySerid(serid);
		req.setAttribute("service", service);
		req.setAttribute("assignment", assignmen);
		req.setAttribute("handle", servicehandle);
		req.setAttribute("feedback", feedback);
		return "detail";
	}
}
