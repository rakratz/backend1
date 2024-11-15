package View;

import java.util.List;
import java.util.Scanner;

import Model.Pessoa;


public class PessoaView {
	private Scanner scanner = new Scanner(System.in);
	
	public int exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Adicionar Funcionário");
        System.out.println("3. Listar Pessoas");
        System.out.println("4. Editar Pessoa");
        System.out.println("5. Remover Pessoa");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }
	
	public String obterInput(String mensagem) {
        System.out.print(mensagem);
        scanner.nextLine();  // Limpar buffer
        return scanner.nextLine();
    }

	public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
	
	public void exibirLista(List<Pessoa> pessoas) {
        System.out.println("Lista de Pessoas:");
        pessoas.forEach(System.out::println);
    }
}
