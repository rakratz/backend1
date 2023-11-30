package com.empresa.controller;

//ProductController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.empresa.model.Product;
import com.empresa.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

 private final ProductService productService;

 @Autowired
 public ProductController(ProductService productService) {
     this.productService = productService;
 }

 @GetMapping
 public ResponseEntity<List<Product>> getAllProducts() {
     List<Product> products = productService.getAllProducts();
     return new ResponseEntity<>(products, HttpStatus.OK);
 }

 @GetMapping("/{id}")
 public ResponseEntity<Product> getProductById(@PathVariable Long id) {
     Product product = productService.getProductById(id);
     if (product != null) {
         return new ResponseEntity<>(product, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @PostMapping
 public ResponseEntity<Product> createProduct(@RequestBody Product product) {
     Product createdProduct = productService.createProduct(product);
     return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
 }

 @PutMapping("/{id}")
 public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
     Product product = productService.updateProduct(id, updatedProduct);
     if (product != null) {
         return new ResponseEntity<>(product, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
     if (productService.deleteProduct(id)) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }
}
