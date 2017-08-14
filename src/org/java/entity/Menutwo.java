package org.java.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Menutwo entity. @author MyEclipse Persistence Tools
 */

public class Menutwo implements java.io.Serializable {

	// Fields

	private Byte mtid;
	private String mtname;
	private Long mtstate;
	
	
	private Set<Restricttable> list2=new HashSet<Restricttable>();
	
	public Set<Restricttable> getList2() {
		return list2;
	}

	public void setList2(Set<Restricttable> list2) {
		this.list2 = list2;
	}

	// Constructors

	/** default constructor */
	public Menutwo() {
	}

	/** minimal constructor */
	public Menutwo(Byte mtid, String mtname) {
		this.mtid = mtid;
		this.mtname = mtname;
	}

	/** full constructor */
	public Menutwo(Byte mtid, String mtname, Long mtstate) {
		this.mtid = mtid;
		this.mtname = mtname;
		this.mtstate = mtstate;
	}

	// Property accessors

	public Byte getMtid() {
		return this.mtid;
	}

	public void setMtid(Byte mtid) {
		this.mtid = mtid;
	}

	public String getMtname() {
		return this.mtname;
	}

	public void setMtname(String mtname) {
		this.mtname = mtname;
	}

	public Long getMtstate() {
		return this.mtstate;
	}

	public void setMtstate(Long mtstate) {
		this.mtstate = mtstate;
	}

}