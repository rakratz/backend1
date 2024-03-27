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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.model.Employee;
import com.empresa.model.Task;
import com.empresa.service.TaskService;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskController.
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	/** The task service. */
	@Autowired
	private TaskService taskService;
	
	/**
	 * Gets the all tasks.
	 *
	 * @return the all tasks
	 */
	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks(){
		List<Task> tasks = taskService.getAllTasks();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	/**
	 * Creates the task.
	 *
	 * @param task the task
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		Task createTask = taskService.createTask(task);
		return new ResponseEntity<>(createTask, HttpStatus.CREATED);
	}
	
	/**
	 * Gets the task by id.
	 *
	 * @param id the id
	 * @return the task by id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id){
		Task task = taskService.getTaskById(id);
		if (task != null) {
			return new ResponseEntity<>(task, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Update task.
	 *
	 * @param id the id
	 * @param task the task
	 * @return the response entity
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, 
			@RequestBody Task task) {
		Task updateTask = taskService.updateTask(id, task);
		if (task != null) {
			return new ResponseEntity<>(updateTask, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Delete task.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id){
		taskService.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Gets the task by title.
	 *
	 * @param title the title
	 * @return the task by title
	 */
	@GetMapping("/title/{title}")
	public ResponseEntity<Task> getTaskByTitle(@PathVariable("title") String title){
		Task task = taskService.findByTitle(title);
		if (task != null) {
			return new ResponseEntity<>(task, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Gets the tasks by employee.
	 *
	 * @param employee the employee
	 * @return the tasks by employee
	 */
	@GetMapping("/employee/{employee}")
	public ResponseEntity<List<Task>> getTasksByEmployee(
			@PathVariable("employeeid") Employee employee){
		List<Task> tasks = taskService.findByEmployee(employee);
		if (tasks != null) {
			return new ResponseEntity<>(tasks, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
