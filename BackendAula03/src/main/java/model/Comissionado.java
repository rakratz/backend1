package model;

public class Comissionado extends Funcionario {
	
	private double vendasBrutas;
	private final double taxaComissao; // ex.: 0.05 = 5% de Comissão
	
	public Comissionado(String nome, String documento, double VendasBrutas, double taxaComissao) {
		super(nome, documento);
		if (taxaComissao < 0 || taxaComissao > 1) {
		        throw new IllegalArgumentException("Valor de taxa inválida (entre 0 e 1).");
		    }
		this.vendasBrutas = VendasBrutas;
		this.taxaComissao = taxaComissao;
	}

	@Override
	public double calcularRemuneracao() {
		return vendasBrutas * taxaComissao;
	}
	
	public void adicionarVendas(double valor) {
	    if (valor < 0) {
	        throw new IllegalArgumentException("Valor de venda inválido (negativo).");
	    }
	    this.vendasBrutas += valor;
	}

	@Override
	public String toString() {
		return "Comissionado: " + super.toString();
	}
	
}
