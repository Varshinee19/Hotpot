package com.hexaware.hotpot.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int resid;
	private String rname;
	private String raddress;
	private String phoneno;
	@OneToMany(mappedBy="restaurant", cascade=CascadeType.ALL)
	private List<Menu> menuItems;
	@OneToMany(mappedBy="restaurant",cascade=CascadeType.ALL)
	private List<Orders> orders;
	
	public Restaurant() {
		
	}
	public Restaurant(int resid, String rname, String raddress, String phoneno) {
		super();
		this.resid = resid;
		this.rname = rname;
		this.raddress = raddress;
		this.phoneno = phoneno;
	}

	public Restaurant(int resid, String rname, String raddress, String phoneno, List<Menu> menuItems,
			List<Orders> orders) {
		super();
		this.resid = resid;
		this.rname = rname;
		this.raddress = raddress;
		this.phoneno = phoneno;
		this.menuItems = menuItems;
		this.orders = orders;
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public List<Menu> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<Menu> menuItems) {
		this.menuItems = menuItems;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	
	
	
	
	

}
