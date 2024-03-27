package com.empresa.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class Task.
 */
@Entity
public class Task {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The title. */
	private String title;
	
	/** The description. */
	private String description;
	
	/** The date start. */
	private Date dateStart;
	
	/** The date end. */
	private Date dateEnd;
	
	/** The status. */
	private String status;
	
	/** The employee. */
	@ManyToOne
	private Employee employee;

	/**
	 * Instantiates a new task.
	 */
	public Task() {
	}
	


	/**
	 * Gets the date start.
	 *
	 * @return the date start
	 */
	public Date getDateStart() {
		return dateStart;
	}



	/**
	 * Sets the date start.
	 *
	 * @param dateStart the new date start
	 */
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}



	/**
	 * Gets the date end.
	 *
	 * @return the date end
	 */
	public Date getDateEnd() {
		return dateEnd;
	}



	/**
	 * Sets the date end.
	 *
	 * @param dateEnd the new date end
	 */
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}



	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}



	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}



	/**
	 * Instantiates a new task.
	 *
	 * @param id the id
	 * @param title the title
	 * @param description the description
	 * @param dateStart the date start
	 * @param dateEnd the date end
	 * @param status the status
	 * @param employee the employee
	 */
	public Task(Long id, String title, String description, Date dateStart, Date dateEnd, String status,
			Employee employee) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.status = status;
		this.employee = employee;
	}



	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
