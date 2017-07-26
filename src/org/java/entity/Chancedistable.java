package org.java.entity;

import java.util.Date;

/**
 * Chancedistable entity. @author MyEclipse Persistence Tools
 */

public class Chancedistable implements java.io.Serializable {

	// Fields

	private Long cdid;
	private Systemusertable systemusertable;
	private Chancetable chancetable;
	private Date allotdate;

	// Constructors

	/** default constructor */
	public Chancedistable() {
	}

	/** minimal constructor */
	public Chancedistable(Long cdid) {
		this.cdid = cdid;
	}

	/** full constructor */
	public Chancedistable(Long cdid, Systemusertable systemusertable,
			Chancetable chancetable, Date allotdate) {
		this.cdid = cdid;
		this.systemusertable = systemusertable;
		this.chancetable = chancetable;
		this.allotdate = allotdate;
	}

	// Property accessors

	public Long getCdid() {
		return this.cdid;
	}

	public void setCdid(Long cdid) {
		this.cdid = cdid;
	}

	public Systemusertable getSystemusertable() {
		return this.systemusertable;
	}

	public void setSystemusertable(Systemusertable systemusertable) {
		this.systemusertable = systemusertable;
	}

	public Chancetable getChancetable() {
		return this.chancetable;
	}

	public void setChancetable(Chancetable chancetable) {
		this.chancetable = chancetable;
	}

	public Date getAllotdate() {
		return this.allotdate;
	}

	public void setAllotdate(Date allotdate) {
		this.allotdate = allotdate;
	}

}