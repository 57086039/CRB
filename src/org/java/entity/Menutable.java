package org.java.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Menutable entity. @author MyEclipse Persistence Tools
 */

public class Menutable implements java.io.Serializable {

	// Fields

	private Byte mid;
	private String mname;
	private String maction;
	private Long mstate;
	
	
	private Set<Restricttable> list=new HashSet<Restricttable>();
	
	public Set<Restricttable> getList() {
		return list;
	}

	public void setList(Set<Restricttable> list) {
		this.list = list;
	}


	// Constructors

	/** default constructor */
	public Menutable() {
	}

	/** minimal constructor */
	public Menutable(Byte mid, String mname) {
		this.mid = mid;
		this.mname = mname;
	}

	/** full constructor */
	public Menutable(Byte mid, String mname, String maction, Long mstate) {
		this.mid = mid;
		this.mname = mname;
		this.maction = maction;
		this.mstate = mstate;
	}

	// Property accessors

	public Byte getMid() {
		return this.mid;
	}

	public void setMid(Byte mid) {
		this.mid = mid;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMaction() {
		return this.maction;
	}

	public void setMaction(String maction) {
		this.maction = maction;
	}

	public Long getMstate() {
		return this.mstate;
	}

	public void setMstate(Long mstate) {
		this.mstate = mstate;
	}

}