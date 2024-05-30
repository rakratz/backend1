package Programa;

/* Classe: um molde ou uma estrutura que define atributos e métodos do Objeto*/

// Nome da Classe: Carro
public class Carro {

	/*
	 * Atributo: refere às variáveis que são declaradas dentro de uma classe e que
	 * armazenam dados relacionados ao estado dos objeto dessa classe
	 */

	/* MODIFICADORES */
	// public: o atribuito ou método pode ser acessados fora do pacote
	// private: o atribuito ou método NÃO pode ser acessados fora
	// protect: o atribuito ou método pode ser acessados por outras classes do mesmo
	// pacote
	// default (nenhum modificado) = protect

	// Encapsulamento é implementado usando modificadores (modificadores) de acesso,
	// que
	// determinam que pode acessar os atribuitoe e métodos de uma classe.
	// A ideia é enconder a complexidade do código para o mundo exterior
	// por boa boa prática os atribuitos são private e usamos gets e sets para
	// acessar

	// Declaração dos Atributos
	private String modelo;
	private String cor;
	private int ano;
	private double valor;

	// Método Construtor - é chamado quando criamos um objeto padrao
	public Carro() {

	}

	// Método Construtor - é chamado quando criamos um objeto com parametros
	public Carro(String modelo, String cor, int ano, double valor) {
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
		this.valor = valor;
	}
	
	// Criação do Métodos
	public String GetModelo() {
		return modelo;
	}
	
	public void SetModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String GetCor() {
		return cor;
	}
	
	public void SetCor(String cor) {
		this.cor = cor;
	}
	
	public int GetAno() {
		return ano;
	}
	
	public void SetAno(int ano) {
		this.ano = ano;
	}
	
	public double GetValor() {
		return valor;
	}
	
	public void SetValor(double valor) {
		this.valor = valor;
	}
	

}
