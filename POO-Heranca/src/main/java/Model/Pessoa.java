package Model;

public class Pessoa {
	protected int id;
	protected String nome;
	protected int idade;
	
	public Pessoa(int id, String nome, int idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	
	public Pessoa() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Idade: " + idade;
    }
}
