package com.cg.spc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spc.entities.Fee;
import com.cg.spc.entities.Student;

public interface FeeRepository extends JpaRepository<Fee, Integer> {

	@Query(value = "SELECT * FROM FEE_1 WHERE STUDENT = ?1", nativeQuery =true)
	Fee findByStudent(Student student);

	@Query(value = "SELECT * FROM FEE_1 WHERE STUDENT = ?1", nativeQuery =true)
	List<Fee> findByStudentId(Student student);

	@Query(value = "SELECT * FROM FEE_1 WHERE STARTING_MONTH = ?1", nativeQuery =true)
	List<Fee> findByDate(Date startMonthYear);
	

}
