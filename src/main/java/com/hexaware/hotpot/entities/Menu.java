package com.hexaware.hotpot.entities;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int menuid;
	private String itemname;
	private String description;
	private double price;
	private String type;
	private String image;
	private String info;
	@ManyToOne
	@JoinColumn(name="catid")
	private MenuCategories menuCategory;
	@ManyToOne
	@JoinColumn(name="restid")
	private Restaurant restaurant;
	@OneToMany(mappedBy="menu",cascade=CascadeType.ALL)
	private List<OrderItems> orderItems;
	@OneToMany(mappedBy="menu",cascade=CascadeType.ALL)
	private List<CartItems> cartItems;
	
	public Menu() {
		
	}
	
	public Menu(int menuid, String itemname, String description, double price, String type, String image, String info) {
		super();
		this.menuid = menuid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.type = type;
		this.image = image;
		this.info = info;
	}

	public Menu(int menuid, String itemname, String description, double price, String type, String image, String info,
			MenuCategories menuCategory, Restaurant restaurant, List<OrderItems> orderItems,
			List<CartItems> cartItems) {
		super();
		this.menuid = menuid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.type = type;
		this.image = image;
		this.info = info;
		this.menuCategory = menuCategory;
		this.restaurant = restaurant;
		this.orderItems = orderItems;
		this.cartItems = cartItems;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public MenuCategories getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(MenuCategories menuCategory) {
		this.menuCategory = menuCategory;
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

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
	

	

	

}
