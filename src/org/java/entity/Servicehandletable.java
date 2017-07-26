package org.java.entity;

import java.util.Date;

/**
 * Servicehandletable entity. @author MyEclipse Persistence Tools
 */

public class Servicehandletable implements java.io.Serializable {

	// Fields

	private Long shid;
	private Systemusertable systemusertable;
	private Servicetable servicetable;
	private String handlecontect;
	private Date hadletime;

	// Constructors

	/** default constructor */
	public Servicehandletable() {
	}

	/** minimal constructor */
	public Servicehandletable(Long shid, String handlecontect, Date hadletime) {
		this.shid = shid;
		this.handlecontect = handlecontect;
		this.hadletime = hadletime;
	}

	/** full constructor */
	public Servicehandletable(Long shid, Systemusertable systemusertable,
			Servicetable servicetable, String handlecontect, Date hadletime) {
		this.shid = shid;
		this.systemusertable = systemusertable;
		this.servicetable = servicetable;
		this.handlecontect = handlecontect;
		this.hadletime = hadletime;
	}

	// Property accessors

	public Long getShid() {
		return this.shid;
	}

	public void setShid(Long shid) {
		this.shid = shid;
	}

	public Systemusertable getSystemusertable() {
		return this.systemusertable;
	}

	public void setSystemusertable(Systemusertable systemusertable) {
		this.systemusertable = systemusertable;
	}

	public Servicetable getServicetable() {
		return this.servicetable;
	}

	public void setServicetable(Servicetable servicetable) {
		this.servicetable = servicetable;
	}

	public String getHandlecontect() {
		return this.handlecontect;
	}

	public void setHandlecontect(String handlecontect) {
		this.handlecontect = handlecontect;
	}

	public Date getHadletime() {
		return this.hadletime;
	}

	public void setHadletime(Date hadletime) {
		this.hadletime = hadletime;
	}

}