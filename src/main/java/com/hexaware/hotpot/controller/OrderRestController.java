package com.hexaware.hotpot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotpot.dto.OrdersDto;
import com.hexaware.hotpot.entities.Orders;
import com.hexaware.hotpot.service.IOrderService;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {
	@Autowired
	IOrderService service;
	@PostMapping("/add")
	public Orders addOrder(@RequestBody OrdersDto dto) {
		return service.placeOrder(dto);
	}
	@PutMapping("/update/{orderId}")
	public Orders updateOrder(@PathVariable Integer orderId,@RequestBody OrdersDto dto) {
		return service.updateOrder(orderId,dto);
	}
	@GetMapping("/getbycustomer/{Integer customerId}")
	public List<Orders> getOrdersByCust(@PathVariable Integer customerId){
		return service.getOrdersByCustomer(customerId);
	}
	@GetMapping("/getbyrestaurant/{Integer restaurantId}")
	public List<Orders> getOrdersByRest(@PathVariable Integer restaurantId){
		return service.getOrdersByRestaurant(restaurantId);
	}
	@GetMapping("/getby")
	public List<Orders> getOrders(){
		return service.getAll();
	}
	@GetMapping("/getbyid/{orderId}")
	public Orders getById(@PathVariable Integer orderId){
		return service.getById(orderId);
	}
	@PutMapping("updatestatus/{status/{orderId}")
	public Orders updateStatus(@PathVariable String status,@PathVariable Integer orderId) {
		return service.updateOrderStatus(status, orderId);
	}
	@DeleteMapping("/delete/{orderId}")
	public String deleteOrder(@PathVariable Integer orderId) {
		return service.cancelOrder(orderId);
		
	}
	
	

}
