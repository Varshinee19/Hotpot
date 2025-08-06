package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.entities.OrderItems;

public interface IOrderItemService {
	public OrderItems addItem(OrderItems orderItem);
	public List<OrderItems> getItemsByOrder(int oid);
	public OrderItems updateItem(OrderItems orderItem);
	public String removeItem(int oid);

}
