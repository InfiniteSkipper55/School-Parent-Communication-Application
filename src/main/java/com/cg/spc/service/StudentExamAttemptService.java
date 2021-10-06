package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import com.cg.spc.entities.StudentExamAttempt;

public interface StudentExamAttemptService {
	public StudentExamAttempt addStudentExamAttempt(StudentExamAttempt sea);
	public StudentExamAttempt updateStudentExamAttempt(StudentExamAttempt sea);
	public StudentExamAttempt deleteStudentExamAttempt(int studentExamAttemptId);
	public List<StudentExamAttempt> retrieveAllStudentExamAttemptByStudent(long userId);
	public Optional<StudentExamAttempt> retrieveStudentExamAttemptById(int studentExamAttemptId);

}
