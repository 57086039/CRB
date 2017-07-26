package org.java.entity;

import java.util.Date;

/**
 * Plantable entity. @author MyEclipse Persistence Tools
 */

public class Plantable implements java.io.Serializable {

	// Fields

	private Long planid;
	private Chancetable chancetable;
	private Date plandate;
	private String planitem;
	private String effect;

	// Constructors

	/** default constructor */
	public Plantable() {
	}

	/** minimal constructor */
	public Plantable(Long planid, String planitem) {
		this.planid = planid;
		this.planitem = planitem;
	}

	/** full constructor */
	public Plantable(Long planid, Chancetable chancetable, Date plandate,
			String planitem, String effect) {
		this.planid = planid;
		this.chancetable = chancetable;
		this.plandate = plandate;
		this.planitem = planitem;
		this.effect = effect;
	}

	// Property accessors

	public Long getPlanid() {
		return this.planid;
	}

	public void setPlanid(Long planid) {
		this.planid = planid;
	}

	public Chancetable getChancetable() {
		return this.chancetable;
	}

	public void setChancetable(Chancetable chancetable) {
		this.chancetable = chancetable;
	}

	public Date getPlandate() {
		return this.plandate;
	}

	public void setPlandate(Date plandate) {
		this.plandate = plandate;
	}

	public String getPlanitem() {
		return this.planitem;
	}

	public void setPlanitem(String planitem) {
		this.planitem = planitem;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

}