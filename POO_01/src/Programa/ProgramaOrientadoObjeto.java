package Programa;

import java.util.Scanner;

class Funcionario {
	String nome;
	double valor;
	int horas;

	double calcularSalario() {
		return valor * horas;
	}
}

public class ProgramaOrientadoObjeto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leitura = new Scanner(System.in);

		// Instânciar um objeto (criar um objeto = new)

		Funcionario funcionario1 = new Funcionario();

		// Funcionário 01
		System.out.println("Informe os dados do primeiro funcionário");
		System.out.print("Nome: ");
		funcionario1.nome = leitura.nextLine();
		System.out.print("Valor Hora (R$): ");
		funcionario1.valor = leitura.nextDouble();
		System.out.print("Horas Trabalhadas): ");
		funcionario1.horas = leitura.nextInt();

		leitura.nextLine(); // Limpar o buffer

		// Funcionário 02

		Funcionario funcionario2 = new Funcionario();
		System.out.println("Informe os dados do primeiro funcionário");
		System.out.print("Nome: ");
		funcionario2.nome = leitura.nextLine();
		System.out.print("Valor Hora (R$): ");
		funcionario2.valor = leitura.nextDouble();
		System.out.print("Horas Trabalhadas): ");
		funcionario2.horas = leitura.nextInt();

		leitura.close();

		// Calcular os salarios
		double totalSalarios = funcionario1.calcularSalario() + funcionario2.calcularSalario();

		// Escrever o resultado
		System.out.println("Resumo de Pagamento");
		System.out.println("Funcionário: " + funcionario1.nome + " com salário de R$ " + funcionario1.calcularSalario());
		System.out.println("Funcionário: " + funcionario2.nome + " com salário de R$ " + funcionario2.calcularSalario());
		System.out.println("Total pago: " + totalSalarios);
	}

}
