package model;

public abstract class Funcionario {
	
	protected int id;
	protected String nome;
	protected double salarioBase;
	
	public Funcionario(int id, String nome, double salarioBase) {
		this.id = id;
		this.nome = nome;
		this.salarioBase = salarioBase;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	
	public abstract double calcularSalario();

	@Override
	public String toString() {
		return "Funcionario [id=" + id +
							 ", nome=" + nome +
							 ", salarioBase=" + 
							 salarioBase + "]";
	}
	
	
	
}
