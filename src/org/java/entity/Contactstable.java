package org.java.entity;

/**
 * Contactstable entity. @author MyEclipse Persistence Tools
 */

public class Contactstable implements java.io.Serializable {

	// Fields

	private Long cid;
	private String taguser;
	private Boolean tagid;
	private String gender;
	private String position;
	private String officephone;
	private String phone;
	private String remarks;

	// Constructors

	/** default constructor */
	public Contactstable() {
	}

	/** minimal constructor */
	public Contactstable(Long cid, String taguser, Boolean tagid,
			String gender, String position, String officephone) {
		this.cid = cid;
		this.taguser = taguser;
		this.tagid = tagid;
		this.gender = gender;
		this.position = position;
		this.officephone = officephone;
	}

	/** full constructor */
	public Contactstable(Long cid, String taguser, Boolean tagid,
			String gender, String position, String officephone, String phone,
			String remarks) {
		this.cid = cid;
		this.taguser = taguser;
		this.tagid = tagid;
		this.gender = gender;
		this.position = position;
		this.officephone = officephone;
		this.phone = phone;
		this.remarks = remarks;
	}

	// Property accessors

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getTaguser() {
		return this.taguser;
	}

	public void setTaguser(String taguser) {
		this.taguser = taguser;
	}

	public Boolean getTagid() {
		return this.tagid;
	}

	public void setTagid(Boolean tagid) {
		this.tagid = tagid;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getOfficephone() {
		return this.officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}