package com.hexaware.hotpot.entities;

import jakarta.persistence.*;

@Entity
public class Payment {

	@Id
	private int paymentid;
	private double amount;
	private String mode;
	private String status;
	@OneToOne
	@JoinColumn(name="orderid")
	private Orders order;
	public Payment(int paymentid, double amount, String mode, String status) {
		super();
		this.paymentid = paymentid;
		this.amount = amount;
		this.mode = mode;
		this.status = status;
	}

	public Payment(int paymentid, double amount, String mode, String status, Orders order) {
		super();
		this.paymentid = paymentid;
		this.amount = amount;
		this.mode = mode;
		this.status = status;
		this.order = order;
	}

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	

	
	

}
