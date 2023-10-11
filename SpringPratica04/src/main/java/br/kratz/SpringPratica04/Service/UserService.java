package br.kratz.SpringPratica04.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.kratz.SpringPratica04.Model.User.User;
import br.kratz.SpringPratica04.Model.User.UserDTO;
import br.kratz.SpringPratica04.Model.User.UserType;
import br.kratz.SpringPratica04.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    // A anotação @Autowired injeta a instância de UserRepository no serviço.

    public void saveUser(User user) {
        this.repository.save(user);
        // Método para salvar um objeto User no repositório (banco de dados).
    }

    public User createUser(UserDTO user) {
        User newUser = new User(user);
        // Cria um novo objeto User com base nos dados de um UserDTO.

        this.saveUser(newUser);
        // Chama o método saveUser para salvar o novo usuário no banco de dados.

        return newUser;
        // Retorna o novo usuário criado.
    }
    
    public List<User> getAllUsers(){
    	return this.repository.findAll();
    }
    
    public User findUserById(Long id) throws Exception {
        User user = this.repository.findById(id).orElse(null);
        if (user == null) {
            throw new Exception("Usuário não encontrado");
        }
        return user;
    }
    
    public boolean validateUser(User payer, BigDecimal amount) throws Exception{
		if (payer.getUserType() == UserType.MERCHANT) {
			throw new Exception("Um Lojista não pode realizar essa transação.");
		}
		
		if (payer.getBalance().compareTo(amount) < 0) {
			throw new Exception("Saldo do usuário insuficiente.");
		}
		
		return true;
	}

}
