package com.empresa.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println("DEBUG: Requisição passou pelo Filtro.");
		
		// Vamos vazer uma atentricação apenas para testar
		if (request.getHeader("Authorization") != null) {
			System.out.println("DEBUG: " + request.getHeader("Authorization"));
			
			// Recupera o cabeçalho de autorização
			Authentication auth = TokenUtil.decodeToken(request);
			// Se existir cabeçalho de autorização
			if (auth != null) {
				// Se o "Token" for válido passamos a requisição para frente informando que está autenticada
				SecurityContextHolder.getContext().setAuthentication(auth);
			} 
			// Senão for válido o Token, retornando uma menssagem de erro customizada
			else {
				System.out.println("DEBUG: Erro no Token");
				ErroDTO erro = new ErroDTO(401, "Usuário não autorizado para essa funcionalidade!");
				response.setStatus(erro.getStatus());
				response.setContentType("application/json");
				// Serializador de Json
				ObjectMapper mapper = new ObjectMapper();
				response.getWriter().print(mapper.writeValueAsString(erro));
				response.getWriter().flush();
				return;
			}
		}
		// Encaminhando a Requisição para frente
		filterChain.doFilter(request, response);
	}
}
