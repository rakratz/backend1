package com.empresa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.dto.ProductDTO;
import com.empresa.model.Product;
import com.empresa.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(this::convertToDTO);
    }

    public Optional<ProductDTO> getProductByName(String name) {
        return productRepository.findDTOByName(name);
    }

    public List<ProductDTO> getProductsByPartialName(String partialName) {
        return productRepository.findDTOByNameContaining(partialName);
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    public Optional<ProductDTO> updateProduct(Long id, ProductDTO productDTO) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product updatedProduct = updateProductFromDTO(existingProduct.get(), productDTO);
            Product savedProduct = productRepository.save(updatedProduct);
            return Optional.of(convertToDTO(savedProduct));
        } else {
            return Optional.empty();
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getQuantity(), product.getPrice());
    }

    private Product convertToEntity(ProductDTO productDTO) {
        return new Product(productDTO.id(), productDTO.name(), productDTO.quantity(), productDTO.price());
    }

    private Product updateProductFromDTO(Product product, ProductDTO productDTO) {
        product.setName(productDTO.name());
        product.setQuantity(productDTO.quantity());
        product.setPrice(productDTO.price());
        return product;
    }    
}
