package Model;

import java.util.Date;

public class Pessoa {
	// Atributos
	private final String codigo; // Só pode ser alterado na hora da criação (instanciar)
	private String nome;
	private Date dataNascimento;
	private String email;
	private String telefone;
	
	
	// Construtores
	public Pessoa(String codigo) {
		this.codigo = codigo;
	}
	
	public Pessoa(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Pessoa(String codigo, String nome, Date dataNascimento, String email, String telefone) {
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
	}
	
	// Métodos
	
	public String getCodigo() {
		return codigo;
	}
	
	// Por causa do Final não é possivel criar um setCodigo(String codigo)

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", email=" + email
				+ ", telefone=" + telefone + "]";
	}

	
}
