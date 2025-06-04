package view;

import java.util.List;
import java.util.Scanner;

import model.Aluno;

public class AlunoView {
	private Scanner scanner = new Scanner(System.in);
	
	public void mostraMenu() {
		System.out.println("---- Menu ----");
		System.out.println("1 - Cadastrar Aluno");
		System.out.println("2 - Atualizar Aluno");
		System.out.println("3 - Excluir Aluno");
		System.out.println("4 - Listar Alunos");
		System.out.println("5 - Mostrar detalhes Aluno");
		System.out.println("6 - Sair");
	}
	
	public int lerOpcao() {
		System.out.print("Opcão: ");
		return scanner.nextInt();
	}
	
	public String lerNome() {
		System.out.print("Nome do Aluno: ");
		scanner.nextLine();
		return scanner.nextLine();
	}
	
	public String lerCurso() {
		System.out.print("Curso do Aluno: ");
		//scanner.nextLine();
		return scanner.nextLine();
	}
	
	public int lerId() {
		System.out.print("Id do Aluno: ");
		return scanner.nextInt();
	}

	public void listarAlunos(List<Aluno> alunos) {
		System.out.println("\n---- Listar Alunos ----");
		for (Aluno a: alunos) {
			System.out.println(
					"ID: " + a.getId() + 
					" Nome: " + a.getNome() + 
					" Curso: " + a.getCurso() );
			System.out.println("");
		}
		
	}
	
	public void listarAluno(Aluno aluno) {
		System.out.println("\n---- Listar Detalhes do Alunos ----");
		System.out.println(
				"ID: " + aluno.getId() + 
				" Nome: " + aluno.getNome() + 
				" Curso: " + aluno.getCurso() );
		System.out.println("");
		
	}
}
