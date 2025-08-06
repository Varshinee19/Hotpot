package com.hexaware.hotpot.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	private int orderid;
	private double totalprice;
	private String deladdress;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="custid")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="resid")
	private Restaurant restaurant;
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	private List<OrderItems> orderItems;
	public Orders() {
		
	}
	public Orders(int orderid, double totalprice, String deladdress, String status) {
		super();
		this.orderid = orderid;
		this.totalprice = totalprice;
		this.deladdress = deladdress;
		this.status = status;
	}
	public Orders(int orderid, double totalprice, String deladdress, String status, Customer customer,
			Restaurant restaurant, List<OrderItems> orderItems) {
		super();
		this.orderid = orderid;
		this.totalprice = totalprice;
		this.deladdress = deladdress;
		this.status = status;
		this.customer = customer;
		this.restaurant = restaurant;
		this.orderItems = orderItems;
	}
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getDeladdress() {
		return deladdress;
	}
	public void setDeladdress(String deladdress) {
		this.deladdress = deladdress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	

}
