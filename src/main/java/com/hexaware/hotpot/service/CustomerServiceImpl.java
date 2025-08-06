package com.hexaware.hotpot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.dto.CustomerDto;
import com.hexaware.hotpot.entities.Customer;
import com.hexaware.hotpot.entities.Orders;
import com.hexaware.hotpot.exception.CustomerNotFoundException;
import com.hexaware.hotpot.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	CustomerRepository repo;
	@Override
	public Customer addCustomer(CustomerDto customer) {
		Customer cust=readData(customer);
		return repo.save(cust);
		
	}
	@Override
	public Customer UpdateCustomer(CustomerDto customer,int custid) throws CustomerNotFoundException {
		Optional<Customer> optionalCust=repo.findById(custid);
		if(!optionalCust.isPresent()) {
			throw new CustomerNotFoundException("Customer not found");
		}
		Customer cust=optionalCust.get();
		cust.setName(customer.getName());
		cust.setEmail(customer.getEmail());
		cust.setAddress(customer.getAddress());
		cust.setPhone(customer.getPhone());
		cust.setRole(customer.getRole());
		return repo.save(cust);
		
	}


	@Override
	public String deleteCustomerById(Integer custid) {
		
		repo.deleteById(custid);
		return "Record deleted successfully";
	}

	
	public Customer getCustomerByMail(String email) {
		
		return repo.getByEmail(email);
	}

	
	
	public List<Customer> getAllCustomer() {
		
		return repo.findAll();
	}

	
	public List<Orders> getAllOrders() {
		
		return null;
	}
	public Customer readData(CustomerDto customer) {
		Customer cust=new Customer();
		cust.setName(customer.getName());
		cust.setEmail(customer.getEmail());
		cust.setAddress(customer.getAddress());
		cust.setPhone(customer.getPhone());
		cust.setRole(customer.getRole());
		return cust;
	}



}
