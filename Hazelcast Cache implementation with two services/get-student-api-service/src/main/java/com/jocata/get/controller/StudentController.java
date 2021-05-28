package com.jocata.get.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.get.model.Student;
import com.jocata.get.repository.StudentRepository;

@RestController
@RequestMapping(path = "students")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private Map<String, Student> accountMap;
	
	/*@PostMapping("/add")
	public void createStudent(@RequestBody Student student) {
	    //save user account in cache
		accountMap.put(student.getName(), student);
		studentRepository.save(student);
	}*/

	@GetMapping(path = { "/get/{name}" })
	public Student getStudent(@PathVariable("name") String name) {
		//first check if accountMap has the userAccount details, if yes then return it. Else fetch it from database.
		Student student = (accountMap.get(name) != null) ? accountMap.get(name)
				: studentRepository.findByName(name);
		return student;
	}

}
