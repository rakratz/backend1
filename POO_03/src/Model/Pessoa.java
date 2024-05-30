package Model;

public class Pessoa {
	// Atribuidos
	private String nome;
	private int idade;
	private String email;

	// Construtor Padrão
	public Pessoa() {
	}

	// Construtor Parametrizado - Todos os atribuitos
	public Pessoa(String nome, int idade, String email) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
	}

	// Construtor Parametrizado - Todos os atribuitos
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	// Construtor Parametrizado - Todos os atribuitos
	public Pessoa(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	// Construtor Parametrizado - Todos os atribuitos
	public Pessoa(int idade, String email) {
		this.idade = idade;
		this.email = email;
	}

	
	// Getters e Setters


	public int getIdade() {
		return idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
