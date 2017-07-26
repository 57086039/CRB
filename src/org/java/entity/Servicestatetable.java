package org.java.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Servicestatetable entity. @author MyEclipse Persistence Tools
 */

public class Servicestatetable implements java.io.Serializable {

	// Fields

	private Long ssid;
	private String sspoint;
	private Set servicetables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Servicestatetable() {
	}

	/** minimal constructor */
	public Servicestatetable(Long ssid, String sspoint) {
		this.ssid = ssid;
		this.sspoint = sspoint;
	}

	/** full constructor */
	public Servicestatetable(Long ssid, String sspoint, Set servicetables) {
		this.ssid = ssid;
		this.sspoint = sspoint;
		this.servicetables = servicetables;
	}

	// Property accessors

	public Long getSsid() {
		return this.ssid;
	}

	public void setSsid(Long ssid) {
		this.ssid = ssid;
	}

	public String getSspoint() {
		return this.sspoint;
	}

	public void setSspoint(String sspoint) {
		this.sspoint = sspoint;
	}

	public Set getServicetables() {
		return this.servicetables;
	}

	public void setServicetables(Set servicetables) {
		this.servicetables = servicetables;
	}

}