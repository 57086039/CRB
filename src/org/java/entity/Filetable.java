package org.java.entity;

/**
 * Filetable entity. @author MyEclipse Persistence Tools
 */

public class Filetable implements java.io.Serializable {

	// Fields

	private Long fid;
	private Servicetable servicetable;

	// Constructors

	/** default constructor */
	public Filetable() {
	}

	/** minimal constructor */
	public Filetable(Long fid) {
		this.fid = fid;
	}

	/** full constructor */
	public Filetable(Long fid, Servicetable servicetable) {
		this.fid = fid;
		this.servicetable = servicetable;
	}

	// Property accessors

	public Long getFid() {
		return this.fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Servicetable getServicetable() {
		return this.servicetable;
	}

	public void setServicetable(Servicetable servicetable) {
		this.servicetable = servicetable;
	}

}