import java.util.Scanner;

// Comentário de Linha

/* 
 * Comentário em bloco que 
 * tudo entre está comentado, vc pode dar enter
 * */

// Revisão de Programação Estrutura (algoritimos) em Java
public class ProgramaEstruturado {

	public static void main(String[] args) {

		// Função Scanner permiter fazer a leitura e escrita: tela e teclado
		// Arquivos, rede e etc
		Scanner leitura = new Scanner(System.in);

		// Primeiro Funcionário
		System.out.println("Informe os dados do Primeiro Funcionário: ");
		System.out.print("Nome: ");
		String nome1 = leitura.nextLine();
		System.out.print("Valor por hora: ");
		double valorPorHora1 = leitura.nextDouble();
		System.out.print("Quantidade de Horas trabalhadas: ");
		int horasTrabalhadas1 = leitura.nextInt();
		
		leitura.nextLine(); // Limpar o Buffer de leitura
		
		// Segundo Funcionário
		System.out.println("Informe os dados do Segundo Funcionário: ");
		System.out.print("Nome: ");
		String nome2 = leitura.nextLine();
		System.out.print("Valor por hora: ");
		double valorPorHora2 = leitura.nextDouble();
		System.out.print("Quantidade de Horas trabalhadas: ");
		int horasTrabalhadas2 = leitura.nextInt();

		// Calculando
		double salario1 = valorPorHora1 * horasTrabalhadas1;
		double salario2 = valorPorHora2 * horasTrabalhadas2;
		
		// Total
		double total = salario1 + salario2;
		
		System.out.println("\nInforme de Pagamento: ");
		System.out.println("Nome: " + nome1 + " Salário: R$" +  salario1);
		System.out.println("Nome: " + nome2 + " Salário: R$" +  salario2);
		System.out.println("Total Pago: R$" + total);
	}
}
