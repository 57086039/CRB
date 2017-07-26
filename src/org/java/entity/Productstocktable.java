package org.java.entity;

/**
 * Productstocktable entity. @author MyEclipse Persistence Tools
 */

public class Productstocktable implements java.io.Serializable {

	// Fields

	private Long pid;
	private Producttable producttable;
	private String warehouse;
	private String plocation;
	private Long pnumber;
	private String remarks;

	// Constructors

	/** default constructor */
	public Productstocktable() {
	}

	/** minimal constructor */
	public Productstocktable(Long pid, Producttable producttable,
			String warehouse, String plocation) {
		this.pid = pid;
		this.producttable = producttable;
		this.warehouse = warehouse;
		this.plocation = plocation;
	}

	/** full constructor */
	public Productstocktable(Long pid, Producttable producttable,
			String warehouse, String plocation, Long pnumber, String remarks) {
		this.pid = pid;
		this.producttable = producttable;
		this.warehouse = warehouse;
		this.plocation = plocation;
		this.pnumber = pnumber;
		this.remarks = remarks;
	}

	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Producttable getProducttable() {
		return this.producttable;
	}

	public void setProducttable(Producttable producttable) {
		this.producttable = producttable;
	}

	public String getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getPlocation() {
		return this.plocation;
	}

	public void setPlocation(String plocation) {
		this.plocation = plocation;
	}

	public Long getPnumber() {
		return this.pnumber;
	}

	public void setPnumber(Long pnumber) {
		this.pnumber = pnumber;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}