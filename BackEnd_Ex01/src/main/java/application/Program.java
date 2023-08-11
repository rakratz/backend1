package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		// Interface Lista para armazenar os dados
		List<Employee> list = new ArrayList<>();
		
		// Leitura
		Scanner leitura = new Scanner(System.in);
		System.out.print("Quantos Empregados gostaria de Cadastrar? ");
		int quant = leitura.nextInt();
		System.out.println();
		System.out.println("Inicio do Cadastro de "+ quant + " Empregados");
		System.out.println();
		
		for (int i=0; i < quant; i++) {
			// Leitura dos Dados
			System.out.println("Funcionário nº "+(i+1)+": ");
			System.out.print("ID: ");
			int id = leitura.nextInt();
			System.out.print("Nome: ");
			leitura.nextLine();  // Limpando o buffer de leitura
			String name = leitura.nextLine();
			System.out.print("Salário: ");
			Double salary = leitura.nextDouble();
			
			// Instanciar objeto do tipo Employee
			Employee funcionario = new Employee(id, name, salary);
			list.add(funcionario);	// Adciona no fim da lista
			System.out.println();
		}
		
		// Leitura do Aumento de Salário
		System.out.print("Qual é id do funcionário? ");
		int idAlvo = leitura.nextInt();
		System.out.println();
		
		System.out.print("Qual é a porcentagem de aumento salarial? ");
		Double aumento = leitura.nextDouble();
		System.out.println();
		
		// Achar o ID
		int achou = 0; 	
		for (int i = 0; i < list.size(); i++) {
		    if (idAlvo == list.get(i).getId()) {
		        achou += 1;
		        Employee funcionario = list.get(i);
		        funcionario.increaseSalary(aumento);
		        // list.set(i, funcionario);  <-- Remova essa linha
		    }
		}

		if (achou == 0) {
			System.out.println("Id: " + idAlvo + " informado não encotrado...");
		}
		
		// Imprimir os funcionários
		System.out.println("");
		System.out.println("Listagem de Empregados");
		
		for (Employee emp : list) {
			System.out.println(emp.getId() + ", " + emp.getName() + ", R$ " + emp.getSalary()); 
		}
		leitura.close();
	}
}
