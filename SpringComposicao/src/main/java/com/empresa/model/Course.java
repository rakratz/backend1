package com.empresa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course_tb")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }
    
    // Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


    
    
}

