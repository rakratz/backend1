package Programa;

import java.util.Scanner;

public class ProgramaEstruturado {

	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);

		// Funcionário 01
		System.out.println("Informe os dados do primeiro funcionário");
		System.out.print("Nome: ");
		String nome1 = leitura.nextLine();
		System.out.print("Valor Hora (R$): ");
		double valor1 = leitura.nextDouble();
		System.out.print("Horas Trabalhadas): ");
		int hora1 = leitura.nextInt();

		leitura.nextLine(); // Limpar o buffer
		
		// Funcionário 02
		System.out.println("Informe os dados do segundo funcionário");
		System.out.print("Nome: ");
		String nome2 = leitura.nextLine();
		System.out.print("Valor Hora (R$): ");
		double valor2 = leitura.nextDouble();
		System.out.print("Horas Trabalhadas): ");
		int hora2 = leitura.nextInt();
		
		leitura.close();
		
		// Calcular os salarios
		double salario1 = valor1 * hora1;
		double salario2 = valor2 * hora2;
		double totalSalarios = salario1 + salario2;
		
		// Escrever o resultado
		System.out.println("Resumo de Pagamento");
		System.out.println("Funcionário: " + nome1 + " com salário de R$ " + salario1);
		System.out.println("Funcionário: " + nome2 + " com salário de R$ " + salario2);
		System.out.println("Total pago: " + totalSalarios);
	}

}
