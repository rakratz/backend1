package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.model.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long>{

}
