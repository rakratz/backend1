package view;

import controller.FuncionarioController;

import model.Funcionario;

import model.FuncionarioCLT;

import model.FuncionarioPJ;

import java.util.Scanner;

public class FuncionarioView {

	private Scanner sc = new Scanner(System.in);
	
	private FuncionarioController controller = new FuncionarioController();
	
	public void iniciar() {
		int opcao = 0;
		
		do {
			System.out.println("\n===== SISTEMA =====");
            System.out.println("1 - Adicionar CLT");
            System.out.println("2 - Adicionar PJ");
            System.out.println("3 - Listar Funcionários");
            System.out.println("4 - Remover Funcionário");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            
            opcao = sc.nextInt();
            
            sc.nextLine(); // Limpar o Buffer
            
            switch (opcao) {
            	case 1:
            		adicionarFuncionarioCLT();
            		break;
            	case 2:
            		adicionarFuncionarioPJ();
            		break;
            	case 3:
            		listarFuncionarios();
            		break;
            	case 4:
            		removerFuncionario();
            		break;
            	case 0:
            		System.out.println("Encerrando...");
            		break;
            	default:
            		System.out.println("Opção Inválida!");
            }

			
		} while (opcao != 0);
	}

	private void removerFuncionario() {
		System.out.print("\nNome do Funcionário: ");
		String nome = sc.nextLine();
		
		boolean removido = controller.removerFuncionario(nome);
		
		if (removido) {
			System.out.println("Funcionário Removido com Sucesso!");
		} else {
			System.out.println("Funcionário não encontrado!");
		}
		
	}

	private void listarFuncionarios() {
		System.out.println("\n=== LISTA DE FUNCIONÁRIOS ===");
		
		for (Funcionario funcionario:controller.listarFuncionarios()) {
			System.out.println(funcionario);
		}
		
	}

	private void adicionarFuncionarioPJ() {
		System.out.println("\n=== FUNCIONÁRIO PJ ===");

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpar o Buffer

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Valor Hora: ");
        double valorHora = sc.nextDouble();

        System.out.print("Horas Trabalhadas: ");
        int horas = sc.nextInt();
        
        sc.nextLine(); // Limpar o Buffer

        Funcionario funcionario =
                new FuncionarioPJ(
                        id,
                        nome,
                        valorHora,
                        horas
                );

        controller.adcionarFuncionario(funcionario);

        System.out.println("Funcionário PJ cadastrado!");

		
	}

	private void adicionarFuncionarioCLT() {
		System.out.println("\n=== FUNCIONÁRIO CLT ===");
		
		System.out.print("ID: ");
		int id = sc.nextInt();
		
		sc.nextLine(); // Limpar o buffer de leitura do teclado 
		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Salário Base: ");
		double salario = sc.nextDouble();
		
		Funcionario funcionario = new FuncionarioCLT(id, nome, salario);
		
		controller.adcionarFuncionario(funcionario);
		
		System.out.println("Funcionário Cadastrado com Sucesso!");
		
	}

}
