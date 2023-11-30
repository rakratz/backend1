package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.model.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long>{

}
