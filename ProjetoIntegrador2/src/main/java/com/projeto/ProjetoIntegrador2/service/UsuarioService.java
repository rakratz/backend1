package com.projeto.ProjetoIntegrador2.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ProjetoIntegrador2.model.Usuarios;
import com.projeto.ProjetoIntegrador2.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	// Listar Todos
	public List<Usuarios> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
	// Buscar por Id
	public Usuarios buscarUsusarioPorId(Long id) {
		Optional<Usuarios> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}
	
	// Criar Usuário
	public Usuarios criarUsuario(Usuarios usuario) {
		// Verificar se já existe um usuário com o mesmo login ou email
		if (usuarioRepository.existsByLoginOrEmail(usuario.getLogin(), usuario.getEmail())) {
			return null;
		}
		// Salvar
		return usuarioRepository.save(usuario);
	}
	
	// Atualizar Usuário
	public Usuarios atualizaUsuario(Long id, Usuarios usuario) {
		if (usuarioRepository.existsById(id)) {
			usuario.setId(id);
			return usuarioRepository.save(usuario);
		}
		return null;
	}
	
	// Excluir Usuário
	public void excluirUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}	
}
