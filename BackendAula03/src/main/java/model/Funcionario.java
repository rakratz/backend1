package model;

public abstract class Funcionario {
	// Parecido com constante, uma vez inicializado no construtor nao pode ser alterado
	private final String nome; 
	private final String documento;
	
	
	// Construtor
	public Funcionario(String nome, String documento) {
		this.nome = nome;
		this.documento = documento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDocumento() {
		return documento;
	}
	
	// contrato de polimofismo
	public abstract double calcularRemuneracao();
	
	// Sobrescrever o método da Classe, emm java toda Classe herda um construtor padrão e toString
	@Override 
	public String toString() {
		return "%s (%s)".formatted(nome, documento);
	}
}
