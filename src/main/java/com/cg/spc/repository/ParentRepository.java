package com.cg.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spc.entities.Parent;
import com.cg.spc.entities.Student;

public interface ParentRepository extends JpaRepository<Parent, Integer> {

	@Query(value = "SELECT * FROM PARENT_1 WHERE STUDENT = ?1", nativeQuery =true)
	List<Parent> findByFee(Student student);
	

}
