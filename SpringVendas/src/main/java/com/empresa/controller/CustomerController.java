package com.empresa.controller;

//CustomerController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.empresa.model.Customer;
import com.empresa.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

 private final CustomerService customerService;

 @Autowired
 public CustomerController(CustomerService customerService) {
     this.customerService = customerService;
 }

 @GetMapping
 public ResponseEntity<List<Customer>> getAllCustomers() {
     List<Customer> customers = customerService.getAllCustomers();
     return new ResponseEntity<>(customers, HttpStatus.OK);
 }

 @GetMapping("/{id}")
 public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
     Customer customer = customerService.getCustomerById(id);
     if (customer != null) {
         return new ResponseEntity<>(customer, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @PostMapping
 public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
     Customer createdCustomer = customerService.createCustomer(customer);
     return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
 }

 @PutMapping("/{id}")
 public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
     Customer customer = customerService.updateCustomer(id, updatedCustomer);
     if (customer != null) {
         return new ResponseEntity<>(customer, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
     if (customerService.deleteCustomer(id)) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
}
