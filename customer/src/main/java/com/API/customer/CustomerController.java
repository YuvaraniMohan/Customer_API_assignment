package com.API.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	 @Autowired
	 private CustomerService customerService;

	
	 @PostMapping("/addCustomer")
	    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
	        Customer savedCustomer = customerService.saveCustomer(customer);
	        return ResponseEntity.ok(savedCustomer);
	    }

}
