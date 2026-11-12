package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Banco;

import model.Produto;

public class ProdutoDAO {

	public void cadastrar(Produto produto) throws SQLException {
		String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";
		
		try(Connection conexao = Banco.conectar(); 
			PreparedStatement comando = conexao.prepareStatement(sql)){
			comando.setString(1, produto.getNome());
			comando.setBigDecimal(2, produto.getPreco());
			comando.executeUpdate();
		}
	}
	
	public List<Produto> listar() throws SQLException {
		String sql = "SELECT id, nome, preco FROM produto ORDER BY id";
		 List<Produto> produtos = new ArrayList<>();
		 try(Connection conexao = Banco.conectar(); 
			 PreparedStatement comando = conexao.prepareStatement(sql);
			 ResultSet resultado = comando.executeQuery()){
			 
			 while (resultado.next()) {
				 Produto produto = new Produto(
						 resultado.getInt("id"), 
						 resultado.getString("nome"),
						 resultado.getBigDecimal("preco"));
				 produtos.add(produto);
			 }
			}
		 
		return produtos;
	}
}
