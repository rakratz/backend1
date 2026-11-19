package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuracao {
	
	public Connection abrir() throws SQLException {
		String url = "jbdc:mysql://localhost:3306/aula_backend";
		String usuario = "root";
		String senha = "Aluno@123";

		return DriverManager.getConnection(url, usuario, senha);
	}
}
