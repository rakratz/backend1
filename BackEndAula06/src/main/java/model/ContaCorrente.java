package model;

public class ContaCorrente extends Conta{
	private double limite;
	
	public ContaCorrente(){ }
	
	
	public ContaCorrente(Integer id, String numero, String titular, double saldo, double limite) {
		super(id, numero, titular, saldo);
		this.limite = limite;
	}


	public double getLimite() {
		return limite;
	}

	@Override
	public void sacar(double valor) {
		if (getSaldo() + limite >= valor) {
			setSaldo(getSaldo() - valor);
		} else {
			System.out.println("Saldo insuficiente (considerando o limite)");
		}
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	 @Override
	    public String toString() {
	        return "ContaCorrente{" +
	                "id=" + getId() +
	                ", numero='" + getNumero() + '\'' +
	                ", titular='" + getTitular() + '\'' +
	                ", saldo=" + getSaldo() +
	                ", limite=" + limite +
	                '}';
	    }
	
}
