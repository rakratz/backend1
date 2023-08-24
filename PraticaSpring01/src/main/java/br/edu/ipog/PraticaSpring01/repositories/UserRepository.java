package br.edu.ipog.PraticaSpring01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import br.edu.ipog.PraticaSpring01.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
