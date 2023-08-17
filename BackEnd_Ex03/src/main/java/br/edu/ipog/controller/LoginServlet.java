package br.edu.ipog.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ipog.dao.Conexao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Conexão com Banco de Dados
		Connection conexaoJDBC = Conexao.getConexao();

		if (conexaoJDBC != null) {
			System.out.println("Conexão Aberta!");
		} else {
			System.out.println("Sem Conexão!");
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// System.out.println("Recebemos = "+ username + " - " + password);

		// Verificar se o username e password são válidos (consultar no banco de dados)
		boolean isValidUser = false;
		String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
		try {
			PreparedStatement statement = conexaoJDBC.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				isValidUser = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (isValidUser) {
			request.setAttribute("username", username);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("loginMessage", "Usuário ou senha inválidos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
