package Model;

import java.util.Date;

public class Professor extends Pessoa {
	private String disciplina;
	private Titulacao titulacao;
	
	public Professor(String codigo) {
		super(codigo);
	}
	
	public Professor(String codigo, String nome) {
		super(codigo, nome);
	}

	
	public Professor(String codigo, String nome, Date dataNascimento, String email, String telefone) {
		super(codigo, nome, dataNascimento, email, telefone);
	}

	
	public Professor(String codigo, String nome, Date dataNascimento, String email, String telefone, String disciplina, Titulacao titulacao) {
		super(codigo, nome, dataNascimento, email, telefone);
		this.disciplina = disciplina;
		this.titulacao = titulacao;
	}

	
}
