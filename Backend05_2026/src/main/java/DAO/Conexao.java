package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private final String url;
	private final String usuario;
	private final String senha;
	
	public Conexao(String url, String usuario, String senha) {
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Connection abrir() throws SQLException {
		return DriverManager.getConnection(url, usuario, senha);
	}
}
