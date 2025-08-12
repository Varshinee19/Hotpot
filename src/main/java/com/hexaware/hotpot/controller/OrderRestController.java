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
import com.hexaware.hotpot.exception.CustomerNotFoundException;
import com.hexaware.hotpot.exception.OrderNotExistException;
import com.hexaware.hotpot.exception.RestaurantNotFoundException;
import com.hexaware.hotpot.service.IOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {
	@Autowired
	IOrderService service;
	@PostMapping("/add/{customerId}")
	public Orders addOrder(@Valid @PathVariable Integer customerId, @RequestBody OrdersDto dto) {
		return service.placeOrder(customerId,dto);
	}
	@PutMapping("/update/{orderId}")
	public Orders updateOrder(@Valid @PathVariable Integer orderId,@RequestBody OrdersDto dto) throws OrderNotExistException {
		return service.updateOrder(orderId,dto);
	}
	@GetMapping("/getbycustomer/{customerId}")
	public List<Orders> getOrdersByCust(@PathVariable Integer customerId) throws CustomerNotFoundException{
		return service.getOrdersByCustomer(customerId);
	}
	@GetMapping("/getbyrestaurant/{restaurantId}")
	public List<Orders> getOrdersByRest(@PathVariable Integer restaurantId) throws RestaurantNotFoundException{
		return service.getOrdersByRestaurant(restaurantId);
	}
	@GetMapping("/getby")
	public List<Orders> getOrders(){
		return service.getAll();
	}
	@GetMapping("/getbyid/{orderId}")
	public Orders getById(@PathVariable Integer orderId) throws OrderNotExistException{
		return service.getById(orderId);
	}
	@PutMapping("updatestatus/{status}/{orderId}")
	public String updateStatus(@Valid @PathVariable String status,@PathVariable Integer orderId) {
		return service.updateOrderStatus(status, orderId);
	}
	@DeleteMapping("/delete/{orderId}")
	public String deleteOrder(@PathVariable Integer orderId) throws OrderNotExistException {
		return service.cancelOrder(orderId);
		
	}
	
	

}
