package org.java.entity;

import java.util.Date;

/**
 * Assignmenttable entity. @author MyEclipse Persistence Tools
 */

public class Assignmenttable implements java.io.Serializable {

	// Fields

	private Long aid;
	private Systemusertable systemusertableBySuids;
	private Systemusertable systemusertableBySuid;
	private Servicetable servicetable;
	private Date allocationtime;

	// Constructors

	/** default constructor */
	public Assignmenttable() {
	}

	/** minimal constructor */
	public Assignmenttable(Long aid, Date allocationtime) {
		this.aid = aid;
		this.allocationtime = allocationtime;
	}

	/** full constructor */
	public Assignmenttable(Long aid, Systemusertable systemusertableBySuids,
			Systemusertable systemusertableBySuid, Servicetable servicetable,
			Date allocationtime) {
		this.aid = aid;
		this.systemusertableBySuids = systemusertableBySuids;
		this.systemusertableBySuid = systemusertableBySuid;
		this.servicetable = servicetable;
		this.allocationtime = allocationtime;
	}

	// Property accessors

	public Long getAid() {
		return this.aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public Systemusertable getSystemusertableBySuids() {
		return this.systemusertableBySuids;
	}

	public void setSystemusertableBySuids(Systemusertable systemusertableBySuids) {
		this.systemusertableBySuids = systemusertableBySuids;
	}

	public Systemusertable getSystemusertableBySuid() {
		return this.systemusertableBySuid;
	}

	public void setSystemusertableBySuid(Systemusertable systemusertableBySuid) {
		this.systemusertableBySuid = systemusertableBySuid;
	}

	public Servicetable getServicetable() {
		return this.servicetable;
	}

	public void setServicetable(Servicetable servicetable) {
		this.servicetable = servicetable;
	}

	public Date getAllocationtime() {
		return this.allocationtime;
	}

	public void setAllocationtime(Date allocationtime) {
		this.allocationtime = allocationtime;
	}

}