package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empresa.model.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeRepository.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    /**
     * Find by name.
     *
     * @param name the name
     * @return the employee
     */
    Employee findByName(String name);
    
    /**
     * Find by email.
     *
     * @param email the email
     * @return the employee
     */
    Employee findByEmail(String email);
}
