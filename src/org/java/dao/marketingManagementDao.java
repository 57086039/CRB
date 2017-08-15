package org.java.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.java.entity.Chancedistable;
import org.java.entity.Chancestatetable;
import org.java.entity.Chancetable;
import org.java.entity.Systemusertable;
import org.java.util.HibernateSessionFactory;

public class marketingManagementDao extends ImplDao{
	
	/*
	 * 修改销售机会表
	 * **/
	public void xiugai(Chancetable c){
		ses=HibernateSessionFactory.getSession();
		Transaction tran=ses.beginTransaction();
		Chancestatetable s=  (Chancestatetable) ses.get(Chancestatetable.class, 2);
		 c.setChancestatetable(s);
		ses.update(c);
		tran.commit();
		ses.close();
	}
	 /*
	  * 根据id删除机会信息表
	  * **/
	public void del(String cid){
		ses=HibernateSessionFactory.getSession();
		Transaction tran=ses.beginTransaction();
		Chancetable c=(Chancetable) ses.get(Chancetable.class, cid);
		
		  ses.delete(c);
		
		tran.commit();
		ses.clear();
		
	}


	/**
	 * 指派客户经理
	 * 
	 * **/
	public void zhipai(String suid,String cid,String shijian){
		ses=HibernateSessionFactory.getSession();
		Transaction tran=ses.beginTransaction();
		//		SQLQuery sql=ses.createSQLQuery("insert into chanceDisTable values(chanceDistable_seq.Nextval,suid=:suid,shijian=:shijian,cid=:cid)");
		//		sql.setString("suid", suid);
		//		sql.setString("cid", cid);
		//		sql.setString("shijian", shijian);
		Chancedistable cd=new Chancedistable();
		Date date=new Date();
		//  SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");

		cd.setAllotdate(date);

		Chancetable cbl=(Chancetable) ses.get(Chancetable.class, cid);
		Systemusertable user=(Systemusertable) ses.get(Systemusertable.class, suid);
		cd.setChancetable(cbl);
		cd.setSystemusertable(user);
		ses.save(cd);
		tran.commit();
		ses.close();
		//Query q=ses.createQuery(" from Chancetable where cid=:cid");
		//	  q.setString("cid",cid);



	}
	/**
	 * 
	 * 根据id获得销售机会表
	 * **/
	public Chancetable resource(Integer id){
		ses=HibernateSessionFactory.getSession();
		Query q=ses.createQuery(" from Chancetable where cid=:cid");
		q.setInteger("cid",id);

		Chancetable cb=(Chancetable) q.uniqueResult();
		ses.close();
		return cb;
	}
	/**
	 * 
	 * 获取销售机会资源
	 * **/
	public List<Chancetable> resources(int index,int size,String name,String coutline,String cointactsname){
		ses=HibernateSessionFactory.getSession();
		Criteria c=ses.createCriteria(Chancetable.class);
		// Query query=ses.createQuery("from Chancetable");
		// Example e=new Example();
		if(name!=null&&name!="")
			c.add(Restrictions.ilike("clientelename", name, MatchMode.ANYWHERE));
		if(coutline!=null&&coutline!="") 
			c.add(Restrictions.ilike("coutline", coutline, MatchMode.ANYWHERE));
		if(cointactsname!=null&&cointactsname!="")  
			c.add(Restrictions.ilike("cointactsname", cointactsname, MatchMode.ANYWHERE));
		c.setFirstResult((index-1)*size);
		c.setMaxResults(size);
		c.addOrder(Order.desc("createdate"));
		Chancestatetable cs=(Chancestatetable) ses.get(Chancestatetable.class,2);
		// Example  e=Example.create(cs).enableLike(MatchMode.ANYWHERE);
		c.add(Restrictions.eq("chancestatetable", cs));
		List<Chancetable> list=c.list();
        
		ses.close();
		return list;
	}
	/**
	 * 返回所有客户经理
	 * ***/
	public List<Object[]> manager(){
		ses=HibernateSessionFactory.getSession();

		Query query=ses.createQuery("select suid,suname from Systemusertable where rid=:rid");
		query.setParameter("rid", 7L);   

		List<Object[]> managers=query.list();
		for(Object[] objs:managers){
			System.out.println(objs[0]+"\t"+objs[1]);
		}	
		return managers;
	}

	/**
	 * 添加销售机会
	 * 
	 * ***/
	public void addChance(Chancetable c){
		ses=HibernateSessionFactory.getSession();

		Transaction tran= ses.beginTransaction();
		Chancestatetable cs=(Chancestatetable) ses.get(Chancestatetable.class, 2);

		c.setChancestatetable(cs);

		// c.setSystemusertable(systemusertable);
		ses.save(c);
		tran.commit();
		ses.close();
	}
	public Systemusertable user(String id){
		ses=HibernateSessionFactory.getSession();
		Systemusertable user=(Systemusertable) ses.get(Systemusertable.class,id);
		ses.close();
		return user;

	}
	/***
	 * 总条数 
	 * **/
	public Integer Count(String name,String coutline,String cointactsname){
		ses=HibernateSessionFactory.getSession();
		Criteria c = ses.createCriteria(Chancetable.class);
		c.setProjection(Projections.count("id"));
		if(name!=null&&name!="")
			c.add(Restrictions.ilike("clientelename", name, MatchMode.ANYWHERE));
		if(coutline!=null&&coutline!="")
			c.add(Restrictions.ilike("coutline", coutline, MatchMode.ANYWHERE));
		if(cointactsname!=null&&cointactsname!="")  
			c.add(Restrictions.ilike("cointactsname", cointactsname, MatchMode.ANYWHERE));
		Chancestatetable cs=(Chancestatetable) ses.get(Chancestatetable.class,2);
		// Example  e=Example.create(cs).enableLike(MatchMode.ANYWHERE);
		c.add(Restrictions.eq("chancestatetable", cs));
		Object val=c.uniqueResult(); 
		Integer count=(Integer)val;
		return count;
	}
    
}
