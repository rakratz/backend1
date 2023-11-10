package com.projeto.ProjetoIntegrador2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.ProjetoIntegrador2.model.Usuarios;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
	Usuarios findByLogin(String login);
	Usuarios findByEmail(String email);
	Usuarios findByLoginAndSenha(String login, String senha);
	boolean existsByLoginOrEmail(String login, String email);
}
