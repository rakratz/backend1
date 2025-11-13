import java.util.Scanner;

public class ProgramaOrientadoObjeto {

	public static void main(String[] args) {
		 Scanner leitura = new Scanner(System.in);
		 
		 Funcionario funcionario1 = new Funcionario();
		 
		 System.out.println("Informe os dados do primeiro funcionário:");
	     System.out.print("Nome: ");
         funcionario1.nome = leitura.nextLine();
         System.out.print("Valor por hora: ");
         funcionario1.valorPorHora = leitura.nextDouble();
         System.out.print("Horas trabalhadas: ");
         funcionario1.horasTrabalhadas = leitura.nextInt();
         
         leitura.nextLine(); // Limpa o buffer
		 
      // Lendo os dados do segundo funcionário
         Funcionario funcionario2 = new Funcionario();
         System.out.println("\nInforme os dados do segundo funcionário:");
         System.out.print("Nome: ");
         funcionario2.nome = leitura.nextLine();
         System.out.print("Valor por hora: ");
         funcionario2.valorPorHora = leitura.nextDouble();
         System.out.print("Horas trabalhadas: ");
         funcionario2.horasTrabalhadas = leitura.nextInt();
         
      // Calculando e exibindo o valor total pago aos funcionários
         double totalPago = funcionario1.calcularSalario() + funcionario2.calcularSalario();
         System.out.println("\nValor total pago aos funcionários: " + totalPago);
         
      // Exibindo as horas trabalhadas por funcionário
         System.out.println("\nHoras trabalhadas por funcionário:");
         System.out.println(funcionario1.nome + ": " + funcionario1.horasTrabalhadas + " horas");
         System.out.println(funcionario2.nome + ": " + funcionario2.horasTrabalhadas + " horas");
         
         leitura.close();
	}

}
