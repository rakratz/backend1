package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {
	// String de Conexão
	private static final String URL = "jdbc:h2:mem:loja;DB_CLOSE_DELAY=-1";
	
	// Método de conexão
	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(URL, "sa", ""); 
	}
	
	// Estamos testando é vai rodar em memória o H2, precisamos criar as tabelas aqui
	
	public static void criarTabela () throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS produto "
				+ "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, "
				+ "nome VARCHAR(100) NOT NULL, "
				+ "preco DECIMAL(10, 2) NOT NULL CHECK (preco >= 0)";
		
		try (Connection conexao = conectar();
	             Statement comando = conexao.createStatement()) {
	            comando.executeUpdate(sql);
	        }
		
	}
}
