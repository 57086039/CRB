package org.java.entity;

import java.util.Date;

/**
 * Losstable entity. @author MyEclipse Persistence Tools
 */

public class Losstable implements java.io.Serializable {

	// Fields

	private Long lossidv;
	private Clienttable clienttable;
	private String lossstate;
	private String lmeasures;
	private String lossreason;
	private Date latelydate;

	// Constructors

	/** default constructor */
	public Losstable() {
	}

	/** full constructor */
	public Losstable(Long lossidv, Clienttable clienttable, String lossstate,
			String lmeasures, String lossreason, Date latelydate) {
		this.lossidv = lossidv;
		this.clienttable = clienttable;
		this.lossstate = lossstate;
		this.lmeasures = lmeasures;
		this.lossreason = lossreason;
		this.latelydate = latelydate;
	}

	// Property accessors

	public Long getLossidv() {
		return this.lossidv;
	}

	public void setLossidv(Long lossidv) {
		this.lossidv = lossidv;
	}

	public Clienttable getClienttable() {
		return this.clienttable;
	}

	public void setClienttable(Clienttable clienttable) {
		this.clienttable = clienttable;
	}

	public String getLossstate() {
		return this.lossstate;
	}

	public void setLossstate(String lossstate) {
		this.lossstate = lossstate;
	}

	public String getLmeasures() {
		return this.lmeasures;
	}

	public void setLmeasures(String lmeasures) {
		this.lmeasures = lmeasures;
	}

	public String getLossreason() {
		return this.lossreason;
	}

	public void setLossreason(String lossreason) {
		this.lossreason = lossreason;
	}

	public Date getLatelydate() {
		return this.latelydate;
	}

	public void setLatelydate(Date latelydate) {
		this.latelydate = latelydate;
	}

}