package com.cg.spc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spc.entities.ClassId;
import com.cg.spc.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

	@Query(value = "SELECT * FROM EXAM_1 WHERE CLASS_ID = ?1", nativeQuery =true)
	List<Exam> findByClassId(ClassId classId);

	@Query(value = "SELECT * FROM EXAM_1 WHERE DATE_OF_EXAM = ?1", nativeQuery =true)
	List<Exam> findByDate(Date dateOfExam);	

}
