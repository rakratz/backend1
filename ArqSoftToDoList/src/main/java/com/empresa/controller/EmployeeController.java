package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.model.Employee;
import com.empresa.service.EmployeeService;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeController.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

		/** The employee service. */
		@Autowired
		private EmployeeService employeeService;
		
		/**
		 * Gets the all employees.
		 *
		 * @return the all employees
		 */
		@GetMapping
		public ResponseEntity<List<Employee>> getAllEmployees(){
			List<Employee> employees = employeeService.getAllEmployees();
			return new ResponseEntity<>(employees, HttpStatus.OK);
		}
		
		/**
		 * Creates the employee.
		 *
		 * @param employee the employee
		 * @return the response entity
		 */
		@PostMapping
		public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
			Employee createEmployee = employeeService.createEmployee(employee);
			return new ResponseEntity<>(createEmployee, HttpStatus.CREATED);
		}
		
		/**
		 * Gets the employee by id.
		 *
		 * @param id the id
		 * @return the employee by id
		 */
		@GetMapping("/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
			Employee employee = employeeService.getEmployeeById(id);
			if (employee != null) {
				return new ResponseEntity<>(employee, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		/**
		 * Update employee.
		 *
		 * @param id the id
		 * @param employee the employee
		 * @return the response entity
		 */
		@PutMapping("/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
				@RequestBody Employee employee){
			Employee updateEmployee = employeeService.updateEmployee(id, employee);
			if (updateEmployee != null) {
				return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

		/**
		 * Delete employee.
		 *
		 * @param id the id
		 * @return the response entity
		 */
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
			employeeService.deleteEmployee(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		/**
		 * Gets the employee by name.
		 *
		 * @param name the name
		 * @return the employee by name
		 */
		@GetMapping("/name/{name}")
		public ResponseEntity<Employee> getEmployeeByName(@PathVariable("name") String name){
			Employee employee = employeeService.findByName(name);
			if (employee != null) {
				return new ResponseEntity<>(employee, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		/**
		 * Gets the employee by email.
		 *
		 * @param email the email
		 * @return the employee by email
		 */
		@GetMapping("/email/{email}")
		public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable("email") String email){
			Employee employee = employeeService.findByEmail(email);
			if (employee != null) {
				return new ResponseEntity<>(employee, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
}
