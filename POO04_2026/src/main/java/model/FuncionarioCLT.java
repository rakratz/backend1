package model;

public class FuncionarioCLT extends Funcionario{

	public FuncionarioCLT(int id, String nome, double salarioBase) {
		super(id, nome, salarioBase);
	}
	
	@Override
	public double calcularSalario() {
		double bonus = salarioBase * 0.10;
		
		return salarioBase + bonus;
	}
	
}
