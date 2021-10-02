package com.cg.spc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.Student;
import com.cg.spc.service.IStudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private IStudentService studentService;
	
	public StudentController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student s) {
		return studentService.updateStudent(s);
	}
	
	@DeleteMapping("/students/{userId}")
	public Student deleteStudent(@PathVariable long userId) {
		return studentService.deleteStudent(userId);
	}
	
	@GetMapping("/students")
	public List<Student> retrieveAllStudents(){
		return studentService.retrieveAllStudents();
	}
	
	@GetMapping("/students/{userId}")
	public Optional<Student> retrieveStudentById(@PathVariable long userId) {
		return studentService.retrieveStudentById(userId);
	}

}
