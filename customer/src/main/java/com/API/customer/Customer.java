package com.API.customer;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="customer")
public class Customer {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name="name")
    private String name;

   
    @Column(unique = true,name="email")
    private String email;

    @Column(name="dob")
    private Date dob;

    
    @Column(name="occupation")
    @Enumerated(EnumType.STRING)
    private Occupation occupation;

   
    @Column(name="customer_group")
    @Enumerated(EnumType.STRING)
    private CustomerGroup customerGroup;
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name=name;
    }

	public String getEmail() {
		
		return email;
	}

	public Occupation getOccupation() {
		
		return occupation;
	}

	public Date getDob() {
		
		return dob;
	}

	public CustomerGroup getCustomerGroup() {
		
		return customerGroup;
	}

	public void setCustomerGroup(CustomerGroup customerGroup) {
		this.customerGroup=customerGroup;
		
	}

	


}
