package model;

public class Aluno extends Pessoa{
	private String curso;

	public Aluno() {
		super();
	}

	public Aluno(int id, String nome, String curso) {
		super(id, nome);
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}
