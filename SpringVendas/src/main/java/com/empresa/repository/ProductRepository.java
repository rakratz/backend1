package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
