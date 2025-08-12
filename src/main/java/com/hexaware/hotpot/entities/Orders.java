package com.hexaware.hotpot.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	private double totalPrice;
	private String deliveryAddress;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	@JsonBackReference
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="restaurantId")
	@JsonBackReference
	private Restaurant restaurant;
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<OrderItems> orderItems;
	public Orders() {
		
	}
	public Orders(int orderId, double totalPrice, String deliveryAddress, String status) {
		super();
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.deliveryAddress = deliveryAddress;
		this.status = status;
	}
	public Orders(int orderId, double totalPrice, String deliveryAddress, String status, Customer customer,
			Restaurant restaurant, List<OrderItems> orderItems) {
		super();
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.deliveryAddress = deliveryAddress;
		this.status = status;
		this.customer = customer;
		this.restaurant = restaurant;
		this.orderItems = orderItems;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderid(int orderId) {
		this.orderId = orderId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getDeliveryaddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
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
