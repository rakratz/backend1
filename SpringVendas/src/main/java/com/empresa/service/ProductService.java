package com.empresa.service;

//ProductService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.model.Product;
import com.empresa.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

 private final ProductRepository productRepository;

 @Autowired
 public ProductService(ProductRepository productRepository) {
     this.productRepository = productRepository;
 }

 public List<Product> getAllProducts() {
     return productRepository.findAll();
 }

 public Product getProductById(Long id) {
     Optional<Product> optionalProduct = productRepository.findById(id);
     return optionalProduct.orElse(null);
 }

 public Product createProduct(Product product) {
     return productRepository.save(product);
 }

 public Product updateProduct(Long id, Product updatedProduct) {
     Optional<Product> optionalProduct = productRepository.findById(id);
     if (optionalProduct.isPresent()) {
         Product existingProduct = optionalProduct.get();
         existingProduct.setName(updatedProduct.getName());
         existingProduct.setPrice(updatedProduct.getPrice());
         // Atualizar outros campos conforme necessário
         return productRepository.save(existingProduct);
     } else {
         return null;
     }
 }

 public boolean deleteProduct(Long id) {
     Optional<Product> optionalProduct = productRepository.findById(id);
     if (optionalProduct.isPresent()) {
         productRepository.delete(optionalProduct.get());
         return true;
     } else {
         return false;
     }
 }
}

