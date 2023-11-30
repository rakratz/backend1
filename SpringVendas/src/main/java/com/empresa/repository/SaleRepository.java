package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
