package br.edu.ipog.PraticaSpring02.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ipog.PraticaSpring02.model.Student;
import br.edu.ipog.PraticaSpring02.repository.StudentRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "school")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@OpenAPIDefinition(info = @Info(title = "Students API", version = "1.0", description = "Students Information"))
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public ResponseEntity<Page<Student>> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable) {
        return new ResponseEntity<>(studentRepository.findAll(pageable), HttpStatus.OK);

    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getById(@PathVariable(value = "id") UUID id) {
        Optional<Student> studentO = studentRepository.findById(id);
        if (studentO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentO.get(), HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> save(@RequestBody @Valid Student student) {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id) {
        Optional<Student> productO
                = studentRepository.findById(id);
        if (productO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentRepository.delete(productO.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> update(@PathVariable(value = "id") UUID id,
                    @RequestBody @Valid Student student) {
        Optional<Student> studentO = studentRepository.findById(id);
        if (studentO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        student.setId(id);
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
