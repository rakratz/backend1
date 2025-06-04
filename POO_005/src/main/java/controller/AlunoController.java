package controller;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import view.AlunoView;

public class AlunoController {
	// Array com uma lista de aluno (memória)
	private List<Aluno> alunos = new ArrayList<>();
	private AlunoView view;
	
	public AlunoController(AlunoView view) {
		this.view = view;
	}
	
	public void cadastrarAluno() {
		int id = view.lerId(); 
		String nome = view.lerNome();
		String curso = view.lerCurso();
		
		// Adcionar o aluno na Lista
		Aluno novoAluno = new Aluno(id, nome, curso);
		alunos.add(novoAluno);
		System.out.println("Aluno cadastrado com sucesso!");
		
	}
	
	public void listarAlunos() {
		if (alunos.isEmpty()) {
			System.out.println("Não há alunos Cadastrados!");
		} else {
			view.listarAlunos(alunos);
		}
	}

	public void atualizarAluno() {
		if (alunos.isEmpty()) {
			System.out.println("Não há alunos Cadastrados!");
			return;
		} else {
			int id = view.lerId();
			Aluno alunoEncontrado = null;
			
			// Procurar o id na Lista
			for (Aluno a: alunos) {
				if (a.getId() == id) {
					alunoEncontrado = a;
					break;
				}
			}
			if (alunoEncontrado != null) {
				String novoNome = view.lerNome();
				String novoCurso = view.lerCurso();
				alunoEncontrado.setNome(novoNome);
				alunoEncontrado.setCurso(novoCurso);
				System.out.println("Aluno Atualizado com Sucesso!");
			} else {
				System.out.println("ID do aluno não encontrado!");
			}
		}
		
	}

	public void MostraAluno() {
		if (alunos.isEmpty()) {
			System.out.println("Não há alunos Cadastrados!");
			return;
		} else {
			int id = view.lerId();
			Aluno alunoEncontrado = null;
			
			// Procurar o id na Lista
			for (Aluno a: alunos) {
				if (a.getId() == id) {
					alunoEncontrado = a;
					break;
				}
			}
			if (alunoEncontrado != null) {
				view.listarAluno(alunoEncontrado);
			} else {
				System.out.println("ID do aluno não encontrado!");
			}
		}
		
	}

	public void excluirAluno() {
		if (alunos.isEmpty()) {
			System.out.println("Não há alunos Cadastrados!");
			return;
		} else {
			int id = view.lerId();
			Aluno alunoEncontrado = null;
			
			// Procurar o id na Lista
			for (Aluno a: alunos) {
				if (a.getId() == id) {
					alunoEncontrado = a;
					break;
				}
			}
			if (alunoEncontrado != null) {
				alunos.remove(alunoEncontrado);
				System.out.println("Aluno removido com sucesso!");
			} else {
				System.out.println("ID do aluno não encontrado!");
			}
		}
		
	}
}
