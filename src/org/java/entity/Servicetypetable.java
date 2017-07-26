package org.java.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Servicetypetable entity. @author MyEclipse Persistence Tools
 */

public class Servicetypetable implements java.io.Serializable {

	// Fields

	private Long stid;
	private String stpoint;
	private Boolean edit;
	private Long svalue;
	private Set servicetables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Servicetypetable() {
	}

	/** minimal constructor */
	public Servicetypetable(Long stid, String stpoint, Boolean edit, Long svalue) {
		this.stid = stid;
		this.stpoint = stpoint;
		this.edit = edit;
		this.svalue = svalue;
	}

	/** full constructor */
	public Servicetypetable(Long stid, String stpoint, Boolean edit,
			Long svalue, Set servicetables) {
		this.stid = stid;
		this.stpoint = stpoint;
		this.edit = edit;
		this.svalue = svalue;
		this.servicetables = servicetables;
	}

	// Property accessors

	public Long getStid() {
		return this.stid;
	}

	public void setStid(Long stid) {
		this.stid = stid;
	}

	public String getStpoint() {
		return this.stpoint;
	}

	public void setStpoint(String stpoint) {
		this.stpoint = stpoint;
	}

	public Boolean getEdit() {
		return this.edit;
	}

	public void setEdit(Boolean edit) {
		this.edit = edit;
	}

	public Long getSvalue() {
		return this.svalue;
	}

	public void setSvalue(Long svalue) {
		this.svalue = svalue;
	}

	public Set getServicetables() {
		return this.servicetables;
	}

	public void setServicetables(Set servicetables) {
		this.servicetables = servicetables;
	}

}