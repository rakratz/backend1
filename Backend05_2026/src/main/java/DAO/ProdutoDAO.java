package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
