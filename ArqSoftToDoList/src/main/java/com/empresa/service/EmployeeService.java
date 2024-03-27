package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.model.Employee;
import com.empresa.repository.EmployeeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeService.
 */
@Service
public class EmployeeService {
	
	/** The employee repository. */
	@Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Gets the all employees.
     *
     * @return the all employees
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Creates the employee.
     *
     * @param employee the employee
     * @return the employee
     */
    public Employee createEmployee(Employee employee) {
    	return employeeRepository.save(employee);
    }
    
    /**
     * Gets the employee by id.
     *
     * @param id the id
     * @return the employee by id
     */
    public Employee getEmployeeById(Long id) {
    	Optional<Employee> optionalEmployee = employeeRepository.findById(id);
    	return optionalEmployee.orElse(null);
    }
    
    /**
     * Update employee.
     *
     * @param id the id
     * @param employee the employee
     * @return the employee
     */
    public Employee updateEmployee(Long id, Employee employee) {
    	Optional<Employee> optionalEmployee = employeeRepository.findById(id);
    	if (optionalEmployee.isPresent()) {
    		employee.setId(id);
    		return employeeRepository.save(employee);
    	}
    	else {
    		// Emitir um erro
    		throw new IllegalArgumentException("Funcionário com ID" + id + "não encontrado");
    	}
    }
    
    /**
     * Delete employee.
     *
     * @param id the id
     */
    public void deleteEmployee(Long id) {
    	Optional<Employee> optionalEmployee = employeeRepository.findById(id);
    	if (optionalEmployee.isPresent()) {
    		employeeRepository.deleteById(id);
    	}
    	else {
    		// Emitir um erro
    		throw new IllegalArgumentException("Funcionário com ID" + id + "não encontrado");
    	}
    }
    
    /**
     * Find by name.
     *
     * @param name the name
     * @return the employee
     */
    public Employee findByName(String name) {
    	return employeeRepository.findByName(name);
    }
    
    /**
     * Find by email.
     *
     * @param email the email
     * @return the employee
     */
    public Employee findByEmail(String email) {
    	return employeeRepository.findByEmail(email);
    }
	
}
