package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.model.Employee;
import com.empresa.model.Task;
import com.empresa.repository.TaskRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskService.
 */
@Service
public class TaskService {

	/** The task repository. */
	@Autowired
	private TaskRepository taskRepository;
	
	/**
	 * Gets the all tasks.
	 *
	 * @return the all tasks
	 */
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	/**
	 * Creates the task.
	 *
	 * @param task the task
	 * @return the task
	 */
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	/**
	 * Gets the task by id.
	 *
	 * @param id the id
	 * @return the task by id
	 */
	public Task getTaskById(Long id) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		return optionalTask.orElse(null);
	}
	
	/**
	 * Update task.
	 *
	 * @param id the id
	 * @param task the task
	 * @return the task
	 */
	public Task updateTask(Long id, Task task) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		if (optionalTask.isPresent()) {
			task.setId(id);
			return taskRepository.save(task);
		}
		// Emitir um erro
		throw new IllegalArgumentException("Tarefa com ID" + id + "não encontrado");
	}
	
	/**
	 * Delete task.
	 *
	 * @param id the id
	 */
	public void deleteTask(Long id) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		if (optionalTask.isPresent()) {
			taskRepository.deleteById(id);
		}
		// Emitir um erro
		throw new IllegalArgumentException("Tarefa com ID" + id + "não encontrado");
	}
	
	/**
	 * Find by title.
	 *
	 * @param title the title
	 * @return the task
	 */
	public Task findByTitle(String title) {
		return taskRepository.findByTitle(title);
	}
	
	/**
	 * Find by employee.
	 *
	 * @param employee the employee
	 * @return the list
	 */
	public List<Task> findByEmployee(Employee employee){
		return taskRepository.findByEmployee(employee);
	}
}
