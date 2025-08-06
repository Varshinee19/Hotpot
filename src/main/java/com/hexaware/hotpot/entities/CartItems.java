package com.hexaware.hotpot.entities;

import jakarta.persistence.*;

@Entity
public class CartItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartitemid;
	private int quantity;
	@ManyToOne
	@JoinColumn(name="cartid")
	private Cart cart;
	@ManyToOne
	@JoinColumn(name="menuid")
	private Menu menu;
	
	public CartItems() {
		
	}
	public CartItems(int cartitemid, int quantity) {
		super();
		this.cartitemid = cartitemid;
		this.quantity = quantity;
	}

	public CartItems(int cartitemid, int quantity, Cart cart, Menu menu) {
		super();
		this.cartitemid = cartitemid;
		this.quantity = quantity;
		this.cart = cart;
		this.menu = menu;
	}
	public int getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
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
