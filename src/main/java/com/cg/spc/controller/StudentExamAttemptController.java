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

import com.cg.spc.entities.StudentExamAttempt;
import com.cg.spc.service.StudentExamAttemptService;

@RestController
@RequestMapping("/api")
public class StudentExamAttemptController {
	@Autowired
	private StudentExamAttemptService studentExamAttemptService;
	
	public StudentExamAttemptController(StudentExamAttemptService studentExamAttemptService) {
		super();
		this.studentExamAttemptService = studentExamAttemptService;
	}

	@PostMapping("/studentexamattempts")
	public StudentExamAttempt addStudentExamAttempt(@RequestBody StudentExamAttempt studentExamAttempt) {
		return studentExamAttemptService.addStudentExamAttempt(studentExamAttempt);
	}
	
	@PutMapping("/studentexamattempts")
	public StudentExamAttempt updateStudentExamAttempt(@RequestBody StudentExamAttempt studentExamAttempt) {
		return studentExamAttemptService.updateStudentExamAttempt(studentExamAttempt);
	}
	
	@DeleteMapping("/studentexamattempts/{studentExamAttemptId}")
	public StudentExamAttempt deleteStudentExamAttempt(@PathVariable int studentExamAttemptId) {
		return studentExamAttemptService.deleteStudentExamAttempt(studentExamAttemptId);
	}
	
	@GetMapping("/studentexamattempts/{userId}")
	public List<StudentExamAttempt> retrieveAllStudentExamAttemptByStudent(@PathVariable long userId){
		return studentExamAttemptService.retrieveAllStudentExamAttemptByStudent(userId);
	}
	
	@GetMapping("/studentexamattempts/{studentExamAttemptId}")
	public Optional<StudentExamAttempt> retrieveStudentExamAttemptById(@PathVariable int studentExamAttemptId) {
		return studentExamAttemptService.retrieveStudentExamAttemptById(studentExamAttemptId);
	}

}
