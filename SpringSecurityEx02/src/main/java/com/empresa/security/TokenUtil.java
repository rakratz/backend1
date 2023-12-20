package com.empresa.security;

import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {

    // Método responsável por decodificar o token recebido na requisição HTTP
    public static Authentication decodeToken(HttpServletRequest request) {
        // Verifica se o cabeçalho "Authorization" contém um token válido
        if (request.getHeader("Authorization").equals("Bearer Aluno@123")) {
            // Retorna uma instância de UsernamePasswordAuthenticationToken para representar a autenticação do usuário
            // Neste caso, o nome de usuário é "user", e não há credenciais (null), e não há papéis associados (Collections.emptyList())
            return new UsernamePasswordAuthenticationToken("user", null, Collections.emptyList());
        }
        // Se o token não for válido, retorna null indicando que a autenticação falhou
        return null;
    }
}
