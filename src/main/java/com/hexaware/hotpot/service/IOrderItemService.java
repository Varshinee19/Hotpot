package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.dto.OrderItemsDto;
import com.hexaware.hotpot.entities.OrderItems;

public interface IOrderItemService {
	public OrderItems addItem(OrderItemsDto orderItem);
	public List<OrderItems> getItemsByOrder(int orderId);
	public OrderItems updateItem(Integer orderItemId,OrderItemsDto orderItem);
	public OrderItems getById(int orderItemId);
	public String removeItem(int orderItemId);

}
