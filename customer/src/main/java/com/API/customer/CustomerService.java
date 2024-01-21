package com.API.customer;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	
	
	 @Autowired
	 private CustomerRepository customerRepository;

	    public Customer saveCustomer(Customer customer) {
	    	assignCustomerGroup(customer);
	        validateCustomerData(customer);
	        
	        return customerRepository.save(customer);
	    }

	
	 private void validateCustomerData(Customer customer) {
	        

		    if (customerRepository.findByEmail(customer.getEmail()) != null) {
	            throw new IllegalArgumentException("Email already exists");
	        }
		 
		    // Check for uniqueness of occupation, DOB, and customer group combination
		    if (customerRepository.findByOccupationAndDobAndCustomerGroup(
	                customer.getOccupation(), customer.getDob(), customer.getCustomerGroup()) != null) {
	            throw new IllegalArgumentException("Combination of occupation, DOB, and customer group must be unique");
	        }
	        // Check age to ensure the customer is not below 18
	        if (customer.getDob() != null) {
	            LocalDate currentDate = LocalDate.now();
	            int age = Period.between(customer.getDob().toLocalDate(), currentDate).getYears();

	            if (age < 18) {
	                throw new IllegalArgumentException("Customer must be at least 18 years old");
	            }
	        }
	    }
	 private void assignCustomerGroup(Customer customer) {
		 
	 String email = customer.getEmail();
     String domain = getEmailDomain(email);
     Occupation occupation = customer.getOccupation();

     if ("hikeon.tech".equalsIgnoreCase(domain)) {
         customer.setCustomerGroup(CustomerGroup.hikeon);
     } else if (occupation == Occupation.developer) {
         customer.setCustomerGroup(CustomerGroup.developer);
     } else if (occupation == Occupation.chef) {
         customer.setCustomerGroup(CustomerGroup.chef);
     } else {
         customer.setCustomerGroup(CustomerGroup.NA);
     }
 }

 private String getEmailDomain(String email) {
     int atIndex = email.lastIndexOf('@');
     if (atIndex != -1) {
         return email.substring(atIndex + 1);
     }
     return "";
 }

	 
	 
	 
	 
	

}
