package com.empresa.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductDTO(
        Long id,
        @NotBlank(message = "O nome não pode estar em branco") String name,
        @Positive(message = "A quantidade deve ser maior que zero") int quantity,
        @Positive(message = "O preço deve ser maior que zero") BigDecimal price) {

    public ProductDTO {
        // Verificações adicionais podem ser realizadas no construtor, por exemplo:
        if (quantity < 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior ou igual a zero");
        }

        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preço deve ser maior ou igual a zero");
        }
    }
}