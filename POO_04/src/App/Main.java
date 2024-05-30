package App;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Aluno;

public class Main {
	
	private static ArrayList<Aluno> alunos = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("Menu");
			System.out.println("1 - Cadastrar Aluno");
			System.out.println("2 - Listar Alunos");
			System.out.println("3 - Pesquisar Aluno");
			System.out.println("4 - Excluir Aluno");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();  // Consome a nova linha
			
			switch (opcao) {
			case 0: {
				break;
			}
			case 1: {
				cadastrarAluno(scanner);
				break;
			}
			case 2: {
				listarAluno(scanner);
				break;
			}
			
			default:
				System.out.println("Opção inválida");
			}
		} while (opcao != 0);
		System.out.println("Obrigado por usar o sistema");
	}

	private static void listarAluno(Scanner scanner) {
		if (alunos.isEmpty()) {
			System.out.println("Não temos alunos cadastrados");
		} else {
			for(int i = 0; i < alunos.size(); i++) {
				System.out.println("Nome: " + alunos.get(i).getNome());
				System.out.println("Idade: " + alunos.get(i).getIdade());
				System.out.println("Curso: " + alunos.get(i).getCurso());
				System.out.println("");
			}
		}
		
	}

	private static void cadastrarAluno(Scanner scanner) {
		Aluno aluno = new Aluno();
		System.out.println("Cadastro de novo Aluno");
		System.out.print("Nome: ");
		aluno.setNome(scanner.nextLine());
		System.out.print("Idade: ");
		aluno.setIdade(scanner.nextInt());
		
		scanner.nextLine();  // Consome a nova linha
		
		System.out.print("Curso: ");
		aluno.setCurso(scanner.nextLine());
		alunos.add(aluno);
		System.out.println("Aluno adcionado com sucesso!");
	}

}
