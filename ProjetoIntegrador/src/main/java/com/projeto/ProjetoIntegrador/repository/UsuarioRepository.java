package com.projeto.ProjetoIntegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.ProjetoIntegrador.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
    Usuario findByEmail(String email);
    Usuario findByLoginAndSenha(String login, String senha);
    boolean existsByLoginOrEmail(String login, String email);
}
