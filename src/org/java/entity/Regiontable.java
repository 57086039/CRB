package org.java.entity;

/**
 * Regiontable entity. @author MyEclipse Persistence Tools
 */

public class Regiontable implements java.io.Serializable {

	// Fields

	private Long rid;
	private String rpoint;
	private Boolean edit;
	private Long rvalue;

	// Constructors

	/** default constructor */
	public Regiontable() {
	}

	/** full constructor */
	public Regiontable(Long rid, String rpoint, Boolean edit, Long rvalue) {
		this.rid = rid;
		this.rpoint = rpoint;
		this.edit = edit;
		this.rvalue = rvalue;
	}

	// Property accessors

	public Long getRid() {
		return this.rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getRpoint() {
		return this.rpoint;
	}

	public void setRpoint(String rpoint) {
		this.rpoint = rpoint;
	}

	public Boolean getEdit() {
		return this.edit;
	}

	public void setEdit(Boolean edit) {
		this.edit = edit;
	}

	public Long getRvalue() {
		return this.rvalue;
	}

	public void setRvalue(Long rvalue) {
		this.rvalue = rvalue;
	}

}