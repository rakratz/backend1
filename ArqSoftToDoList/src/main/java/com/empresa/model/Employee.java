package com.empresa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@Entity
public class Employee {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The name. */
    private String name;
    
    /** The email. */
    private String email;
    
    /**
     * Instantiates a new employee.
     */
    public Employee() {

    }


    /**
     * Instantiates a new employee.
     *
     * @param id the id
     * @param name the name
     * @param email the email
     */
    public Employee(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
