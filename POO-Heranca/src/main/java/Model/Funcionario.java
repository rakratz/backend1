package Model;

public class Funcionario extends Pessoa {
	private String cargo;

	public Funcionario() {

	}

	public Funcionario(int id, String nome, int idade, String cargo) {
		super(id, nome, idade);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return super.toString() + ", Cargo: " + cargo;
	}

}
