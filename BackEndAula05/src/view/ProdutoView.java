package view;

import java.util.List;
import java.util.Scanner;

import model.Produto;

public class ProdutoView {
	private Scanner scanner = new Scanner(System.in);
	
	public int menu() {
		System.out.println("\n==== MENU PRODUTOS ====");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
        return Integer.parseInt(scanner.nextLine());
	}
	
	public Produto lerDadosProduto() {
		System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());
        return new Produto(0, nome, preco);
	}
	
	public void mostrarProdutos(List<Produto> produtos) {
		if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
        	System.out.println("\n--- Lista de Produtos ---");
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
	}

	public void mostrarMensagem(String string) {
		System.out.println(string);
	}
}
