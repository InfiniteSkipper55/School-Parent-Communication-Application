package com.cg.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spc.entities.ClassId;
import com.cg.spc.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(value = "SELECT * FROM STUDENT_1 WHERE CURRENT_CLASS = ?1", nativeQuery =true)
	Student findByStudent(ClassId classId);

}
