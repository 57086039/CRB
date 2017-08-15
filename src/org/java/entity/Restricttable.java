package org.java.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Restricttable entity. @author MyEclipse Persistence Tools
 */

public class Restricttable implements java.io.Serializable {

	// Fields

	private Byte rid;
	private String rpoint;
	private Set systemusertables = new HashSet(0);
	
	
	public Set<Menutable> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menutable> menus) {
		this.menus = menus;
	}

	// Constructors
	private Set<Menutable> menus=new HashSet<Menutable>();
	private Set<Menutwo> menus2=new HashSet<Menutwo>();
	public Set<Menutwo> getMenus2() {
		return menus2;
	}

	public void setMenus2(Set<Menutwo> menus2) {
		this.menus2 = menus2;
	}

	// Constructors

	/** default constructor */
	public Restricttable() {
	}

	/** minimal constructor */
	public Restricttable(Byte rid, String rpoint) {
		this.rid = rid;
		this.rpoint = rpoint;
	}

	/** full constructor */
	public Restricttable(Byte rid, String rpoint, Set systemusertables) {
		this.rid = rid;
		this.rpoint = rpoint;
		this.systemusertables = systemusertables;
	}

	// Property accessors

	public Byte getRid() {
		return this.rid;
	}

	public void setRid(Byte rid) {
		this.rid = rid;
	}

	public String getRpoint() {
		return this.rpoint;
	}

	public void setRpoint(String rpoint) {
		this.rpoint = rpoint;
	}

	public Set getSystemusertables() {
		return this.systemusertables;
	}

	public void setSystemusertables(Set systemusertables) {
		this.systemusertables = systemusertables;
	}

}