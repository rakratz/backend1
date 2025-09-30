package br.edu.pucgoias.PraticaSpring01.controllers;

import br.edu.pucgoias.PraticaSpring01.model.Department;
import br.edu.pucgoias.PraticaSpring01.repository.DepartmentRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository repository;

    public DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department dpt) {
        return ResponseEntity.ok(repository.save(dpt));
    }

    // READ - listar todos
    @GetMapping
    public ResponseEntity<List<Department>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    // READ - por id
    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - atualizar campos (aqui só name)
    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department body) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(body.getName());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        try {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            // Caso haja usuários vinculados ao departamento (FK), retorna 409
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
