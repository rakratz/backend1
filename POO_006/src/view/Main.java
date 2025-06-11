package view;

import java.util.Scanner;

import controller.ProdutoController;

public class Main {

	public static void main(String[] args) {
		ProdutoController controller = new ProdutoController();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n=== Menu ===");
			System.out.println("1 - Adicionar produto");
			System.out.println("2 - Listar produtos");
			System.out.println("3 - Atualizar produto");
			System.out.println("4 - Excluir produto");
			System.out.println("0 - Sair");
			System.out.print("Escolha: ");
			int opcao = sc.nextInt();
			sc.nextLine(); // Limpar o Buffer
			
			switch (opcao) {
			case 0 -> {
				System.out.println("Saindo do Sistema... ");
				return;
			}
			case 1 -> {
				
				 System.out.println("\n=== Novo Cadastro ===");
				 System.out.print("Nome: ");
				 String nome = sc.nextLine();
				 System.out.print("Preço: ");
				 double preco = sc.nextDouble();
				 sc.nextLine(); // Limpar o Buffer
				 controller.adicionarProduto(nome, preco);
				 
			}
			case 2 -> {
				System.out.println("\n=== Produtos Cadastros ===");
				controller.listarProdutos();
			}
			
			case 3 -> {
				System.out.println("\n=== Atualizar Produto ===");
				System.out.print("Id produto: ");
				 int id = sc.nextInt();
				 sc.nextLine(); // Limpar o Buffer
				 
				 System.out.print("Novo Nome: ");
				 String nome = sc.nextLine();
				 
				 System.out.print("Novo Preço: ");
				 double preco = sc.nextDouble();
				 sc.nextLine(); // Limpar o Buffer
				 controller.atualizarProduto(id, nome, preco);
				
			}
			
			case 4 -> {
				System.out.println("\n=== Excluir Produto ===");
				System.out.print("Id produto: ");
				 int id = sc.nextInt();
				 sc.nextLine(); // Limpar o Buffer
				 
				 controller.removerProduto(id);
				
			}
			
			default -> {
				System.out.println("Opcão Inválida...");
			}
			}
		}
		

	}

}
