package br.kratz.SpringPratica04.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.kratz.SpringPratica04.Model.User.User;
import br.kratz.SpringPratica04.Model.User.UserDTO;
import br.kratz.SpringPratica04.Service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    // A anotação @Autowired injeta a instância de UserService no controlador.

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        // Define um método de endpoint HTTP POST que permite criar um novo usuário.

        User newUser = service.createUser(user);
        // Chama o serviço para criar um novo usuário com base nos dados fornecidos no UserDTO.

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        // Retorna uma resposta HTTP com o novo usuário criado e um status de resposta "CREATED" (201).
    }
    
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
    	List<User> users = this.service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
        
    }
}
