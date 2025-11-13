
public class Funcionario {
	public String nome;
	public double valorPorHora;
	public int horasTrabalhadas;
	
	public double calcularSalario() {
		return valorPorHora * horasTrabalhadas;
	}
}
