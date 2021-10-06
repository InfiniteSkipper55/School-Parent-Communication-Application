package com.cg.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spc.entities.Student;
import com.cg.spc.entities.StudentExamAttempt;

public interface StudentExamAttemptRepository extends JpaRepository<StudentExamAttempt, Integer> {

	@Query(value = "SELECT * FROM STUDENT_EXAM_ATTEMPT_1 WHERE STUDENT = ?1", nativeQuery =true)
	List<StudentExamAttempt> findByStudent(Student student);
	
}
