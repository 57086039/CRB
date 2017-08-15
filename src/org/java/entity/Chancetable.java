package org.java.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Chancetable entity. @author MyEclipse Persistence Tools
 */

public class Chancetable implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Chancetable [cid=" + cid + ", systemusertable="
				+ systemusertable + ", chancestatetable=" + chancestatetable
				+ ", csource=" + csource + ", clientelename=" + clientelename
				+ ", codds=" + codds + ", coutline=" + coutline
				+ ", cointactsname=" + cointactsname + ", contactsphone="
				+ contactsphone + ", describe=" + describe + ", createdate="
				+ createdate + ", plantables=" + plantables
				+ ", chancedistables=" + chancedistables + ", time=" + time
				+ "]";
	}

	private String cid;
	private Systemusertable systemusertable;
	private Chancestatetable chancestatetable;
	private String csource;  //机会来源
	private String clientelename;//客户名称
	private Short codds;   //当前机会的成功几率
	private String coutline; //当前销售机会的概要信息
	private String cointactsname; //当前机会的主要联系人
	private String contactsphone;//联系电话
	private String describe;   //对当前机会的描述
	private Date createdate;//机会创建的时间
	private Set plantables = new HashSet(0);
	private Set chancedistables = new HashSet(0);
	private String time;

	// Constructors

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	/** default constructor */
	public Chancetable() {
	}

	/** minimal constructor */
	public Chancetable(String cid, String clientelename, Short codds,
			String coutline, String describe) {
		this.cid = cid;
		this.clientelename = clientelename;
		this.codds = codds;
		this.coutline = coutline;
		this.describe = describe;
	}

	/** full constructor */
	public Chancetable(String cid, Systemusertable systemusertable,
			Chancestatetable chancestatetable, String csource,
			String clientelename, Short codds, String coutline,
			String cointactsname, String contactsphone, String describe,
			Date createdate, Set plantables, Set chancedistables) {
		this.cid = cid;
		this.systemusertable = systemusertable;
		this.chancestatetable = chancestatetable;
		this.csource = csource;
		this.clientelename = clientelename;
		this.codds = codds;
		this.coutline = coutline;
		this.cointactsname = cointactsname;
		this.contactsphone = contactsphone;
		this.describe = describe;
		this.createdate = createdate;
		this.plantables = plantables;
		this.chancedistables = chancedistables;
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Systemusertable getSystemusertable() {
		return this.systemusertable;
	}

	public void setSystemusertable(Systemusertable systemusertable) {
		this.systemusertable = systemusertable;
	}

	public Chancestatetable getChancestatetable() {
		return this.chancestatetable;
	}

	public void setChancestatetable(Chancestatetable chancestatetable) {
		this.chancestatetable = chancestatetable;
	}

	public String getCsource() {
		return this.csource;
	}

	public void setCsource(String csource) {
		this.csource = csource;
	}

	public String getClientelename() {
		return this.clientelename;
	}

	public void setClientelename(String clientelename) {
		this.clientelename = clientelename;
	}

	public Short getCodds() {
		return this.codds;
	}

	public void setCodds(Short codds) {
		this.codds = codds;
	}

	public String getCoutline() {
		return this.coutline;
	}

	public void setCoutline(String coutline) {
		this.coutline = coutline;
	}

	public String getCointactsname() {
		return this.cointactsname;
	}

	public void setCointactsname(String cointactsname) {
		this.cointactsname = cointactsname;
	}

	public String getContactsphone() {
		return this.contactsphone;
	}

	public void setContactsphone(String contactsphone) {
		this.contactsphone = contactsphone;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Set getPlantables() {
		return this.plantables;
	}

	public void setPlantables(Set plantables) {
		this.plantables = plantables;
	}

	public Set getChancedistables() {
		return this.chancedistables;
	}

	public void setChancedistables(Set chancedistables) {
		this.chancedistables = chancedistables;
	}

}