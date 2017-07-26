package org.java.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Ordertable entity. @author MyEclipse Persistence Tools
 */

public class Ordertable implements java.io.Serializable {

	// Fields

	private Long orderid;
	private Clienttable clienttable;
	private Date orderdate;
	private String address;
	private String orderstate;
	private Double numprice;
	private Set orderdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Ordertable() {
	}

	/** minimal constructor */
	public Ordertable(Long orderid, Clienttable clienttable, Date orderdate,
			String address, String orderstate) {
		this.orderid = orderid;
		this.clienttable = clienttable;
		this.orderdate = orderdate;
		this.address = address;
		this.orderstate = orderstate;
	}

	/** full constructor */
	public Ordertable(Long orderid, Clienttable clienttable, Date orderdate,
			String address, String orderstate, Double numprice, Set orderdetails) {
		this.orderid = orderid;
		this.clienttable = clienttable;
		this.orderdate = orderdate;
		this.address = address;
		this.orderstate = orderstate;
		this.numprice = numprice;
		this.orderdetails = orderdetails;
	}

	// Property accessors

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Clienttable getClienttable() {
		return this.clienttable;
	}

	public void setClienttable(Clienttable clienttable) {
		this.clienttable = clienttable;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrderstate() {
		return this.orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}

	public Double getNumprice() {
		return this.numprice;
	}

	public void setNumprice(Double numprice) {
		this.numprice = numprice;
	}

	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

}