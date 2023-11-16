package com.empresa.application;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.empresa.DAO.ContatoDAO;
import com.empresa.model.Contato;

public class MainAgenda {

	private static final Scanner scanner = new Scanner(System.in);
	private static final ContatoDAO contatoDAO = new ContatoDAO();

	public static void main(String[] args) {
		int escolha;

		do {
			exibirMenu();
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1:
				adicionarContato();
				break;
			case 2:
				exibirContatos();
				break;
			case 3:
				atualizarContato();
				break;
			case 4:
				excluirContato();
				break;
			case 5:
				// Sair do programa
				System.out.println("Saindo do programa. Até logo!");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (escolha != 5);

		// Fechar o serviço de contatos ao sair do programa
		contatoDAO.close();
	}

	private static void exibirMenu() {
		System.out.println("\n--- Menu ---");
		System.out.println("1. Adicionar Contato");
		System.out.println("2. Exibir Contatos");
		System.out.println("3. Atualizar Contato");
		System.out.println("4. Excluir Contato");
		System.out.println("5. Sair");
		System.out.print("Escolha uma opção: ");
	}

	private static void adicionarContato() {
		System.out.println("\n--- Adicionar Contato ---");

		// Lógica para adicionar um novo contato
		// (Pode ser semelhante ao que você já possui)

		// Exemplo:
		Contato novoContato = new Contato();
		System.out.print("Nome: ");
		scanner.nextLine(); // Consumir a quebra de linha pendente (limpar buffer)
		novoContato.setNome(scanner.nextLine());
		System.out.print("Idade: ");
		novoContato.setIdade(scanner.nextInt());

		// Defina a data de cadastro como a data atual
		novoContato.setDataCadastro(LocalDate.now());

		contatoDAO.adicionarContato(novoContato);

		System.out.println("Contato adicionado com sucesso!");
	}

	private static void exibirContatos() {
		System.out.println("\n--- Lista de Contatos ---");

		List<Contato> contatos = contatoDAO.buscarTodosContatos();

		if (contatos.isEmpty()) {
			System.out.println("Nenhum contato encontrado.");
		} else {
			for (Contato contato : contatos) {
				System.out.println("ID: " + contato.getId());
				System.out.println("Nome: " + contato.getNome());
				System.out.println("Idade: " + contato.getIdade());
				System.out.println("Data de Cadastro: " + contato.getDataCadastro());
				System.out.println("--------------------------");
			}
		}
	}

	private static void atualizarContato() {
		System.out.println("\n--- Atualizar Contato ---");

		// Lógica para atualizar um contato

		System.out.print("ID do Contato a ser atualizado: ");
		int id = scanner.nextInt();
		Contato contatoExistente = contatoDAO.buscarContatoPorId(id);

		if (contatoExistente != null) {
			scanner.nextLine(); // Consumir a quebra de linha pendente (limpar buffer)

			System.out.print("Novo nome: ");
			contatoExistente.setNome(scanner.nextLine());

			System.out.print("Nova idade: ");
			contatoExistente.setIdade(scanner.nextInt());

			// Defina a data de cadastro como a data atual
			contatoExistente.setDataCadastro(LocalDate.now());
			
			// Lógica para atualizar outros campos...

			contatoDAO.atualizarContato(contatoExistente);

			System.out.println("Contato atualizado com sucesso!");
		} else {
			System.out.println("Contato não encontrado.");
		}
	}

	private static void excluirContato() {
		System.out.println("\n--- Excluir Contato ---");

		System.out.print("ID do Contato a ser excluído: ");
		int id = scanner.nextInt();
		Contato contatoExistente = contatoDAO.buscarContatoPorId(id);

		if (contatoExistente != null) {
			contatoDAO.excluirContato(id);
			System.out.println("Contato excluído com sucesso!");
		} else {
			System.out.println("Contato não encontrado.");
		}
	}
}
