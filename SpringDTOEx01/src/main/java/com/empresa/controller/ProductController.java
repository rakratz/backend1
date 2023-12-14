package com.empresa.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.empresa.dto.ProductDTO;
import com.empresa.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Optional<ProductDTO> product = productService.getProductById(id);
        
        return product.map(p -> {
            URI location = URI.create("/api/products/" + p.id());
            return ResponseEntity.created(location).body(p);
        }).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<ProductDTO> saveProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO savedProduct = productService.saveProduct(productDTO);

        URI location = URI.create("/api/products/" + savedProduct.id());
        return ResponseEntity.created(location).body(savedProduct);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@Valid @PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Optional<ProductDTO> updatedProduct = productService.updateProduct(id, productDTO);

        return updatedProduct.map(p -> {
            URI location = URI.create("/api/products/" + p.id());
            return ResponseEntity.ok().location(location).body(p);
        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable String name) {
        Optional<ProductDTO> product = productService.getProductByName(name);

        return product.map(p -> {
            URI location = URI.create("/api/products/" + p.id());
            return ResponseEntity.ok().location(location).body(p);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/partialName/{partialName}")
    public ResponseEntity<List<ProductDTO>> getProductsByPartialName(@PathVariable String partialName) {
        List<ProductDTO> products = productService.getProductsByPartialName(partialName);
        return ResponseEntity.ok(products);
    }

}
