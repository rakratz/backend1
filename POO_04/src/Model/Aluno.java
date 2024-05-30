package Model;

public class Aluno extends Pessoa{

	private String curso;
	
	public Aluno() {
		super();
	}
	
	public Aluno(String nome, int idade, String curso) {
		// super chama a super classe pai e para os paramentos 
		super(nome, idade);
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
