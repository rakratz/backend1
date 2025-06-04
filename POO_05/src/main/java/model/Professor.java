package model;

public class Professor extends Pessoa{
	private String disciplina;

	public Professor() {
		super();
	}

	public Professor(int id, String nome, String disciplina) {
		super(id, nome);
		this.disciplina = disciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
