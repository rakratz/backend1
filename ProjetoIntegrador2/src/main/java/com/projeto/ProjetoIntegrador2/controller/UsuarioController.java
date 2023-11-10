package com.projeto.ProjetoIntegrador2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ProjetoIntegrador2.model.Usuarios;
import com.projeto.ProjetoIntegrador2.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public ResponseEntity<List<Usuarios>> listarUsuarios() {
		List<Usuarios> usuarios = usuarioService.listarUsuarios();
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> buscarUsuarioByID(@PathVariable Long id) {
		Usuarios usuario = usuarioService.buscarUsusarioPorId(id);
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	public ResponseEntity<Usuarios> criarUsuario(@RequestBody Usuarios usuario) {
		Usuarios novoUsuario = usuarioService.criarUsuario(usuario);
		return ResponseEntity.ok(novoUsuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuarios> atualizarUsuario(@PathVariable Long id, @RequestBody Usuarios usuario) {
		Usuarios usuarioAtualizado = usuarioService.atualizaUsuario(id, usuario);
		return ResponseEntity.ok(usuarioAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable Long id){
		usuarioService.excluirUsuario(id);
		return ResponseEntity.noContent().build();
	}
	
}
