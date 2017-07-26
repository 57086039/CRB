package org.java.entity;

import java.util.Date;

/**
 * Contacttable entity. @author MyEclipse Persistence Tools
 */

public class Contacttable implements java.io.Serializable {

	// Fields

	private Long conid;
	private Systemusertable systemusertable;
	private Clienttable clienttable;
	private Date contactdate;
	private String place;
	private String coutline;
	private String remarks;
	private String detailed;

	// Constructors

	/** default constructor */
	public Contacttable() {
	}

	/** minimal constructor */
	public Contacttable(Long conid, Clienttable clienttable, Date contactdate,
			String place, String coutline) {
		this.conid = conid;
		this.clienttable = clienttable;
		this.contactdate = contactdate;
		this.place = place;
		this.coutline = coutline;
	}

	/** full constructor */
	public Contacttable(Long conid, Systemusertable systemusertable,
			Clienttable clienttable, Date contactdate, String place,
			String coutline, String remarks, String detailed) {
		this.conid = conid;
		this.systemusertable = systemusertable;
		this.clienttable = clienttable;
		this.contactdate = contactdate;
		this.place = place;
		this.coutline = coutline;
		this.remarks = remarks;
		this.detailed = detailed;
	}

	// Property accessors

	public Long getConid() {
		return this.conid;
	}

	public void setConid(Long conid) {
		this.conid = conid;
	}

	public Systemusertable getSystemusertable() {
		return this.systemusertable;
	}

	public void setSystemusertable(Systemusertable systemusertable) {
		this.systemusertable = systemusertable;
	}

	public Clienttable getClienttable() {
		return this.clienttable;
	}

	public void setClienttable(Clienttable clienttable) {
		this.clienttable = clienttable;
	}

	public Date getContactdate() {
		return this.contactdate;
	}

	public void setContactdate(Date contactdate) {
		this.contactdate = contactdate;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCoutline() {
		return this.coutline;
	}

	public void setCoutline(String coutline) {
		this.coutline = coutline;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDetailed() {
		return this.detailed;
	}

	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}

}