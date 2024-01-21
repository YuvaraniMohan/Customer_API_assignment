package com.API.customer;

import java.sql.Date;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
    Customer findByEmail(String email);

    Customer findByOccupationAndDobAndCustomerGroup(Occupation occupation, Date dob, CustomerGroup customerGroup);


}
