package org.java.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Systemusertable entity. @author MyEclipse Persistence Tools
 */

public class Systemusertable implements java.io.Serializable {

	// Fields

	private String suid;
	private Restricttable restricttable;
	private String suname;
	private String supwd;
	private Set chancetables = new HashSet(0);
	private Set clienttables = new HashSet(0);
	private Set servicehandletables = new HashSet(0);
	private Set assignmenttablesForSuid = new HashSet(0);
	private Set contacttables = new HashSet(0);
	private Set chancedistables = new HashSet(0);
	private Set servicetables = new HashSet(0);
	private Set assignmenttablesForSuids = new HashSet(0);

	// Constructors

	/** default constructor */
	public Systemusertable() {
	}

	/** minimal constructor */
	public Systemusertable(String suid, String suname, String supwd) {
		this.suid = suid;
		this.suname = suname;
		this.supwd = supwd;
	}

	/** full constructor */
	public Systemusertable(String suid, Restricttable restricttable,
			String suname, String supwd, Set chancetables, Set clienttables,
			Set servicehandletables, Set assignmenttablesForSuid,
			Set contacttables, Set chancedistables, Set servicetables,
			Set assignmenttablesForSuids) {
		this.suid = suid;
		this.restricttable = restricttable;
		this.suname = suname;
		this.supwd = supwd;
		this.chancetables = chancetables;
		this.clienttables = clienttables;
		this.servicehandletables = servicehandletables;
		this.assignmenttablesForSuid = assignmenttablesForSuid;
		this.contacttables = contacttables;
		this.chancedistables = chancedistables;
		this.servicetables = servicetables;
		this.assignmenttablesForSuids = assignmenttablesForSuids;
	}

	// Property accessors

	public String getSuid() {
		return this.suid;
	}

	public void setSuid(String suid) {
		this.suid = suid;
	}

	public Restricttable getRestricttable() {
		return this.restricttable;
	}

	public void setRestricttable(Restricttable restricttable) {
		this.restricttable = restricttable;
	}

	public String getSuname() {
		return this.suname;
	}

	public void setSuname(String suname) {
		this.suname = suname;
	}

	public String getSupwd() {
		return this.supwd;
	}

	public void setSupwd(String supwd) {
		this.supwd = supwd;
	}

	public Set getChancetables() {
		return this.chancetables;
	}

	public void setChancetables(Set chancetables) {
		this.chancetables = chancetables;
	}

	public Set getClienttables() {
		return this.clienttables;
	}

	public void setClienttables(Set clienttables) {
		this.clienttables = clienttables;
	}

	public Set getServicehandletables() {
		return this.servicehandletables;
	}

	public void setServicehandletables(Set servicehandletables) {
		this.servicehandletables = servicehandletables;
	}

	public Set getAssignmenttablesForSuid() {
		return this.assignmenttablesForSuid;
	}

	public void setAssignmenttablesForSuid(Set assignmenttablesForSuid) {
		this.assignmenttablesForSuid = assignmenttablesForSuid;
	}

	public Set getContacttables() {
		return this.contacttables;
	}

	public void setContacttables(Set contacttables) {
		this.contacttables = contacttables;
	}

	public Set getChancedistables() {
		return this.chancedistables;
	}

	public void setChancedistables(Set chancedistables) {
		this.chancedistables = chancedistables;
	}

	public Set getServicetables() {
		return this.servicetables;
	}

	public void setServicetables(Set servicetables) {
		this.servicetables = servicetables;
	}

	public Set getAssignmenttablesForSuids() {
		return this.assignmenttablesForSuids;
	}

	public void setAssignmenttablesForSuids(Set assignmenttablesForSuids) {
		this.assignmenttablesForSuids = assignmenttablesForSuids;
	}

}