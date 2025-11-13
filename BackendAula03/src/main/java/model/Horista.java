package model;

public class Horista extends Funcionario {

	private final double valorHora;
	private final double horasTrabalhadas;
	
	public Horista(String nome, String documento, double valorHora, double horasTrabalhadas) {
		// Chama o construtor da superclasse (pai)
		super(nome, documento); 
		this.valorHora = valorHora;
		this.horasTrabalhadas = horasTrabalhadas;
	}

	// Implementação do Polimorfismo 
	@Override
	public double calcularRemuneracao() {
		return horasTrabalhadas * valorHora;
	}

	public double getValorHora() {
		return valorHora;
	}
	
	@Override
	public String toString() {
		return "Horista: " + super.toString();
	}
	
}
