package Model;

public class Carro extends Veiculo{
	private int numeroPortas;
	private int numeroRodas;
	
	
	public Carro(String cor, int velocidadeMaxima, double capacidadeTanque, int numeroPortas, int numeroRodas) {
		super(cor, velocidadeMaxima, capacidadeTanque);
		this.numeroPortas = numeroPortas;
		this.numeroRodas = numeroRodas;
	}

	
	// Método sobrecrito (polimorfismo)
	@Override
	public void acelerar() {
		System.out.println("Veículo acelerando em quatro rodas...");
	}
		
	// Método sobrecrito (polimorfismo)
	@Override
	public void frear() {
		System.out.println("Veículo freando em quatro roda...");
	}

	public int getNumeroPortas() {
		return numeroPortas;
	}


	public void setNumeroPortas(int numeroPortas) {
		this.numeroPortas = numeroPortas;
	}


	public int getNumeroRodas() {
		return numeroRodas;
	}


	public void setNumeroRodas(int numeroRodas) {
		this.numeroRodas = numeroRodas;
	}


	@Override
	public String toString() {
		return super.toString() + " Carro [numeroPortas=" + numeroPortas + ", numeroRodas=" + numeroRodas + "]";
	}
	
	
	
}
