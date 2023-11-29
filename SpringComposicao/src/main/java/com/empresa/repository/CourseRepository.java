package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
