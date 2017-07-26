package org.java.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Servicetable entity. @author MyEclipse Persistence Tools
 */

public class Servicetable implements java.io.Serializable {

	// Fields

	private Long serid;
	private Systemusertable systemusertable;
	private Servicetypetable servicetypetable;
	private Clienttable clienttable;
	private Servicestatetable servicestatetable;
	private String summary;
	private String srequest;
	private Date createdate;
	private Set servicehandletables = new HashSet(0);
	private Set feedbacktables = new HashSet(0);
	private Set assignmenttables = new HashSet(0);
	private Set filetables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Servicetable() {
	}

	/** minimal constructor */
	public Servicetable(Long serid, Clienttable clienttable, String summary,
			String srequest, Date createdate) {
		this.serid = serid;
		this.clienttable = clienttable;
		this.summary = summary;
		this.srequest = srequest;
		this.createdate = createdate;
	}

	/** full constructor */
	public Servicetable(Long serid, Systemusertable systemusertable,
			Servicetypetable servicetypetable, Clienttable clienttable,
			Servicestatetable servicestatetable, String summary,
			String srequest, Date createdate, Set servicehandletables,
			Set feedbacktables, Set assignmenttables, Set filetables) {
		this.serid = serid;
		this.systemusertable = systemusertable;
		this.servicetypetable = servicetypetable;
		this.clienttable = clienttable;
		this.servicestatetable = servicestatetable;
		this.summary = summary;
		this.srequest = srequest;
		this.createdate = createdate;
		this.servicehandletables = servicehandletables;
		this.feedbacktables = feedbacktables;
		this.assignmenttables = assignmenttables;
		this.filetables = filetables;
	}

	// Property accessors

	public Long getSerid() {
		return this.serid;
	}

	public void setSerid(Long serid) {
		this.serid = serid;
	}

	public Systemusertable getSystemusertable() {
		return this.systemusertable;
	}

	public void setSystemusertable(Systemusertable systemusertable) {
		this.systemusertable = systemusertable;
	}

	public Servicetypetable getServicetypetable() {
		return this.servicetypetable;
	}

	public void setServicetypetable(Servicetypetable servicetypetable) {
		this.servicetypetable = servicetypetable;
	}

	public Clienttable getClienttable() {
		return this.clienttable;
	}

	public void setClienttable(Clienttable clienttable) {
		this.clienttable = clienttable;
	}

	public Servicestatetable getServicestatetable() {
		return this.servicestatetable;
	}

	public void setServicestatetable(Servicestatetable servicestatetable) {
		this.servicestatetable = servicestatetable;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSrequest() {
		return this.srequest;
	}

	public void setSrequest(String srequest) {
		this.srequest = srequest;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Set getServicehandletables() {
		return this.servicehandletables;
	}

	public void setServicehandletables(Set servicehandletables) {
		this.servicehandletables = servicehandletables;
	}

	public Set getFeedbacktables() {
		return this.feedbacktables;
	}

	public void setFeedbacktables(Set feedbacktables) {
		this.feedbacktables = feedbacktables;
	}

	public Set getAssignmenttables() {
		return this.assignmenttables;
	}

	public void setAssignmenttables(Set assignmenttables) {
		this.assignmenttables = assignmenttables;
	}

	public Set getFiletables() {
		return this.filetables;
	}

	public void setFiletables(Set filetables) {
		this.filetables = filetables;
	}

}