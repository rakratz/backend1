package br.edu.pucgoias.PraticaSpring01.controllers;

import br.edu.pucgoias.PraticaSpring01.model.User;
import br.edu.pucgoias.PraticaSpring01.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)                 // 200 com o User
                .orElse(ResponseEntity.notFound().build()); // 404 se não existir
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        return ResponseEntity.ok(repository.save(user));
    }
}
