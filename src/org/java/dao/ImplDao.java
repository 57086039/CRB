package org.java.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.java.entity.Systemusertable;
import org.java.util.HibernateSessionFactory;
import org.junit.Test;

public class ImplDao {
	 Session ses=HibernateSessionFactory.getSession();
	 
	 
   public Systemusertable users(String name,String pwd){
	   
	     Query quers=ses.createSQLQuery("select f.* from systemusertable f where suname=? and supwd=?").addEntity(Systemusertable.class);
	        quers.setParameter(0, name);
	        quers.setParameter(1,pwd);
	        Systemusertable users=new Systemusertable();
	        try {
	        	
	        	
	        	if(quers.uniqueResult()!=null){
	        	 users=(Systemusertable) quers.uniqueResult();
	        	}
	        	else{
	        		users=null;
	        	}
			} catch (Exception e) {
				e.printStackTrace();
			}
	         finally{	   
	        	 ses.close();
	         }
	       //  System.out.println(users.getSuid());
	        System.out.println(users.getSuid()+"sss");
	  return users;
   }
}
