package com.cg.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.spc.entities.Attendance;
import com.cg.spc.entities.Student;

public interface IAttendanceRepository extends JpaRepository<Attendance, Integer> {

	List<Attendance> findByStudent(Student student);

}
