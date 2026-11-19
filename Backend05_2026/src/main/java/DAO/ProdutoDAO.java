package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Produto;

public class ProdutoDAO {
	private final Conexao conexao;

	public ProdutoDAO(Conexao conexao) {
		this.conexao = conexao;
	}

    public void cadastrar(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome, preco, quantidade) VALUES (?, ?, ?)";

        try (Connection banco = conexao.abrir();
             PreparedStatement comando = banco.prepareStatement(sql)) {

            comando.setString(1, produto.getNome());
            comando.setBigDecimal(2, produto.getPreco());
            comando.setInt(3, produto.getQuantidade());

            comando.executeUpdate();
        }
    }
    
    public List<Produto> listarTodos() throws SQLException {
    		String sql = "SELECT id, nome, preco, quantidade FROM produto ORDER BY id";
    		List<Produto> produtos = new ArrayList<>();
    		
    		try (Connection banco = conexao.abrir();
    		         PreparedStatement comando = banco.prepareStatement(sql);
    		         ResultSet resultado = comando.executeQuery()) {

    		        while (resultado.next()) {
    		            Produto produto = new Produto(
    		                resultado.getInt("id"),
    		                resultado.getString("nome"),
    		                resultado.getBigDecimal("preco"),
    		                resultado.getInt("quantidade")
    		            );

    		            produtos.add(produto);
    		        }
    		    }

    		    return produtos;
    }
}
