package br.edu.ipog.model;

public class Produto {
    private Long id;
    private String nome;
    private double valor;
    // Construtores
    public Produto() {	
    }
	public Produto(Long id, String nome, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
    // getters e setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}   
}
