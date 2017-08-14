package org.java.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.java.entity.Chancestatetable;
import org.java.entity.Chancetable;
import org.java.entity.Plantable;
import org.java.entity.Systemusertable;
import org.java.util.HibernateSessionFactory;
import org.junit.Test;

public class LayDeveDao extends ImplDao {
	
    public List<Map<String, Object>> LayDeve(int index,int size,String name,String coutline,String cointactsname){
    	  ses=HibernateSessionFactory.getSession();
    	  String sql="select c.*,d.allotdate shijian ,cast(c.suid as varchar(20)) as creat,cast(d.suid as varchar2(20)) as zhipai,cast(c.contactsphone as varchar2(20)) as dianhua from chanceTable c,chanceDisTable d ,chanceStateTable s  where c.cid=d.cid and s.csid=c.csid   ";
    	  if(name!=null&&name!="")
  			sql+=" and clientelename like '%"+name+"%'";
  		if(coutline!=null&&coutline!="")
  			sql+=" and coutline like like '%"+coutline+"%'";
  		if(cointactsname!=null&&cointactsname!="")  
  			sql+=" and cointactsname like '%"+cointactsname+"%'";	  
  		sql+=" order by c.cid asc ";
  	
    	  Query q=ses.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    	  
    	    q.setFirstResult((index-1)*size);
    	    q.setMaxResults(size);
    	    
    	  List<Map<String,Object>> list=q.list();
    	  System.out.println(list.size());
    	for (Map<String, Object> map : list) {
			System.out.println(map);
		}
    	ses.close();
          return list;
    }
	
	public Integer Count(String name,String coutline,String cointactsname){
		ses=HibernateSessionFactory.getSession();
		String sql="select count(*) from chanceTable c,chanceDisTable d where c.cid=d.cid ";  	 		
		if(name!=null&&name!="")
			sql+=" and clientelename like '%"+name+"%'";
		if(coutline!=null&&coutline!="")
			sql+=" and coutline like like '%"+coutline+"%'";
		if(cointactsname!=null&&cointactsname!="")  
			sql+=" and cointactsname like '%"+cointactsname+"%'";
		   
		 Query q=ses.createSQLQuery(sql);
		 Integer count=Integer.parseInt(q.uniqueResult().toString()) ;
		 ses.close();
		return count;
	}
	
	
	 /**
    	 * 制定计划根据cid查询正在开发的机会表
    	 * **/

	@Test
	public Map<String, Object> zhiding(String cid){
		  ses=HibernateSessionFactory.getSession();
    	  String sql="select c.*,d.allotdate shijian ,s.suname as chuangjianren,cast(c.suid as varchar(20)) as creat,cast(d.suid as varchar2(20)) as zhipai,cast(c.contactsphone as varchar2(20)) as dianhua from chanceTable c,chanceDisTable d ,systemusertable s  where c.cid=d.cid and s.suid=c.suid";
    	   sql+=" and c.cid="+cid;
    	  Query q=ses.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    	
          Map<String, Object> map=(Map<String, Object>) q.uniqueResult();
           String suid=(String) map.get("ZHIPAI");
           Systemusertable s= (Systemusertable) ses.get(Systemusertable.class,suid);
             map.put("XINMING", s.getSuname());
             
        		   ses.close();    	
			System.out.println(map);
		return map;
	}
	
	/**
	 * 根据cid查询开发计划信息
	 * **/
	public List<Plantable>  plan(String cid){
		    ses=HibernateSessionFactory.getSession();
		    Chancetable c=(Chancetable) ses.get(Chancetable.class, cid);
		    Criteria ci=ses.createCriteria(Plantable.class);
		     ci.add(Restrictions.eq("chancetable", c));
		     List<Plantable> lp=ci.list();
		     ses.close();
		    		return lp;
	}
	
	/**
	 * 根据pid删除开发记录表
	 * **/
	public void del(Integer pid){
		  ses=HibernateSessionFactory.getSession();
		  Transaction tran=ses.beginTransaction();
		 Plantable p=(Plantable) ses.get(Plantable.class, pid);
		
		 
		     ses.delete(p);
		   tran.commit();
		   ses.close();
		  
	}
	/**
	 * 保存
	 * **/
	public void baocun(Plantable p){
		ses=HibernateSessionFactory.getSession();
		Chancetable c=(Chancetable) ses.get(Chancetable.class, p.getChancetable().getCid());
		p.setChancetable(c);
		Transaction tran=ses.beginTransaction();
		ses.save(p);
		tran.commit();
		ses.close();
	}
}
