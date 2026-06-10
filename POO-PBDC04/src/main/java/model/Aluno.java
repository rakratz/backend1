package model;

public class Aluno extends Pessoa{
	private String matricula;
    private String curso;

    public Aluno() {}

    public Aluno(int id, String nome, String cpf, String email, String matricula, String curso) {
        super(id, nome, cpf, email);
        this.matricula = matricula;
        this.curso = curso;
    }

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	 public String toString() {
        return id + " - " + nome + " - " + cpf + " - " + email +
               " - Matrícula: " + matricula + " - Curso: " + curso;
    }
    
    
}
