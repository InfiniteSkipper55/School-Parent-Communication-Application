package com.cg.spc.controller;

import java.util.Date;
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

import com.cg.spc.entities.Exam;
import com.cg.spc.service.ExamService;

@RestController
@RequestMapping("/api")
public class ExamController {
	@Autowired
	private ExamService examService;
	
	public ExamController(ExamService examService) {
		super();
		this.examService = examService;
	}

	@PostMapping("/exams")
	public Exam addExam(@RequestBody Exam exam) {
		return examService.addExam(exam);
	}
	
	@DeleteMapping("/exams/{examId}")
	public Exam deleteExam(@PathVariable int examId) {
		return examService.deleteExam(examId);
	}
	
	@PutMapping("/exams")
	public Exam updateExam(@RequestBody Exam exam) {
		return examService.updateExam(exam);
	}
	
	@GetMapping("/exams")
	public List<Exam> listAllExamsByDate(@RequestBody Date dateOfExam){
		return examService.listAllExamsByDate(dateOfExam);
	}
	
	@GetMapping("/exams/{classId}")
	public List<Exam> listAllExamsByClass(@PathVariable long classId){
		return examService.listAllExamsByClass(classId);
	}
	
	@GetMapping("/exams/{examId}")
	public Optional<Exam> listExamById(@PathVariable int examId) {
		return examService.listExamById(examId);
	}

}
