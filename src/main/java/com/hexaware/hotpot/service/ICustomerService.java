package com.hexaware.hotpot.service;
import java.util.List;

import com.hexaware.hotpot.dto.CustomerDto;
import com.hexaware.hotpot.entities.Customer;
import com.hexaware.hotpot.entities.Orders;
import com.hexaware.hotpot.exception.CustomerNotFoundException;

public interface ICustomerService {
	
	public Customer addCustomer(CustomerDto customer);
	public Customer UpdateCustomer(CustomerDto customer,int custid) throws CustomerNotFoundException;
	public Customer getCustomerByMail(String email);
	public String deleteCustomerById(Integer custid);
	public List<Customer> getAllCustomer();
	public List<Orders> getAllOrders();
	
	
	

}
