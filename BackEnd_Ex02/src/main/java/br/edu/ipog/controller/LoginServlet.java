package br.edu.ipog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// System.out.println("Recebemos = "+ username + " - " + password);

		// Verificar se o username e password são válidos (por exemplo, comparar com um
		// banco de dados)
		boolean isValidUser = false;
		if (username.equals("user") && password.equals("password")) {
			isValidUser = true;
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
