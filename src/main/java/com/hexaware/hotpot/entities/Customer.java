package com.hexaware.hotpot.entities;

import java.util.List;

import com.hexaware.hotpot.entitiesenum.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int custid;
	private String name;
	private String email;
	private String phone;
	private String address;
	@Enumerated(EnumType.STRING)
	private Role role;
	@OneToOne(mappedBy="customer",cascade=CascadeType.ALL)
	private Cart cart;
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private List<Orders> orders;
	
	
	public Customer() {
		
	}
	
	public Customer(int custid, String name, String email, String phone, String address,Role role) {
		super();
		this.custid = custid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role=role;
	}

	public Customer(int custid, String name, String email, String phone, String address, Cart cart,
			List<Orders> orders) {
		super();
		this.custid = custid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.cart = cart;
		this.orders = orders;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", role=" + role + "]";
	}



	


	
	
	

}
