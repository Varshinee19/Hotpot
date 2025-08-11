package com.hexaware.hotpot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.hotpot.dto.CustomerDto;
import com.hexaware.hotpot.entities.Customer;
import com.hexaware.hotpot.entitiesenum.Role;
import com.hexaware.hotpot.exception.CustomerNotFoundException;
@SpringBootTest
class CustomerServiceImplTest {
	@Autowired
	RestTemplate rest;

	@Test
	void testAddCustomer() {
		CustomerDto dto=new CustomerDto();
		dto.setName("Alice");
		dto.setEmail("Alice123@gmail.com");
		dto.setPhone("9841844263");
		dto.setRole(Role.customer);
		ResponseEntity<CustomerDto> response=rest.postForEntity("http://localhost:8080/api/customer/add", dto,CustomerDto.class);
		CustomerDto customer=response.getBody();
		Assertions.assertNotNull(customer);

	}
	@Test
	void testUpdateCustomer() throws CustomerNotFoundException {
		CustomerDto dto=new CustomerDto();
		dto.setCustomerId(1);
		dto.setName("Cathy");
		dto.setEmail("Alice123@gmail.com");
		dto.setPhone("9841844263");
		dto.setRole(Role.customer);
		ResponseEntity<CustomerDto> response=rest.postForEntity("http://localhost:8080/api/customer/update/1", dto,CustomerDto.class);
		
		CustomerDto customer=rest.getForObject("http://localhost:8080/api/customer/getbyid/1", CustomerDto.class);
		Assertions.assertEquals("Cathy",customer.getName());

	}
	@Test
	void testDelete() {
		rest.delete("localhost:8080/api/customer/delete/1");
		Customer deleted=rest.getForObject("http://localhost.8080/api/customer/get/1",Customer.class);
		Assertions.assertEquals(null,deleted);
		
	}
	@Test
    void testGetCustomerByMail() {
        Customer customer = rest.getForObject("http://localhost:8080/api/customer/getbyemail/alice123@gmail.com", Customer.class);          
        Assertions.assertNotNull(customer);
    }
	@Test
	void testGetAll() {
		ResponseEntity<CustomerDto[]> response=rest.getForEntity("http://localhost:8080/api/customer/get", null,CustomerDto[].class);
		Assertions.assertTrue(response.getBody().length>0);
		
	}

	
	

}
