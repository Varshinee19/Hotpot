package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.entities.Orders;

public interface IOrderService {
	public Orders placeOrder(Orders order);
	public Orders updateOrder(Orders order);
	public List<Orders> getOrdersByCustomer(int custid);
	public List<Orders> getOrdersByRestaurant(int resid);
	public Orders updateOrderStatus(int orderid);
	public String cancelOrder(int orderid);

}
