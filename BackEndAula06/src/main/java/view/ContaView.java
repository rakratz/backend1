package view;

import java.util.List;
import java.util.Scanner;

import model.Conta;

public class ContaView {

	 private final Scanner sc;

	 public ContaView(Scanner sc) {
		 this.sc = sc;
	 }
	 
	 public int mostrarMenuEObterOpcao() {
	        System.out.println("==== MENU CONTAS (MVC) ====");
	        System.out.println("1 - Cadastrar Conta Corrente");
	        System.out.println("2 - Cadastrar Conta Poupança");
	        System.out.println("3 - Listar Contas");
	        System.out.println("4 - Atualizar Conta");
	        System.out.println("5 - Excluir Conta");
	        System.out.println("0 - Sair");
	        System.out.println("===========================");
	        return lerInt("Escolha uma opção: ");
	    }
	 
	 	public String lerString(String msg) {
	        System.out.print(msg);
	        return sc.nextLine();
	    }
	 	
	 	public int lerInt(String msg) {
	        System.out.print(msg);
	        while (!sc.hasNextInt()) {
	            System.out.print("Valor inválido. " + msg);
	            sc.next();
	        }
	        int valor = sc.nextInt();
	        sc.nextLine(); // consome \n
	        return valor;
	    }
	 	
	 	public double lerDouble(String msg) {
	        System.out.print(msg);
	        while (!sc.hasNextDouble()) {
	            System.out.print("Valor inválido. " + msg);
	            sc.next();
	        }
	        double valor = sc.nextDouble();
	        sc.nextLine(); // consome \n
	        return valor;
	    }
	 	
	 	 public void exibirMensagem(String msg) {
	         System.out.println(msg);
	     }
	 	 
	 	public void exibirContas(List<Conta> contas) {
	        if (contas.isEmpty()) {
	            System.out.println("Nenhuma conta cadastrada.");
	            return;
	        }
	        System.out.println("== Lista de Contas ==");
	        for (Conta c : contas) {
	            System.out.println(c);
	        }
	    }

	    public void exibirConta(Conta conta) {
	        System.out.println("Conta: " + conta);
	    }

	    public boolean confirmarExclusao(Conta conta) {
	        System.out.println("Conta encontrada: " + conta);
	        String resp = lerString("Confirma exclusão? (S/N): ");
	        return resp.equalsIgnoreCase("S");
	    }
}
