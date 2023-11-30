package com.empresa.service;

//PaymentMethodService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.model.PaymentMethod;
import com.empresa.repository.PaymentMethodRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

 private final PaymentMethodRepository paymentMethodRepository;

 @Autowired
 public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
     this.paymentMethodRepository = paymentMethodRepository;
 }

 public List<PaymentMethod> getAllPaymentMethods() {
     return paymentMethodRepository.findAll();
 }

 public PaymentMethod getPaymentMethodById(Long id) {
     Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findById(id);
     return optionalPaymentMethod.orElse(null);
 }

 public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
     return paymentMethodRepository.save(paymentMethod);
 }

 public PaymentMethod updatePaymentMethod(Long id, PaymentMethod updatedPaymentMethod) {
     Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findById(id);
     if (optionalPaymentMethod.isPresent()) {
         PaymentMethod existingPaymentMethod = optionalPaymentMethod.get();
         existingPaymentMethod.setDescription(updatedPaymentMethod.getDescription());
         // Atualizar outros campos conforme necessário
         return paymentMethodRepository.save(existingPaymentMethod);
     } else {
         return null;
     }
 }

 public boolean deletePaymentMethod(Long id) {
     Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findById(id);
     if (optionalPaymentMethod.isPresent()) {
         paymentMethodRepository.delete(optionalPaymentMethod.get());
         return true;
     } else {
         return false;
     }
 }
}
