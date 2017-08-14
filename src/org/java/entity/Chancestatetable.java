package org.java.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Chancestatetable entity. @author MyEclipse Persistence Tools
 */

public class Chancestatetable implements java.io.Serializable {

	// Fields

	private Integer csid;
	private String cspoint;
	private Set chancetables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Chancestatetable() {
	}

	/** minimal constructor */
	public Chancestatetable(Integer csid, String cspoint) {
		this.csid = csid;
		this.cspoint = cspoint;
	}

	/** full constructor */
	public Chancestatetable(Integer csid, String cspoint, Set chancetables) {
		this.csid = csid;
		this.cspoint = cspoint;
		this.chancetables = chancetables;
	}

	// Property accessors

	public Integer getCsid() {
		return this.csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCspoint() {
		return this.cspoint;
	}

	public void setCspoint(String cspoint) {
		this.cspoint = cspoint;
	}

	public Set getChancetables() {
		return this.chancetables;
	}

	public void setChancetables(Set chancetables) {
		this.chancetables = chancetables;
	}

}