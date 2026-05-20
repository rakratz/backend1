package model;

public class Aluno extends Pessoa{
	
	// Atributos a mais
	private String matricula;
	
	// Criar um construtor que deve chamar o construtor pai (Pessoa)
	public Aluno(String nome, int idade, String matricula) {
		super(nome, idade);
		this.matricula = matricula;
	}
	
	
	
	public String getMatricula() {
		return matricula;
	}




	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}




	// Sobrescrever o métodos exibeDados()
	// Sobrescreve comportamento
	@Override
	public void exibirDados() {
		System.out.println(nome + " - " + 
					       idade + " - " +
						   matricula);
	}

}
