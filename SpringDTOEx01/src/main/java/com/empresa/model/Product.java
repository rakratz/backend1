package com.empresa.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products_tb")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;
    private BigDecimal price;

    // Construtores
    
    // Construtor padrão sem parâmetros
    public Product() {
    }
    
    // Construtores com parâmetros para criar instâncias com valores específicos
    public Product(String name) {
    	this.name = name;
    }
    
    public Product(int quantity) {
    	this.quantity = quantity;
    }
    
    public Product(BigDecimal price) {
    	this.price = price;
    }
    
    public Product(String name, int quantity) {
    	this.name = name;
    	this.quantity = quantity;
    }
    
    public Product(String name, BigDecimal price) {
    	this.name = name;
    	this.price = price;
    }
    
    public Product(int quantity, BigDecimal price) {
    	this.quantity = quantity;
    	this.price = price;
    }
    
    public Product(String name, int quantity, BigDecimal price) {
    	this.name = name;
    	this.quantity = quantity;
    	this.price = price;
    }
    
    // Construtor completo com todos os atributos
    public Product(Long id, String name, int quantity, BigDecimal price) {
    	this.id = id;
    	this.name = name;
    	this.quantity = quantity;
    	this.price = price;
    }
    
    // getters e setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	// Sobrescrita dos métodos hashCode, equals e toString para melhor manipulação de objetos
	@Override
	public int hashCode() {
		return Objects.hash(id, name, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}   
}