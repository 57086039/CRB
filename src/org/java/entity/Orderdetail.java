package org.java.entity;

/**
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */

public class Orderdetail implements java.io.Serializable {

	// Fields

	private Long orderdid;
	private Producttable producttable;
	private Ordertable ordertable;
	private Long onumber;
	private Double numprice;

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** minimal constructor */
	public Orderdetail(Long orderdid) {
		this.orderdid = orderdid;
	}

	/** full constructor */
	public Orderdetail(Long orderdid, Producttable producttable,
			Ordertable ordertable, Long onumber, Double numprice) {
		this.orderdid = orderdid;
		this.producttable = producttable;
		this.ordertable = ordertable;
		this.onumber = onumber;
		this.numprice = numprice;
	}

	// Property accessors

	public Long getOrderdid() {
		return this.orderdid;
	}

	public void setOrderdid(Long orderdid) {
		this.orderdid = orderdid;
	}

	public Producttable getProducttable() {
		return this.producttable;
	}

	public void setProducttable(Producttable producttable) {
		this.producttable = producttable;
	}

	public Ordertable getOrdertable() {
		return this.ordertable;
	}

	public void setOrdertable(Ordertable ordertable) {
		this.ordertable = ordertable;
	}

	public Long getOnumber() {
		return this.onumber;
	}

	public void setOnumber(Long onumber) {
		this.onumber = onumber;
	}

	public Double getNumprice() {
		return this.numprice;
	}

	public void setNumprice(Double numprice) {
		this.numprice = numprice;
	}

}