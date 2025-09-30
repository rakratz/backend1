package br.edu.pucgoias.PraticaSpring01.controllers;

import br.edu.pucgoias.PraticaSpring01.model.User;
import br.edu.pucgoias.PraticaSpring01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// CRUD básico de User
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    // CREATE
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User saved = repository.save(user);
        return ResponseEntity.ok(saved);
    }

    // READ - listar todos
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    // READ - por id
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - atualizar todos os campos básicos (name, email, department)
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User body) {
        return repository.findById(id)
                .map(u -> {
                    u.setName(body.getName());
                    u.setEmail(body.getEmail());
                    u.setDepartment(body.getDepartment()); // se vier null, mantém null
                    return ResponseEntity.ok(repository.save(u));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - atualizar apenas o e-mail
    @PutMapping("/{id}/email")
    public ResponseEntity<User> updateEmail(@PathVariable Long id,
                                            @RequestBody Map<String, String> body) {
        String newEmail = body.get("email");
        if (newEmail == null || newEmail.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        return repository.findById(id)
                .map(u -> {
                    u.setEmail(newEmail);
                    return ResponseEntity.ok(repository.save(u));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
