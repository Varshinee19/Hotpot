package com.hexaware.hotpot.entities;

import java.util.*;

import jakarta.persistence.*;
@Entity
public class MenuCategories {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	private String categoryName;
	@OneToMany(mappedBy="menuCategory",cascade=CascadeType.ALL)
	private List<Menu> menus;
	public MenuCategories() {
		
	}
	public MenuCategories(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public MenuCategories(int categoryId, String categoryName, List<Menu> menus) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.menus = menus;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	
}
