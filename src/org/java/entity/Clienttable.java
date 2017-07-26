package org.java.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Clienttable entity. @author MyEclipse Persistence Tools
 */

public class Clienttable implements java.io.Serializable {

	// Fields

	private String clientid;
	private Systemusertable systemusertable;
	private Enterprisegrade enterprisegrade;
	private String clientname;
	private String area;
	private Boolean satisficing;
	private Boolean creditgrder;
	private String csite;
	private String postalcode;
	private String phone;
	private String fax;
	private String curl;
	private String license;
	private String legalpreson;
	private Double registeredprice;
	private Double annualprice;
	private String depositbank;
	private String banknumber;
	private String governmentnumber;
	private String centralnumber;
	private Set ordertables = new HashSet(0);
	private Set contacttables = new HashSet(0);
	private Set servicetables = new HashSet(0);
	private Set losstables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Clienttable() {
	}

	/** minimal constructor */
	public Clienttable(String clientid, String clientname, String area,
			Boolean satisficing, Boolean creditgrder, String csite,
			String postalcode, String phone, String fax, String curl,
			String legalpreson, String depositbank, String banknumber) {
		this.clientid = clientid;
		this.clientname = clientname;
		this.area = area;
		this.satisficing = satisficing;
		this.creditgrder = creditgrder;
		this.csite = csite;
		this.postalcode = postalcode;
		this.phone = phone;
		this.fax = fax;
		this.curl = curl;
		this.legalpreson = legalpreson;
		this.depositbank = depositbank;
		this.banknumber = banknumber;
	}

	/** full constructor */
	public Clienttable(String clientid, Systemusertable systemusertable,
			Enterprisegrade enterprisegrade, String clientname, String area,
			Boolean satisficing, Boolean creditgrder, String csite,
			String postalcode, String phone, String fax, String curl,
			String license, String legalpreson, Double registeredprice,
			Double annualprice, String depositbank, String banknumber,
			String governmentnumber, String centralnumber, Set ordertables,
			Set contacttables, Set servicetables, Set losstables) {
		this.clientid = clientid;
		this.systemusertable = systemusertable;
		this.enterprisegrade = enterprisegrade;
		this.clientname = clientname;
		this.area = area;
		this.satisficing = satisficing;
		this.creditgrder = creditgrder;
		this.csite = csite;
		this.postalcode = postalcode;
		this.phone = phone;
		this.fax = fax;
		this.curl = curl;
		this.license = license;
		this.legalpreson = legalpreson;
		this.registeredprice = registeredprice;
		this.annualprice = annualprice;
		this.depositbank = depositbank;
		this.banknumber = banknumber;
		this.governmentnumber = governmentnumber;
		this.centralnumber = centralnumber;
		this.ordertables = ordertables;
		this.contacttables = contacttables;
		this.servicetables = servicetables;
		this.losstables = losstables;
	}

	// Property accessors

	public String getClientid() {
		return this.clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public Systemusertable getSystemusertable() {
		return this.systemusertable;
	}

	public void setSystemusertable(Systemusertable systemusertable) {
		this.systemusertable = systemusertable;
	}

	public Enterprisegrade getEnterprisegrade() {
		return this.enterprisegrade;
	}

	public void setEnterprisegrade(Enterprisegrade enterprisegrade) {
		this.enterprisegrade = enterprisegrade;
	}

	public String getClientname() {
		return this.clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Boolean getSatisficing() {
		return this.satisficing;
	}

	public void setSatisficing(Boolean satisficing) {
		this.satisficing = satisficing;
	}

	public Boolean getCreditgrder() {
		return this.creditgrder;
	}

	public void setCreditgrder(Boolean creditgrder) {
		this.creditgrder = creditgrder;
	}

	public String getCsite() {
		return this.csite;
	}

	public void setCsite(String csite) {
		this.csite = csite;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCurl() {
		return this.curl;
	}

	public void setCurl(String curl) {
		this.curl = curl;
	}

	public String getLicense() {
		return this.license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLegalpreson() {
		return this.legalpreson;
	}

	public void setLegalpreson(String legalpreson) {
		this.legalpreson = legalpreson;
	}

	public Double getRegisteredprice() {
		return this.registeredprice;
	}

	public void setRegisteredprice(Double registeredprice) {
		this.registeredprice = registeredprice;
	}

	public Double getAnnualprice() {
		return this.annualprice;
	}

	public void setAnnualprice(Double annualprice) {
		this.annualprice = annualprice;
	}

	public String getDepositbank() {
		return this.depositbank;
	}

	public void setDepositbank(String depositbank) {
		this.depositbank = depositbank;
	}

	public String getBanknumber() {
		return this.banknumber;
	}

	public void setBanknumber(String banknumber) {
		this.banknumber = banknumber;
	}

	public String getGovernmentnumber() {
		return this.governmentnumber;
	}

	public void setGovernmentnumber(String governmentnumber) {
		this.governmentnumber = governmentnumber;
	}

	public String getCentralnumber() {
		return this.centralnumber;
	}

	public void setCentralnumber(String centralnumber) {
		this.centralnumber = centralnumber;
	}

	public Set getOrdertables() {
		return this.ordertables;
	}

	public void setOrdertables(Set ordertables) {
		this.ordertables = ordertables;
	}

	public Set getContacttables() {
		return this.contacttables;
	}

	public void setContacttables(Set contacttables) {
		this.contacttables = contacttables;
	}

	public Set getServicetables() {
		return this.servicetables;
	}

	public void setServicetables(Set servicetables) {
		this.servicetables = servicetables;
	}

	public Set getLosstables() {
		return this.losstables;
	}

	public void setLosstables(Set losstables) {
		this.losstables = losstables;
	}

}