package com.empresa.service;

//CustomerService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.model.Customer;
import com.empresa.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

 private final CustomerRepository customerRepository;

 @Autowired
 public CustomerService(CustomerRepository customerRepository) {
     this.customerRepository = customerRepository;
 }

 public List<Customer> getAllCustomers() {
     return customerRepository.findAll();
 }

 public Customer getCustomerById(Long id) {
     Optional<Customer> optionalCustomer = customerRepository.findById(id);
     return optionalCustomer.orElse(null);
 }

 public Customer createCustomer(Customer customer) {
     return customerRepository.save(customer);
 }

 public Customer updateCustomer(Long id, Customer updatedCustomer) {
     Optional<Customer> optionalCustomer = customerRepository.findById(id);
     if (optionalCustomer.isPresent()) {
         Customer existingCustomer = optionalCustomer.get();
         existingCustomer.setName(updatedCustomer.getName());
         existingCustomer.setEmail(updatedCustomer.getEmail());
         // Atualizar outros campos conforme necessário
         return customerRepository.save(existingCustomer);
     } else {
         return null;
     }
 }

 public boolean deleteCustomer(Long id) {
     Optional<Customer> optionalCustomer = customerRepository.findById(id);
     if (optionalCustomer.isPresent()) {
         customerRepository.delete(optionalCustomer.get());
         return true;
     } else {
         return false;
     }
 }
}
