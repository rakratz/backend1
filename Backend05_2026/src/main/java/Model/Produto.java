package Model;

import java.math.BigDecimal;

public class Produto {
	// Atributos
	private final int id; 
	private String nome;
	private BigDecimal preco;
	private int quantidade;
	
	// Construtores
	public Produto(int id, String nome, BigDecimal preco, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	// Getters and Setter
	public int getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	// Sobreposição do método ToString que herdado do Class do Java
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}
	
}
