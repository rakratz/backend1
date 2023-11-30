package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.model.Customer;

public interface CustomerRepository extends  JpaRepository<Customer, Long>{

}
