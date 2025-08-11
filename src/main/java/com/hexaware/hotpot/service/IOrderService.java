package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.dto.OrdersDto;
import com.hexaware.hotpot.entities.Orders;

public interface IOrderService {
	public Orders placeOrder(OrdersDto dto);
	public Orders updateOrder(Integer OrderId,OrdersDto dto);
	public List<Orders> getOrdersByCustomer(int customerId);
	public List<Orders> getOrdersByRestaurant(int restaurantId);
	public List<Orders> getAll();
	public Orders getById(int orderId);
	public Orders updateOrderStatus(String Status,int orderId);
	public String cancelOrder(int orderId);

}
