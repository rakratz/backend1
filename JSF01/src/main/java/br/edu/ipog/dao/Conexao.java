package br.edu.ipog.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexao {
	
	private static final String RESOURCE = "java:/comp/env/jdbc/postgresql";
	
	public static Connection getConexao() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(RESOURCE);			
			return ds.getConnection();
		} catch (SQLException | NamingException e) {
			throw new RuntimeException(e);
		}
	}
}
