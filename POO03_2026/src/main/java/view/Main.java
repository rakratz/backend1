package view;

import controller.EscolaController;
import model.Aluno;
import model.Professor;

public class Main {

	public static void main(String[] args) {
		EscolaController controller = new EscolaController();
		
		// Create
			Aluno a1 = new Aluno("Carlos", 20, "20261001");
			Professor p1 = new Professor("Ricardo", 49, "Backend");
			
			controller.adcionarPessoa(a1);
			controller.adcionarPessoa(p1);
			
		// Read
			controller.listarPessoas();
		// Update
			controller.atualizarPessoa("Carlos", "Carlos Silva");
			controller.listarPessoas();
			
		// Delete
			controller.removerPessoa("Ricardo");
			controller.listarPessoas();
	
	}

}
