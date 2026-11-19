package App;

import java.awt.Container;
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
			
		
			String opcao;
			do {
				System.out.println("\n=== Menu de Produtos ===");
				System.out.println("1 - Cadastrar produto");
				System.out.println("2 - Listar produtos");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				
				opcao = teclado.nextLine().trim();
				
				switch (opcao) {
			    case "1":
			        controller.cadastrarProduto();
			        break;

			    case "2":
			        controller.listarProdutos();
			        break;

			    case "0":
			        System.out.println("Programa encerrado.");
			        break;

			    default:
			        System.out.println("Opção inválida.");
			        break;
			}
				
			} while (!opcao.equals("0"));
		}

	}

}
