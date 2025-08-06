package com.hexaware.hotpot.entities;

import java.util.*;

import jakarta.persistence.*;
@Entity
public class MenuCategories {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int catid;
	private String cname;
	@OneToMany(mappedBy="menuCategory",cascade=CascadeType.ALL)
	private List<Menu> menus;
	public MenuCategories() {
		
	}
	public MenuCategories(int catid, String cname) {
		super();
		this.catid = catid;
		this.cname = cname;
	}

	public MenuCategories(int catid, String cname, List<Menu> menus) {
		super();
		this.catid = catid;
		this.cname = cname;
		this.menus = menus;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	
}
