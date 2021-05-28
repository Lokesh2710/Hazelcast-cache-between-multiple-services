package com.jocata.put.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.put.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByName(String name);

}