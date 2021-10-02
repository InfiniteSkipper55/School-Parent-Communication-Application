package com.cg.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.spc.entities.Fee;
import com.cg.spc.entities.Student;

public interface IFeeRepository extends JpaRepository<Fee, Integer> {

	Fee findByStudent(Fee fee);

	Fee findByStudent(Student student);
	

}
