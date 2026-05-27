package model;

public class FuncionarioPJ extends Funcionario{

	private int horasTrabalhadas;

	public FuncionarioPJ(int id, String nome, double salarioBase, int horasTrabalhadas) {
		super(id, nome, salarioBase);
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	@Override
	public double calcularSalario() {
		
		return salarioBase * horasTrabalhadas;
	}
}
