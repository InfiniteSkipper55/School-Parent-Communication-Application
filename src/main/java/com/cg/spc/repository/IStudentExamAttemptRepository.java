package com.cg.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spc.entities.Student;
import com.cg.spc.entities.StudentExamAttempt;

public interface IStudentExamAttemptRepository extends JpaRepository<StudentExamAttempt, Integer> {

	List<StudentExamAttempt> findByStudent(Student student);
	
}
