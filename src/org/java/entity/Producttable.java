package org.java.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Producttable entity. @author MyEclipse Persistence Tools
 */

public class Producttable implements java.io.Serializable {

	// Fields

	private Long pid;
	private String pnamev;
	private String pmodel;
	private String pbatch;
	private String company;
	private Double price;
	private String remarks;
	private Set productstocktables = new HashSet(0);
	private Set orderdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Producttable() {
	}

	/** minimal constructor */
	public Producttable(Long pid, String pnamev, String pmodel, String pbatch,
			String company) {
		this.pid = pid;
		this.pnamev = pnamev;
		this.pmodel = pmodel;
		this.pbatch = pbatch;
		this.company = company;
	}

	/** full constructor */
	public Producttable(Long pid, String pnamev, String pmodel, String pbatch,
			String company, Double price, String remarks,
			Set productstocktables, Set orderdetails) {
		this.pid = pid;
		this.pnamev = pnamev;
		this.pmodel = pmodel;
		this.pbatch = pbatch;
		this.company = company;
		this.price = price;
		this.remarks = remarks;
		this.productstocktables = productstocktables;
		this.orderdetails = orderdetails;
	}

	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPnamev() {
		return this.pnamev;
	}

	public void setPnamev(String pnamev) {
		this.pnamev = pnamev;
	}

	public String getPmodel() {
		return this.pmodel;
	}

	public void setPmodel(String pmodel) {
		this.pmodel = pmodel;
	}

	public String getPbatch() {
		return this.pbatch;
	}

	public void setPbatch(String pbatch) {
		this.pbatch = pbatch;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set getProductstocktables() {
		return this.productstocktables;
	}

	public void setProductstocktables(Set productstocktables) {
		this.productstocktables = productstocktables;
	}

	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

}