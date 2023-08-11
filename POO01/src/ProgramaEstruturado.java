import java.util.Scanner;

public class ProgramaEstruturado {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        
        // Funcionário 1
        System.out.println("Informe os dados do primeiro funcionário:");
        System.out.print("Nome: ");
        String nome1 = leitura.nextLine();
        System.out.print("Valor por hora: ");
        double valorPorHora1 = leitura.nextDouble();
        System.out.print("Horas trabalhadas: ");
        int horasTrabalhadas1 = leitura.nextInt();
        
        leitura.nextLine(); // Limpa o buffer
       
        // Funcionário 2
        System.out.println("\nInforme os dados do segundo funcionário:");
        System.out.print("Nome: ");
        String nome2 = leitura.nextLine();
        System.out.print("Valor por hora: ");
        double valorPorHora2 = leitura.nextDouble();
        System.out.print("Horas trabalhadas: ");
        int horasTrabalhadas2 = leitura.nextInt();
        
        // Calculando salários
        double salario1 = valorPorHora1 * horasTrabalhadas1;
        double salario2 = valorPorHora2 * horasTrabalhadas2;
        
        // Calculando valor total pago
        double totalPago = salario1 + salario2;
        
        // Exibindo resultados
        System.out.println("\nResumo de Pagamento:");
        System.out.println("Funcionário 1 - Nome: " + nome1 + ", Salário: " + salario1);
        System.out.println("Funcionário 2 - Nome: " + nome2 + ", Salário: " + salario2);
        System.out.println("Valor total pago aos funcionários: " + totalPago);
        
        leitura.close();
    }
}
