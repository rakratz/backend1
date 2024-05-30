package Model;

public class Funcionario extends Pessoa{
	private String departamento;

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, int idade, String departamento) {
		super(nome, idade);
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
