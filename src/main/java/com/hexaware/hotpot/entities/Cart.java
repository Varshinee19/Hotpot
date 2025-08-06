package com.hexaware.hotpot.entities;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartid;
	@OneToOne
	@JoinColumn(name="custid")
	private Customer customer;
	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL)
	private List<CartItems> cartItems;
	
	public Cart() {
		
	}
	public Cart(int cartid, Customer customer, List<CartItems> cartItems) {
		super();
		this.cartid = cartid;
		this.customer = customer;
		this.cartItems = cartItems;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<CartItems> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	

}
