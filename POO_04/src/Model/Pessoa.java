package Model;

public class Pessoa {
	private String nome;
	private int idade;

	// Construtor Pardrão
	public Pessoa() {
	}

	// Construtor todos argumentos
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
}
