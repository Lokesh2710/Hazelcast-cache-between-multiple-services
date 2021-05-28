package com.jocata.get.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.get.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByName(String name);

}