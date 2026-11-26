package App;

import java.util.ArrayList;
import java.util.List;

import Controller.AlunoController;
import Controller.ProferssorController;
import Model.Pessoa;
import View.PessoaView;

public class Main {

	public static void main(String[] args) {
		PessoaView view = new PessoaView();
		AlunoController alunoController = new AlunoController();
		ProferssorController professorController = new ProferssorController();
		
		while (true) {
			int opcao = view.mostrarMenu();
			
			switch (opcao) {
			case 1:
				 view.mostrarMensagem("\n--- CADASTRO DE ALUNO --");
	             alunoController.cadastrar(
	                     view.lerCampo("Código: "),
	                     view.lerCampo("Nome: "),
	                     view.lerData("Data de nascimento"),
	                     view.lerCampo("E-mail: "),
	                     view.lerCampo("Telefone: "),
	                     view.lerCampo("Matrícula: "),
	                     view.lerData("Data de matrícula"),
	                     view.lerCampo("Curso: "),
	                     view.lerInteiro("Semestre: ")
	             );
	             view.mostrarMensagem("Aluno Cadastrado com Suscesso!");
	             break;
			case 2:
				 view.mostrarMensagem("\n--- CADASTRO DE PROFESSOR --");
	             professorController.cadastrar(
	                     view.lerCampo("Código: "),
	                     view.lerCampo("Nome: "),
	                     view.lerData("Data de nascimento"),
	                     view.lerCampo("E-mail: "),
	                     view.lerCampo("Telefone: "),
	                     view.lerCampo("Disciplina: "),
	                     view.lerTitulacao()
	             );
	             view.mostrarMensagem("Professor Cadastrado com Suscesso!");
	             break;
			case 3:
				List<Pessoa> pessoas = new ArrayList<>();
				pessoas.addAll(alunoController.listar());
				pessoas.addAll(professorController.listar());
				view.mostrarPessoas(pessoas);
				break;
			case 0: 
				view.mostrarMensagem("Sistema encerrado!");
				return;
			default:
				view.mostrarMensagem("Opção Inválida!");
				break;
			}
		}

	}

}
