package Model;

public class Veiculo {
	private String cor;
	private int velocidadeMaxima;
	private double capacidadeTanque;
	
	public Veiculo(String cor, int velocidadeMaxima, double capacidadeTanque) {
		this.cor = cor;
		this.velocidadeMaxima = velocidadeMaxima;
		this.capacidadeTanque = capacidadeTanque;
	}
	
	// Método genérico
	public void acelerar() {
		System.out.println("Veículo acelerando de forma genérica...");
	}
	
	// Método genérico
	public void frear() {
		System.out.println("Veículo freando de forma genérica...");
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(int velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public double getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(double capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	
	@Override
	public String toString() {
		return "Veiculo [cor=" + cor + ", velocidadeMaxima=" + velocidadeMaxima + ", capacidadeTanque="
				+ capacidadeTanque + "]";
	}

	
	
}
