package com.hexaware.hotpot.entities;

import jakarta.persistence.*;

@Entity
public class OrderItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	private int quantity;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="orderid")
	private Orders order;
	
    @ManyToOne
	@JoinColumn(name="menuid")
	private Menu menu;
    
    public OrderItems() {
    	
    }
	public OrderItems(int oid, int quantity, double price) {
		super();
		this.oid = oid;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItems(int oid, int quantity, double price, Orders order, Menu menu) {
		super();
		this.oid = oid;
		this.quantity = quantity;
		this.price = price;
		this.order = order;
		this.menu = menu;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	

	

}
