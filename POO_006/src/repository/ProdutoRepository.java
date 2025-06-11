package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Produto;


public class ProdutoRepository {
	private static final String URL = "jdbc:mysql://localhost:3306/loja";
	private static final String USUARIO = "root";
	private static final String SENHA = "Aluno@123";
	
	private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

	public void salvar(Produto novo) {
		String sql = "INSERT INTO produto (nome, preco) VALUE (?, ?)";
		try (Connection conn = getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, novo.getNome());
			stmt.setDouble(2, novo.getPreco());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Produto> listarTodos() {
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM produto";
		try (Connection conn = getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				produtos.add(new Produto(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getDouble("preco")
						));			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

	public void atualizar(Produto produto_atualizado) {
		String sql = "UPDATE produto SET nome = ?, preco = ? WHERE id = ?";
		try (Connection conn = getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, produto_atualizado.getNome());
			stmt.setDouble(2, produto_atualizado.getPreco());
			stmt.setDouble(3, produto_atualizado.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void remover(int id) {
		String sql = "DELETE FROM produto WHERE id = ?";
		try (Connection conn = getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
