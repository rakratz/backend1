package Model;

public class Moto extends Veiculo {
	private boolean temSideCar;
	private int numeroRodas;
	
	public Moto(String cor, int velocidadeMaxima, double capacidadeTanque, boolean temSideCar, int numeroRodas) {
		super(cor, velocidadeMaxima, capacidadeTanque);
		this.temSideCar = temSideCar;
		this.numeroRodas = numeroRodas;
	}

	// Método sobrecrito (polimorfismo)
	@Override
	public void acelerar() {
		System.out.println("Veículo acelerando em duas rodas...");
	}
		
	// Método sobrecrito (polimorfismo)
	@Override
	public void frear() {
		System.out.println("Veículo freando em duas roda...");
	}
		
	public boolean isTemSideCar() {
		return temSideCar;
	}

	public void setTemSideCar(boolean temSideCar) {
		this.temSideCar = temSideCar;
	}

	public int getNumeroRodas() {
		return numeroRodas;
	}

	public void setNumeroRodas(int numeroRodas) {
		this.numeroRodas = numeroRodas;
	}

	@Override
	public String toString() {
		return super.toString() + " Moto [temSideCar=" + temSideCar + ", numeroRodas=" + numeroRodas + "]";
	}
	
	
}
