package br.edu.pucgoias.PraticaSpring01.repository;

import br.edu.pucgoias.PraticaSpring01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByDepartment_Name(String name); 
}
