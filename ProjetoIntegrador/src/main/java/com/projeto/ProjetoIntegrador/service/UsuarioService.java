package com.projeto.ProjetoIntegrador.service;

import org.springframework.stereotype.Service;

import com.projeto.ProjetoIntegrador.model.Usuario;
import com.projeto.ProjetoIntegrador.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    
    
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null); // Retorna nulo se o usuário não for encontrado
    }

    public Usuario criarUsuario(Usuario usuario) {
        // Verifica se já existe um usuário com o mesmo login ou e-mail
        if (usuarioRepository.existsByLoginOrEmail(usuario.getLogin(), usuario.getEmail())) {
            // Um usuário com o mesmo login ou e-mail já existe, então não é possível criar o novo usuário
            return null;
        }

        // Se não houver duplicação, então salva o novo usuário
        return usuarioRepository.save(usuario);
    }


    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
        	if (usuarioRepository.existsByLoginOrEmail(usuario.getLogin(), usuario.getEmail())) {
                // Um usuário com o mesmo login ou e-mail já existe, então não é possível atualizar o usuário
                return null;
            }
            usuario.setId(id); // Define o ID especificado no objeto de usuário
            return usuarioRepository.save(usuario);
        }
        return null; // Retorna nulo se o usuário não for encontrado para atualização
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    
 
}

