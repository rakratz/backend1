package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

}
