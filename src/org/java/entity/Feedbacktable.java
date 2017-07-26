package org.java.entity;

/**
 * Feedbacktable entity. @author MyEclipse Persistence Tools
 */

public class Feedbacktable implements java.io.Serializable {

	// Fields

	private Long feedid;
	private Servicetable servicetable;
	private String feedcontent;
	private Boolean feedgrade;

	// Constructors

	/** default constructor */
	public Feedbacktable() {
	}

	/** minimal constructor */
	public Feedbacktable(Long feedid, String feedcontent) {
		this.feedid = feedid;
		this.feedcontent = feedcontent;
	}

	/** full constructor */
	public Feedbacktable(Long feedid, Servicetable servicetable,
			String feedcontent, Boolean feedgrade) {
		this.feedid = feedid;
		this.servicetable = servicetable;
		this.feedcontent = feedcontent;
		this.feedgrade = feedgrade;
	}

	// Property accessors

	public Long getFeedid() {
		return this.feedid;
	}

	public void setFeedid(Long feedid) {
		this.feedid = feedid;
	}

	public Servicetable getServicetable() {
		return this.servicetable;
	}

	public void setServicetable(Servicetable servicetable) {
		this.servicetable = servicetable;
	}

	public String getFeedcontent() {
		return this.feedcontent;
	}

	public void setFeedcontent(String feedcontent) {
		this.feedcontent = feedcontent;
	}

	public Boolean getFeedgrade() {
		return this.feedgrade;
	}

	public void setFeedgrade(Boolean feedgrade) {
		this.feedgrade = feedgrade;
	}

}