package App;

import java.util.Scanner;

import Controller.ProdutoController;
import DAO.Conexao;
import DAO.ProdutoDAO;
import View.ProdutoView;

public class Main {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/aula_backend";
		String usuario = "root";
		String senha = "Aluno@123";
		
		Conexao conexao = new Conexao(url, usuario, senha);
		
		ProdutoDAO dao = new ProdutoDAO(conexao);
		
		try (Scanner teclado = new Scanner(System.in)){
			ProdutoView view = new ProdutoView(teclado);
			ProdutoController controller = new ProdutoController(dao, view);
			
			controller.cadastrarProduto();
		}
	}

}
