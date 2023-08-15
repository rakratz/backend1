package ipog.edu.br.model;

public class Aluno {

	String nome;
	int idade;

	// Construtor da padrão classe Aluno
	public Aluno() {
	}

	// Construtor da classe Aluno
	public Aluno(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	// Get's and Set's 
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
