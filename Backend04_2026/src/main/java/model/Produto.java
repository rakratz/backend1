package model;

import java.math.BigDecimal;

public class Produto {

	// Atributos
	private final int id;
	private String nome;
	private BigDecimal preco;
	
	// Construtores
	public Produto() {
		this.id = 0;
	}
	
	public Produto(int id, String nome, BigDecimal preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	//Métodos Getter e Setters
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}

}
