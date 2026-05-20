package model;

public class Pessoa {
	// Atributos
	protected String nome;	// Apenas as classe filhas podem acessar esse atributo
	protected int idade;
	
	// Construtor (método que inicializado quando instanciamos essa classe)
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getIdade() {
		return idade;
	}




	public void setIdade(int idade) {
		this.idade = idade;
	}




	// Métodos
	public void exibirDados() {
		System.out.println(nome + " - " + idade);
	}
	
	
}
