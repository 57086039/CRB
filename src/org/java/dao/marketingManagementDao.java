package org.java.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.java.entity.Chancetable;
import org.java.entity.Systemusertable;
import org.java.util.HibernateSessionFactory;

public class marketingManagementDao extends ImplDao{
	/**
	 * 
	 * 获取销售机会资源
	 * **/
     public List<Chancetable> resources(int index,int size){
            ses=HibernateSessionFactory.getSession();
            Criteria c=ses.createCriteria(Chancetable.class);
           // Query query=ses.createQuery("from Chancetable");
            
            c.setFirstResult((index-1)*size);
            c.setMaxResults(3);
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
 	public Integer Count(){
 		ses=HibernateSessionFactory.getSession();
 		Criteria c = ses.createCriteria(Chancetable.class);
 		c.setProjection(Projections.count("id"));
 		Object val=c.uniqueResult(); 
 		Integer count=(Integer)val;
 		return count;
 	}
     
}
