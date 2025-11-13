package model;

public class Mensalista extends Funcionario {

	private final double salarioMensal;
	
	public Mensalista(String nome, String documento, double salarioMensal) {
		super(nome, documento);
		this.salarioMensal = salarioMensal;
	}
	
	@Override
	public double calcularRemuneracao() {
		return salarioMensal;
	}

	@Override
	public String toString() {
		return "Mensalista: " + super.toString();
	}
	
}
