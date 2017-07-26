package org.java.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Enterprisegrade entity. @author MyEclipse Persistence Tools
 */

public class Enterprisegrade implements java.io.Serializable {

	// Fields

	private Byte egid;
	private String egpoint;
	private Boolean edit;
	private String evalue;
	private Set clienttables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Enterprisegrade() {
	}

	/** minimal constructor */
	public Enterprisegrade(Byte egid, String egpoint, Boolean edit,
			String evalue) {
		this.egid = egid;
		this.egpoint = egpoint;
		this.edit = edit;
		this.evalue = evalue;
	}

	/** full constructor */
	public Enterprisegrade(Byte egid, String egpoint, Boolean edit,
			String evalue, Set clienttables) {
		this.egid = egid;
		this.egpoint = egpoint;
		this.edit = edit;
		this.evalue = evalue;
		this.clienttables = clienttables;
	}

	// Property accessors

	public Byte getEgid() {
		return this.egid;
	}

	public void setEgid(Byte egid) {
		this.egid = egid;
	}

	public String getEgpoint() {
		return this.egpoint;
	}

	public void setEgpoint(String egpoint) {
		this.egpoint = egpoint;
	}

	public Boolean getEdit() {
		return this.edit;
	}

	public void setEdit(Boolean edit) {
		this.edit = edit;
	}

	public String getEvalue() {
		return this.evalue;
	}

	public void setEvalue(String evalue) {
		this.evalue = evalue;
	}

	public Set getClienttables() {
		return this.clienttables;
	}

	public void setClienttables(Set clienttables) {
		this.clienttables = clienttables;
	}

}