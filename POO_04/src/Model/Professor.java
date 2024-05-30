package Model;

public class Professor extends Funcionario{
	private String disciplina;

	public Professor() {
		super();
	}

	public Professor(String nome, int idade, String departamento,  String disciplina) {
		super(nome, idade, departamento);
		this.disciplina = disciplina;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
