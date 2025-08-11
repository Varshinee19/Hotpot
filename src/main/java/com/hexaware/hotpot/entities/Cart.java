package com.hexaware.hotpot.entities;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	@OneToOne
	@JoinColumn(name="custid")
	private Customer customer;
	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL)
	private List<CartItems> cartItems;
	
	public Cart() {
		
	}
	public Cart(int cartId, Customer customer, List<CartItems> cartItems) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.cartItems = cartItems;
	}
	public int getCartid() {
		return cartId;
	}
	public void setCartid(int cartid) {
		this.cartId = cartid;
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
