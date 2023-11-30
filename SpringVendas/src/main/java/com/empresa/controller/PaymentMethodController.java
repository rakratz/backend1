package com.empresa.controller;

//PaymentMethodController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.empresa.model.PaymentMethod;
import com.empresa.service.PaymentMethodService;

import java.util.List;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {

 private final PaymentMethodService paymentMethodService;

 @Autowired
 public PaymentMethodController(PaymentMethodService paymentMethodService) {
     this.paymentMethodService = paymentMethodService;
 }

 @GetMapping
 public ResponseEntity<List<PaymentMethod>> getAllPaymentMethods() {
     List<PaymentMethod> paymentMethods = paymentMethodService.getAllPaymentMethods();
     return new ResponseEntity<>(paymentMethods, HttpStatus.OK);
 }

 @GetMapping("/{id}")
 public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable Long id) {
     PaymentMethod paymentMethod = paymentMethodService.getPaymentMethodById(id);
     if (paymentMethod != null) {
         return new ResponseEntity<>(paymentMethod, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @PostMapping
 public ResponseEntity<PaymentMethod> createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
     PaymentMethod createdPaymentMethod = paymentMethodService.createPaymentMethod(paymentMethod);
     return new ResponseEntity<>(createdPaymentMethod, HttpStatus.CREATED);
 }

 @PutMapping("/{id}")
 public ResponseEntity<PaymentMethod> updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethod updatedPaymentMethod) {
     PaymentMethod paymentMethod = paymentMethodService.updatePaymentMethod(id, updatedPaymentMethod);
     if (paymentMethod != null) {
         return new ResponseEntity<>(paymentMethod, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deletePaymentMethod(@PathVariable Long id) {
     if (paymentMethodService.deletePaymentMethod(id)) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
}

