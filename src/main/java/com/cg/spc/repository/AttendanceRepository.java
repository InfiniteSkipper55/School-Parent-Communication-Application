package com.cg.spc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spc.entities.Attendance;
import com.cg.spc.entities.Student;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

	@Query(value = "SELECT * FROM ATTENDANCE WHERE DATE_OF_CLASS = ?1", nativeQuery =true)
	List<Attendance> findByDate(Date date);

	@Query(value = "SELECT * FROM ATTENDANCE WHERE STUDENT = ?1", nativeQuery =true)
	List<Attendance> findByStudentId(Student student);

}
