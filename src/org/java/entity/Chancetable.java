package org.java.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Chancetable entity. @author MyEclipse Persistence Tools
 */

public class Chancetable implements java.io.Serializable {

	// Fields

	private String cid;
	private Systemusertable systemusertable;
	private Chancestatetable chancestatetable;
	private String csource;  //鏈轰細鏉ユ簮
	private String clientelename;//瀹㈡埛鍚嶇О
	private Short codds;   //褰撳墠鏈轰細鐨勬垚鍔熷嚑鐜�	
	private String coutline; //褰撳墠閿�敭鏈轰細鐨勬瑕佷俊鎭�	
	private String cointactsname; //褰撳墠鏈轰細鐨勪富瑕佽仈绯讳汉
	private String contactsphone;//鑱旂郴鐢佃瘽
	private String describe;   //瀵瑰綋鍓嶆満浼氱殑鎻忚堪
	private Date createdate;//鏈轰細鍒涘缓鐨勬椂闂�
	private Set plantables = new HashSet(0);
	private Set chancedistables = new HashSet(0);
	private String time;

	// Constructors

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	/** default constructor */
	public Chancetable() {
	}

	/** minimal constructor */
	public Chancetable(String cid, String clientelename, Short codds,
			String coutline, String describe) {
		this.cid = cid;
		this.clientelename = clientelename;
		this.codds = codds;
		this.coutline = coutline;
		this.describe = describe;
	}

	/** full constructor */
	public Chancetable(String cid, Systemusertable systemusertable,
			Chancestatetable chancestatetable, String csource,
			String clientelename, Short codds, String coutline,
			String cointactsname, String contactsphone, String describe,
			Date createdate, Set plantables, Set chancedistables) {
		this.cid = cid;
		this.systemusertable = systemusertable;
		this.chancestatetable = chancestatetable;
		this.csource = csource;
		this.clientelename = clientelename;
		this.codds = codds;
		this.coutline = coutline;
		this.cointactsname = cointactsname;
		this.contactsphone = contactsphone;
		this.describe = describe;
		this.createdate = createdate;
		this.plantables = plantables;
		this.chancedistables = chancedistables;
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Systemusertable getSystemusertable() {
		return this.systemusertable;
	}

	public void setSystemusertable(Systemusertable systemusertable) {
		this.systemusertable = systemusertable;
	}

	public Chancestatetable getChancestatetable() {
		return this.chancestatetable;
	}

	public void setChancestatetable(Chancestatetable chancestatetable) {
		this.chancestatetable = chancestatetable;
	}

	public String getCsource() {
		return this.csource;
	}

	public void setCsource(String csource) {
		this.csource = csource;
	}

	public String getClientelename() {
		return this.clientelename;
	}

	public void setClientelename(String clientelename) {
		this.clientelename = clientelename;
	}

	public Short getCodds() {
		return this.codds;
	}

	public void setCodds(Short codds) {
		this.codds = codds;
	}

	public String getCoutline() {
		return this.coutline;
	}

	public void setCoutline(String coutline) {
		this.coutline = coutline;
	}

	public String getCointactsname() {
		return this.cointactsname;
	}

	public void setCointactsname(String cointactsname) {
		this.cointactsname = cointactsname;
	}

	public String getContactsphone() {
		return this.contactsphone;
	}

	public void setContactsphone(String contactsphone) {
		this.contactsphone = contactsphone;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Set getPlantables() {
		return this.plantables;
	}

	public void setPlantables(Set plantables) {
		this.plantables = plantables;
	}

	public Set getChancedistables() {
		return this.chancedistables;
	}

	public void setChancedistables(Set chancedistables) {
		this.chancedistables = chancedistables;
	}

}