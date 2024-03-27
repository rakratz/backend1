package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.model.Employee;
import com.empresa.model.Task;

// TODO: Auto-generated Javadoc
/**
 * The Interface TaskRepository.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	/**
	 * Find by title.
	 *
	 * @param title the title
	 * @return the task
	 */
	Task findByTitle(String title);
    
    /**
     * Find by employee.
     *
     * @param employee the employee
     * @return the list
     */
    List<Task> findByEmployee(Employee employee);
}
