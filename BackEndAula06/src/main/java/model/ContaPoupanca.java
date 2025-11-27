package model;

public class ContaPoupanca extends Conta {
	private double taxaRendimento;

	
	public ContaPoupanca() {
	}


	public ContaPoupanca(Integer id, String numero, String titular, double saldo, double taxaRendimento) {
		super(id, numero, titular, saldo);
		this.taxaRendimento = taxaRendimento;
	}


	public double getTaxaRendimento() {
		return taxaRendimento;
	}


	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

	public void aplicarRendimento() {
		double novoSaldo = getSaldo() * (1 + taxaRendimento / 100);
		setSaldo(novoSaldo);
	}
	
    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "id=" + getId() +
                ", numero='" + getNumero() + '\'' +
                ", titular='" + getTitular() + '\'' +
                ", saldo=" + getSaldo() +
                ", taxaRendimento=" + taxaRendimento +
                '}';
    }
	
	
}
