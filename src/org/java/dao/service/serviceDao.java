package org.java.dao.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.java.entity.Assignmenttable;
import org.java.entity.Clienttable;
import org.java.entity.Feedbacktable;
import org.java.entity.Filetable;
import org.java.entity.Servicehandletable;
import org.java.entity.Servicestatetable;
import org.java.entity.Servicetable;
import org.java.entity.Servicetypetable;
import org.java.entity.Systemusertable;
import org.java.util.HibernateSessionFactory;
import org.java.util.serviceCondition;
import org.java.util.servicePage;

public class serviceDao {
	
	
	/**
	 *统计查询服务总条数 
	 * @param ssid
	 * @param condition+
	 */
	public int count(Long ssid,serviceCondition condition){
		Session ses=HibernateSessionFactory.getSession();
		Criteria c = ses.createCriteria(Servicetable.class);
		Criteria clinet=ses.createCriteria(Clienttable.class);
		if(ssid!=0){
			c.add(Restrictions.eq("servicestatetable", (Servicestatetable) ses.get(Servicestatetable.class, ssid)));
		}
		if(condition.getStid()!=null&&condition.getStid()!=0){
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(condition.getStid());
			c.add(Restrictions.eq("servicetypetable", (Servicetypetable)ses.get(Servicetypetable.class, condition.getStid())));
		}
		if(condition.getStart()!=null){
		
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			c.add(Restrictions.gt("createdate", condition.getStart()));
			
		}
		
		if(condition.getEnd()!=null){
			System.out.println(condition.getEnd());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			c.add(Restrictions.lt("createdate", condition.getEnd()));
		}
		
		if(condition.getSummary()!=null&&condition.getSummary().length()>0){
			c.add(Restrictions.like("summary", condition.getSummary(),MatchMode.ANYWHERE));
		}
		if(condition.getClientname()!=null&&condition.getClientname().length()>0){
			
			clinet.add(Restrictions.like("clientname", condition.getClientname(),MatchMode.ANYWHERE));
			System.out.println(clinet.list());
			if(clinet.list().size()>0){
				c.add(Restrictions.in("clienttable",clinet.list()));
			}else{
				ses.close();
				return 0;
			}
		}
		/****** 设置查询方式，聚合查询 *******/
		c.setProjection(Projections.count("serid"));// 聚合查询
		Object val = c.uniqueResult();// 得到唯一结果
		Integer count = (Integer) val;
		ses.close();
		return count;
	}
	
	
	
	/**
	 * 根据编号删除新创建的服务
	 * @param serid		服务编号
	 */
	public void delService(Long serid){
		Session ses=HibernateSessionFactory.getSession();
		Transaction trans=ses.beginTransaction();
		ses.delete(ses.get(Servicetable.class,serid));
		trans.commit();
		ses.close();
		
	}
	
	
	
	/**
	 *创建服务 
	 * @param service
	 */
	public void addService(Servicetable service){
		Session ses=HibernateSessionFactory.getSession();
		Transaction trans=ses.beginTransaction();
		ses.save(service);
		trans.commit();
		ses.close();
	}
	
	
	
	//查询服务类型
	public List<Servicetypetable> servicetype(){
		Session ses=HibernateSessionFactory.getSession();
		Criteria c=ses.createCriteria(Servicetypetable.class);
		List<Servicetypetable> type=c.list();
		ses.close();
		return type;
	}
	
	//根据编号查询服务类型
	public Servicetypetable findByTypeid(Long tid){
		Session ses=HibernateSessionFactory.getSession();
		Servicetypetable type=(Servicetypetable) ses.get(Servicetypetable.class, tid);
		ses.close();
		return type;
	}
	
	
	//根据编号查询服务状态
	public Servicestatetable findByStateid(Long sid){
		Session ses=HibernateSessionFactory.getSession();
		Servicestatetable state=(Servicestatetable) ses.get(Servicestatetable.class, sid);
		ses.close();
		return state;
	}
	
	//根据编号查询客户
	public Clienttable findByClientid(String cid){
		Session ses=HibernateSessionFactory.getSession();
		Clienttable client=(Clienttable) ses.get(Clienttable.class, cid);
		ses.close();
		return client;
	}
	
	//根据编号查询服务
	public Servicetable findBySerid(Long serid){
		Session ses=HibernateSessionFactory.getSession();
		Servicetable service=(Servicetable) ses.get(Servicetable.class, serid);
		ses.close();
		return service;
	}
	
	
	//根据编号查询用户
	public Systemusertable findBySuid(String Suid){
		Session ses=HibernateSessionFactory.getSession();
		//System.out.println("dklasjd");
		Systemusertable user=(Systemusertable) ses.get(Systemusertable.class, Suid);
		ses.close();
		return user;
	}
	
	
	
	/**
	 * 根据服务状态查询服务
	 * @param ssid
	 * @return
	 */
	public List<Servicetable> findServicetabel(Long ssid,servicePage page,serviceCondition condition){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Session ses=HibernateSessionFactory.getSession();
		Criteria c=ses.createCriteria(Servicetable.class);
		Criteria clinet=ses.createCriteria(Clienttable.class);
		if(ssid!=0){
			c.add(Restrictions.eq("servicestatetable", (Servicestatetable) ses.get(Servicestatetable.class, ssid)));
		}
		if(condition.getStid()!=null&&condition.getStid()!=0){
			c.add(Restrictions.eq("servicetypetable", (Servicetypetable)ses.get(Servicetypetable.class, condition.getStid())));
		}
		if(condition.getStart()!=null){
		
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			c.add(Restrictions.gt("createdate", condition.getStart()));
			
		}
		
		if(condition.getEnd()!=null){
			System.out.println(condition.getEnd());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			c.add(Restrictions.lt("createdate", condition.getEnd()));
		}
		
		if(condition.getSummary()!=null&&condition.getSummary().length()>0){
			c.add(Restrictions.like("summary", condition.getSummary(),MatchMode.ANYWHERE));
		}
		if(condition.getClientname()!=null&&condition.getClientname().length()>0){
			
			clinet.add(Restrictions.like("clientname", condition.getClientname(),MatchMode.ANYWHERE));
			System.out.println(clinet.list());
			if(clinet.list().size()>0){
				c.add(Restrictions.in("clienttable",clinet.list()));
			}else{
				ses.close();
				return null;
			}
		}
		c.setFirstResult((page.getIndex()-1)*page.getPagesize());
		c.setMaxResults(page.getPagesize());
		List<Servicetable> servicelist=c.list();
		ses.close();
		return servicelist;
	}
	
	//查询所有类型为客户经理的用户
	public List<Systemusertable> findSystemuser(){
		Session ses=HibernateSessionFactory.getSession();
		String hql="select * from systemUserTable where rid=7";
		Query query=ses.createSQLQuery(hql).addEntity(Systemusertable.class);
		List<Systemusertable> list=query.list();
		ses.close();
		return list;
	}
	/**
	 * 分配服务
	 * @param a
	 */
	public void addAssignment(Assignmenttable a){
		Session ses=HibernateSessionFactory.getSession();
		Transaction trans=ses.beginTransaction();
		//System.out.println("klda;dj");
		ses.save(a);
		trans.commit();
		ses.close();
	}
	
	public Assignmenttable findAssignmentBySerid(Long serid){
		Session ses=HibernateSessionFactory.getSession();
		String hql="select *from Assignmenttable where serid=:serid";
		Query query=ses.createSQLQuery(hql).addEntity(Assignmenttable.class);
		query.setParameter("serid", serid);
		Assignmenttable assignment=(Assignmenttable) query.uniqueResult();
		ses.close();
		return assignment;
	}
	
	
	public Servicehandletable findHandleBySerid(Long serid){
		Session ses=HibernateSessionFactory.getSession();
		String hql="select *from Servicehandletable where serid=:serid order by shid";
		Query query=ses.createSQLQuery(hql).addEntity(Servicehandletable.class);
		query.setParameter("serid", serid);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Servicehandletable handle=(Servicehandletable) query.uniqueResult();
		ses.close();
		return handle;
	}
	
	public Feedbacktable findFeedbackBySerid(Long serid){
		Session ses=HibernateSessionFactory.getSession();
		String hql="select * from feedBackTable where feedgrade>=3 and serid=:serid";
		Query query=ses.createSQLQuery(hql).addEntity(Feedbacktable.class);
		query.setParameter("serid", serid);
		Feedbacktable feedback=(Feedbacktable) query.uniqueResult();
		ses.close();
		return feedback;
	}
	
	public void addServiceHandle(Servicehandletable handle){
		Session ses=HibernateSessionFactory.getSession();
		Transaction trans=ses.beginTransaction();
		ses.save(handle);
		trans.commit();
		ses.close();
	}
	
	
	/**
	 * 查询所有的分配信息
	 * @return
	 */
	public List<Assignmenttable> findAssignmenttables(){
		Session ses=HibernateSessionFactory.getSession();
		String hql="select * from AssignmentTable";
		Query query=ses.createSQLQuery(hql).addEntity(Assignmenttable.class);
		List<Assignmenttable> list=query.list();
		ses.close();
		return list;
	}
	
	
	/**
	 * 添加反馈信息
	 * @param feedback
	 */
	public void addFeedBack(Feedbacktable feedback){
		Session ses=HibernateSessionFactory.getSession();
		Transaction trans=ses.beginTransaction();
		ses.save(feedback);
		trans.commit();
		ses.close();
	}
	

}
