package com.hexaware.hotpot.security.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotpot.controller.CustomerRestController;
import com.hexaware.hotpot.entities.Customer;
import com.hexaware.hotpot.security.dto.AuthRequest;
import com.hexaware.hotpot.security.service.CustomerService;
import com.hexaware.hotpot.security.service.JwtService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private CustomerService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private static final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);

    @PostMapping("/registration/new")
    public String registerUser(@RequestBody Customer customer) {
        // Implement your user registration logic here
        // For example: userService.saveCustomer(customer);
        return service.saveCustomer(customer);
    }

    @PostMapping("/login/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

        String token = null;

        if (authentication.isAuthenticated()) {
            token = jwtService.generateToken(authRequest.getEmail());
            logger.info("Token generated: " + token);
        } else {
            logger.info("Invalid credentials");
            throw new UsernameNotFoundException("Email or Password is invalid");
        }

        return token; 
    }
}
	


