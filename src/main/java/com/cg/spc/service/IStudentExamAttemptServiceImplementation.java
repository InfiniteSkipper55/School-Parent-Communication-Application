package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Student;
import com.cg.spc.entities.StudentExamAttempt;
import com.cg.spc.repository.StudentExamAttemptRepository;
import com.cg.spc.repository.StudentRepository;

@Service
public class IStudentExamAttemptServiceImplementation implements StudentExamAttemptService {
	@Autowired
	private StudentExamAttemptRepository studentExamAttemptRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentExamAttempt addStudentExamAttempt(StudentExamAttempt studentExamAttempt) {
		Student student  = studentExamAttempt.getStudent();
		if(student != null) {
			long studentId = student.getUserId();
			Optional<Student> studentContainer = studentRepository.findById(studentId);
			if(studentContainer.isPresent()) {
				studentExamAttempt.setStudent(studentContainer.get());
			}
		}
		return studentExamAttemptRepository.save(studentExamAttempt);
	}

	@Override
	public StudentExamAttempt updateStudentExamAttempt(StudentExamAttempt studentExamAttempt) {
		Optional<StudentExamAttempt> existingStudentExamAttemptContainer = studentExamAttemptRepository.findById(studentExamAttempt.getStudentExamAttemptId());
		if (existingStudentExamAttemptContainer.isPresent()) {
			studentExamAttemptRepository.saveAndFlush(studentExamAttempt);
		}
		return studentExamAttempt;
	}

	@Override
	public StudentExamAttempt deleteStudentExamAttempt(int studentExamAttemptId) {
		Optional<StudentExamAttempt> existingStudentExamAttemptContainer = studentExamAttemptRepository.findById(studentExamAttemptId);
		StudentExamAttempt existingStudentExamAttempt = null;
		if (existingStudentExamAttemptContainer.isPresent()) {
			existingStudentExamAttempt = existingStudentExamAttemptContainer.get();
			studentExamAttemptRepository.deleteById(studentExamAttemptId);
		}
		return existingStudentExamAttempt;
	}

	@Override
	public List<StudentExamAttempt> retrieveAllStudentExamAttemptByStudent(long userId) {
		Optional<Student> student = studentRepository.findById(userId);
		if(student.isPresent()) {
			return studentExamAttemptRepository.findByStudent(student.get());	
		}
		return null;
	}

	@Override
	public Optional<StudentExamAttempt> retrieveStudentExamAttemptById(int studentExamAttemptId) {
		return studentExamAttemptRepository.findById(studentExamAttemptId);
	}
	

}
