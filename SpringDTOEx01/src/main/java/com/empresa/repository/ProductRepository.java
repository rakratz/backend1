package com.empresa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.dto.ProductDTO;
import com.empresa.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<ProductDTO> findByName(String name);

    List<ProductDTO> findByNameContaining(String partialName);

    // Projeta os resultados para a interface ProductDTO
    @Query("SELECT new com.empresa.dto.ProductDTO(p.id, p.name, p.quantity, p.price) FROM Product p WHERE p.name = :name")
    Optional<ProductDTO> findDTOByName(@Param("name") String name);

    // Projeta os resultados para a interface ProductDTO
    @Query("SELECT new com.empresa.dto.ProductDTO(p.id, p.name, p.quantity, p.price) FROM Product p WHERE p.name LIKE %:partialName%")
    List<ProductDTO> findDTOByNameContaining(@Param("partialName") String partialName);
}
