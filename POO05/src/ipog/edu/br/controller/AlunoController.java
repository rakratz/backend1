package ipog.edu.br.controller;

import ipog.edu.br.model.Aluno;

//Classe Controller que controla a interação com os alunos
public class AlunoController {
	Aluno[] alunos;
	int numAlunos;

	// Construtor da classe AlunoController
	public AlunoController() {
		alunos = new Aluno[10];
		numAlunos = 0;
	}

	// Método para adicionar um aluno à lista
	public void adicionarAluno(String nome, int idade) {
		if (numAlunos < 10) {
			Aluno aluno = new Aluno(nome, idade);
			alunos[numAlunos] = aluno;
			numAlunos++;
			System.out.println("Aluno adicionado com sucesso!");
		} else {
			System.out.println("Lista de alunos está cheia!");
		}
	}

	// Método para mostrar a lista de alunos
	public void mostrarAlunos() {
		System.out.println("Lista de Alunos:");
		for (int i = 0; i < numAlunos; i++) {
			System.out.println("Nome: " + alunos[i].getNome() + ", Idade: " + alunos[i].getIdade());
		}
	}
}
