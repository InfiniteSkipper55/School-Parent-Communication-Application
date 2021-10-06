package com.cg.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spc.entities.Concern;
import com.cg.spc.entities.Parent;

public interface ConcernRepository extends JpaRepository<Concern, Integer> {

	@Query(value = "SELECT * FROM CONCERN_1 WHERE PARENT = ?1", nativeQuery =true)
	List<Concern> findByParent(Parent parent);
	
	@Query(value = "SELECT * FROM CONCERN_1 WHERE PARENT = ?1", nativeQuery =true)
	Concern findByParent1(Parent parent);

}
