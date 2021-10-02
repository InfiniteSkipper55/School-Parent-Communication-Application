package com.cg.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spc.entities.Concern;
import com.cg.spc.entities.Parent;

public interface IConcernRepository extends JpaRepository<Concern, Integer> {

	List<Concern> findByParent(Parent parent);

}
