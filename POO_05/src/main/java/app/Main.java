package app;

import view.AlunoView;
import controller.AlunoController;

public class Main {

	public static void main(String[] args) {
		AlunoView view = new AlunoView();
		AlunoController controller = new AlunoController(view);
		
		int opcao;
		do {
			view.mostraMenu();
			opcao = view.lerOpcao();
			switch (opcao) {
				case 1:
					controller.cadastrarAluno();
					break;
				case 2:
					controller.atualizarAluno();
					break;
				case 3: 
					controller.excluirAluno();
					break;
				case 4: 
					controller.listarAlunos();
					break;
				case 5:
					controller.MostraAluno();
					break;
				case 6:
					System.out.println("Saindo do Sistema!");
					break;
				default:
					System.out.println("Opção inválida!");
			}
		} while (opcao != 6);
	}

}
