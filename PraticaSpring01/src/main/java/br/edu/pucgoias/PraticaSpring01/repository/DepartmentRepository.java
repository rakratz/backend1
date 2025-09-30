package br.edu.pucgoias.PraticaSpring01.repository;

import br.edu.pucgoias.PraticaSpring01.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> { 
	
	
}
