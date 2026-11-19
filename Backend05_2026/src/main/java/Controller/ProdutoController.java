package Controller;

import java.sql.SQLException;

import DAO.ProdutoDAO;
import Model.Produto;
import View.ProdutoView;

public class ProdutoController {
	
	private final ProdutoDAO dao;
	private final ProdutoView view;
	
	public ProdutoController(ProdutoDAO dao, ProdutoView view) {
		this.dao = dao;
		this.view = view;
	}
	
	public void cadastrarProduto() {
		try {
			
			Produto produto = view.lerProduto();
			
			dao.cadastrar(produto);
			
			view.mostrarMensagem("Produto Cadastrado com Sucesso!");
			
		} catch (NumberFormatException e) {
			
			view.mostrarMensagem("Informe um preço vaálido e uma quantidade inteira.");
			
		} catch (SQLException e) {

			view.mostrarMensagem("Erro ao Cadastrar o produto: " + e.getMessage());
			
		}
	}

}
