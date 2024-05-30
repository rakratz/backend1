package Model;

public class PessoalAdministrativo extends Funcionario{
	
	private String cargo;

	public PessoalAdministrativo() {
		super();
	}

	public PessoalAdministrativo(String nome, int idade, String departamento, String cargo) {
		super(nome, idade, departamento);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
