package produtos;

import java.math.BigDecimal;
import java.sql.SQLException;

import config.Banco;
import dao.ProdutoDAO;
import model.Produto;

public class Main {

	public static void main(String[] args) throws SQLException {
		Banco.criarTabela();
		System.out.println("Banco incializado e tabela criada");
		
		// Criar um produto e depois Listar
		
		Produto produto = new Produto();
		produto.setNome("Mouse Gammer");
		produto.setPreco(new BigDecimal(89.90));
		
		// Gravar o produto no Banco
		ProdutoDAO dao = new ProdutoDAO();
		dao.cadastrar(produto);
		
		// Listar os pordutos Gravado
		System.out.println("Produtos Cadastrados: ");
		for (Produto item : dao.listar()) {
			System.out.println(item);
		}
	}

}
