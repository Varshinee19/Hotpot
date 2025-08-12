package com.hexaware.hotpot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartItemId;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="cartId")
	@JsonBackReference
	private Cart cart;
	@ManyToOne
	@JoinColumn(name="menuId")
	@JsonBackReference
	private Menu menu;
	
	public CartItems() {
		
	}
	public CartItems(int cartItemId, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
	}

	public CartItems(int cartItemId, int quantity, Cart cart, Menu menu) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.cart = cart;
		this.menu = menu;
	}
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	
    
	

}
