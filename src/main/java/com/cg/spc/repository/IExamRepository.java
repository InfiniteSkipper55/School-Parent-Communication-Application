package com.cg.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spc.entities.ClassId;
import com.cg.spc.entities.Exam;

public interface IExamRepository extends JpaRepository<Exam, Integer> {

	List<Exam> findByClassId(ClassId classId);
	

}
