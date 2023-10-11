package br.edu.ipog.PraticaSpring02.repository;


import br.edu.ipog.PraticaSpring02.model.*;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, UUID>{

}
